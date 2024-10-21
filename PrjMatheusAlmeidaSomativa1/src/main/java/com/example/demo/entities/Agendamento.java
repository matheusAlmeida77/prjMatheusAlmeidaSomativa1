package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
	@Id
	//gera o valor automaticamente, não precisa inserir
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	private String historico;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHistorico() {
		return historico;
	}
	
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	
	public void abrirAgenda() {
		
	}
	
	public void obterHorariosDisponiveis() {
		
	}
	
	public void registrarHorario() {
		
	}
}
