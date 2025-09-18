package br.com.senai.entregas.Service;

import br.com.senai.entregas.Repository.TipoUsuarioRepository;
import br.com.senai.entregas.Model.TipoUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
    // Injecao de Dependencia
    // Falar que Service Depende de alguém
    private TipoUsuarioRepository TipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository repo) {
        this.TipoUsuarioRepository = repo;
    }

    public List<TipoUsuario> listarTodos() {

        return TipoUsuarioRepository.findAll();
    }

    public TipoUsuario cadastrarTipoUsuario(TipoUsuario us) {
        return TipoUsuarioRepository.save(us);
    }
    public TipoUsuario buscarPorid(int id){

        return TipoUsuarioRepository.findById(id).orElse(null);
    }
    public TipoUsuario deletarTipoUsuario(int id) {
        TipoUsuario us = buscarPorid(id);
        if (us == null) {
            return null;
        }
        TipoUsuarioRepository.delete(us);
        return us;
    }
}
