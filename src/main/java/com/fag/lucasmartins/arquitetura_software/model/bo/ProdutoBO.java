package com.fag.lucasmartins.arquitetura_software.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estoque")
    private Integer estoque;

    @Column(name = "preco")
    private double preco;

    @Column(name = "preco_final")
    @JsonProperty("preco_final")
    private double precoFinal;

    public void calculateFinalPrice() {
        if (estoque >= 50) {
            precoFinal = preco * 0.90;
            return;
        }
        precoFinal = preco;
    }
}
