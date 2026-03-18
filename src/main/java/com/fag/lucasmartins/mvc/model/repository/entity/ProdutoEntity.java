package com.fag.lucasmartins.mvc.model.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "produto")
public class ProdutoEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;
private Double preco;
private Double precoFinal;
private Integer estoque;


public ProdutoEntity() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
public Double getPreco() { return preco; }
public void setPreco(Double preco) { this.preco = preco; }
public Double getPrecoFinal() { return precoFinal; }
public void setPrecoFinal(Double precoFinal) { this.precoFinal = precoFinal; }
public Integer getEstoque() { return estoque; }
public void setEstoque(Integer estoque) { this.estoque = estoque; }
}