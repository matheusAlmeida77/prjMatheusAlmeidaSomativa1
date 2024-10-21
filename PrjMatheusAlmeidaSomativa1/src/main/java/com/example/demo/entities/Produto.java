package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	//gera o valor automaticamente, não precisa inserir
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int quantidade_estoque;
	private float preco;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidadeEmEstoque() {
		return quantidade_estoque;
	}
	
	public void setQuantidadeEmEstoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void obterQuantidadeEmEstoque() {
		
	}
	
	public void verificarPromocoes() {
		
	}
}
