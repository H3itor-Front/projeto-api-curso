package br.com.senai.entregas.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



    @Getter
    @Setter
    // Obrigatorio para JPA funcionar
    @NoArgsConstructor
    @AllArgsConstructor
    //JPA

    // Entity - Informa que essa classe é uma tabela
    @Entity
    // Table - Permite que voce configura uma tabela
    @Table(name = "tipo_usuario")
    public class TipoUsuario {

        // Id - Sempre informa que é uma chave primaria
        @Id
        // Generated Value - define que a chave é gerenciada pelo BD
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // Column - configura uma cpoluna
        // name - nome da coluna
        // nullable - se pode ser nulo ou não
        @Column(name = "tipo_usuario_id", nullable = false, columnDefinition = "TEXT")
        private int tipoUsuarioId;

        @Column(name = "descricao", nullable = false)
        private String descricao;
    }
