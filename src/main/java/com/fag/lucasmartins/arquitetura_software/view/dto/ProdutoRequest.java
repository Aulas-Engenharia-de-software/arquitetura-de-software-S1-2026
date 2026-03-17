package com.fag.lucasmartins.arquitetura_software.view.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String nome;
    private Integer estoque;
    private double preco;
}
