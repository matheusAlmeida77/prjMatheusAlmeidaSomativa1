package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	//gera o valor automaticamente, não precisa inserir
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String setor;
	private String data_nascimento;
	private String cpf;
	private String telefone;
	private String data_entrada;
	private String educacao;
	private String certificacao;
	
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
	
	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getDataNascimento() {
		return data_nascimento;
	}
	
	public void setDataNascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getDataEntrada() {
		return data_entrada;
	}
	
	public void setDataEntrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public String getCertificacao() {
		return certificacao;
	}
	
	public void setCertificacao(String certificacao) {
		this.certificacao = certificacao;
	}
}
