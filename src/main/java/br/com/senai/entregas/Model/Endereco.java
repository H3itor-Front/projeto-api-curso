package br.com.senai.entregas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;
import org.hibernate.annotations.ManyToAny;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private int enderecoId;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "cidade", nullable = false, columnDefinition = "TEXT")
    private String cidade;

    @Column(name = "cep ", nullable = false,length = 15)
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
