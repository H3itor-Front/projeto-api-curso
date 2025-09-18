package br.com.senai.entregas.Service;

import br.com.senai.entregas.Repository.UsuarioRepository;
import br.com.senai.entregas.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private UsuarioRepository UsuarioRepository;

    public UsuarioService(UsuarioRepository repo) {
        this.UsuarioRepository = repo;
    }

    public List<Usuario> listarTodos() {

        return UsuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario us) {
        return UsuarioRepository.save(us);
    }
    public Usuario buscarPorid(int id){

        return UsuarioRepository.findById(id).orElse(null);
    }
    public Usuario deletarUsuario(int id) {
        Usuario us = buscarPorid(id);
        if (us == null) {
            return null;
        }
        UsuarioRepository.delete(us);
        return us;
    }
}
