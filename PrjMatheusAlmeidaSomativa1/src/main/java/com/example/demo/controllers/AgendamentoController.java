package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Agendamento;
import com.example.demo.services.AgendamentoService;

@RestController

//URL POSTMAN
@RequestMapping("/agendamentos")
public class AgendamentoController {
	private final AgendamentoService agendamentoService;
	
	@Autowired
	public AgendamentoController(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}
	
	//cria um novo agendamento
	@PostMapping
	public Agendamento createAgendamento(@RequestBody Agendamento agendamento) {
		return agendamentoService.saveAgendamento(agendamento);
	}
	
	//traz todos os registros de agendamentos
	@GetMapping
	public List<Agendamento> getAllAgendamentos(){
		return agendamentoService.getAllAgendamentos();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Agendamento getAgendamento(@PathVariable Long id) {
		return agendamentoService.getAgendamentoById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deleteAgendamento(@PathVariable Long id) {
		agendamentoService.deleteAgendamento(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Agendamento updateAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
		return agendamentoService.updateAgendamento(id, agendamento);
	}
}
