package br.com.senai.entregas.Repository;

import br.com.senai.entregas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface UsuarioRepository  extends JpaRepository<Usuario,Integer>{
}
