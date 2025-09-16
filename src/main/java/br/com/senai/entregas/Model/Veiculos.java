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

    @Column(name = "Placa", nullable = false, columnDefinition = "TEXT")
    private String Placa;

    @Column(name = "Modelo", nullable = false, columnDefinition = "TEXT")
    private String Modelo;

    @Column(name = "Tipo", nullable = false, columnDefinition = "TEXT")
    private String Tipo;

    @ManyToAny(fetch = FetchType.EAGER)
    @JoinColumn(name = "entregador_id")
    private Entregas Entregador;

}
