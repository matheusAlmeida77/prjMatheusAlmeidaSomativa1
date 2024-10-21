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

import com.example.demo.entities.Servico;
import com.example.demo.services.ServicoService;

@RestController

//URL POSTMAN
@RequestMapping("/servicos")
public class ServicoController {
	private final ServicoService servicoService;
	
	@Autowired
	public ServicoController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	//cria um novo servico
	@PostMapping
	public Servico createServico(@RequestBody Servico servico) {
		return servicoService.saveServico(servico);
	}
	
	//traz todos os registros de servicos
	@GetMapping
	public List<Servico> getAllServicos(){
		return servicoService.getAllServicos();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Servico getServico(@PathVariable Long id) {
		return servicoService.getServicoById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable Long id) {
		servicoService.deleteServico(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Servico updateServico(@PathVariable Long id, @RequestBody Servico servico) {
		return servicoService.updateServico(id, servico);
	}
}
