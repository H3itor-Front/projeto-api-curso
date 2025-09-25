package br.com.senai.entregas.Service;

import br.com.senai.entregas.Repository.UsuarioRepository;
import br.com.senai.entregas.Model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository UsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.UsuarioRepository = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarTodos() {

        return UsuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario u) {

        String senhaCriptografada = passwordEncoder.encode(u.getSenha());
        u.setSenha(senhaCriptografada);

        return UsuarioRepository.save(u);
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
