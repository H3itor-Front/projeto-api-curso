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
@Table(name = "tipo_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private int enderecoId;

    @Column(name = "Logradouro", nullable = false, columnDefinition = "TEXT")
    private String Logradouro;

    @Column(name = "Numero", nullable = false, columnDefinition = "TEXT")
    private String Numero;

    @Column(name = "Cidade", nullable = false, columnDefinition = "TEXT")
    private String Cidade;

    @Column(name = "CEP ", nullable = false, columnDefinition = "TEXT")
    private String CEP;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    @JoinColumn(name = "usuario_id")
    private Usuario Usuario;

}
