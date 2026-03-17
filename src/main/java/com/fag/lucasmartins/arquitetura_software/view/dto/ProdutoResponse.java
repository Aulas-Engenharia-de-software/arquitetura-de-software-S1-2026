package com.fag.lucasmartins.arquitetura_software.view.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoResponse {
    private String mensagem;
    private String nome;
    private Integer estoque;
    private double preco;
    @JsonProperty("preco_final")
    private double precoFinal;
}
