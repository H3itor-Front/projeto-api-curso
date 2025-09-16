package br.com.senai.entregas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_entregas")
public class Entregas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculos_id", nullable = false)
    private int veiculosId;

    @Column(name = "DescricaoProduto ", nullable = false, columnDefinition = "TEXT")
    private String DescricaoProduto ;

    @Column(name = "DataPedido", nullable = false, columnDefinition = "TEXT")
    private String DataPedido;

    @Column(name = "Status", nullable = false, columnDefinition = "TEXT")
    private String Status;

    @ManyToAny(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private Endereco Endereco;

    @ManyToAny(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario Usuario;



}
