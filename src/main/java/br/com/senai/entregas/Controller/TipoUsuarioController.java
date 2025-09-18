package br.com.senai.entregas.Controller;

import br.com.senai.entregas.Model.TipoUsuario;
import br.com.senai.entregas.Service.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TipoUsuario")
@Tag(name = "Controller de TipoUsuario", description = "Metodos de TipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService TipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService service) {
        TipoUsuarioService = service;
    }

    // Listar Todos
    @GetMapping
    @Operation(summary = "Lista todos os clientes", description = "Listar todos os TiposUsuarios sem nenhuma restricãoxwads")
    public ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        // 1. Pegar a Lista de clientes
        List<TipoUsuario> Tipousuarios = TipoUsuarioService.listarTodos();

        return ResponseEntity.ok(Tipousuarios);
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario usuario) {


        usuario = TipoUsuarioService.cadastrarTipoUsuario(usuario);

        // Codigo 200 - OK
//        return ResponseEntity.ok(cliente);

        // Codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTipoUsuarioPorId(@PathVariable int id) {
        TipoUsuario us = TipoUsuarioService.buscarPorid(id);

        if (us == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoUsuario " + id + "não encontrado");
        }
        return ResponseEntity.ok(us);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletarUsuario(@PathVariable int id) {
        TipoUsuario us = TipoUsuarioService.deletarTipoUsuario(id);

        if (us == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + " Não encontrado");
        }
        return ResponseEntity.ok(us);
    }
}