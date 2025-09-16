package br.com.senai.entregas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false, columnDefinition = "TEXT")
    private int usuarioId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    // Muitos usuarios para 1 tipo
    // FetchType.EAGER - Carrega os dados juntos
    //OPtional - se é obrigatorio ou nao
    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

}
