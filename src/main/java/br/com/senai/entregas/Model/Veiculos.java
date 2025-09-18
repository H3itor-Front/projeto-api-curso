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
@Table(name = "tipo_veiculos")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculos_id", nullable = false)
    private int veiculosId;

    @Column(name = "placa", nullable = false, columnDefinition = "TEXT", unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false, columnDefinition = "TEXT")
    private String modelo;

    @Column(name = "tipo", nullable = false, columnDefinition = "TEXT")
    private String tipo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "entregador_id")
    private Entregas entregador;

}