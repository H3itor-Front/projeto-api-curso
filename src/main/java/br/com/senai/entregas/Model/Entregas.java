package br.com.senai.entregas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.time.OffsetDateTime;


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

    @Column(name = "descricao-produto ", nullable = false, columnDefinition = "TEXT")
    private String descricaoproduto ;

    @Column(name = "data-pedido", nullable = false)
    private OffsetDateTime datapedido;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



}
