	package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {
	@Id
	//gera o valor automaticamente, não precisa inserir
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private String material_utilizado;
	private String historico;
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
		this.nome= nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getMaterialUtilizado() {
		return material_utilizado;
	}
	
	public void setMaterialUtilizado(String material_utilizado) {
		this.material_utilizado = material_utilizado;
	}
	
	public String getHistorico() {
		return historico;
	}
	
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void registrarServico() {
		
	}
	
	public void recuperarHistoricoServico() {
		
	}
}
