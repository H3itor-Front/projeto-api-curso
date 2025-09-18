package br.com.senai.entregas.Controller;

import br.com.senai.entregas.Model.Usuario;
import br.com.senai.entregas.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Controller de usuario", description = "Metodos de usuario")
public class UsuarioController {

    private final UsuarioService UsuarioService;

    public UsuarioController(UsuarioService service) {
        UsuarioService = service;
    }

    // Listar Todos
    @GetMapping
    @Operation(summary = "Lista todos os clientes", description = "Listar todos os clientes sem nenhuma restricãoxwads")
    public ResponseEntity<List<Usuario>> listarUsuario() {
        // 1. Pegar a Lista de clientes
        List<Usuario> usuarios = UsuarioService.listarTodos();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {


        usuario = UsuarioService.cadastrarUsuario(usuario);

        // Codigo 200 - OK
//        return ResponseEntity.ok(cliente);

        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable int id) {
        Usuario us = UsuarioService.buscarPorid(id);

        if (us == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + "não encontrado");
        }
        return ResponseEntity.ok(us);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletarUsuario(@PathVariable int id) {
        Usuario us = UsuarioService.deletarUsuario(id);

        if (us == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + " Não encontrado");
        }
        return ResponseEntity.ok(us);
    }
}