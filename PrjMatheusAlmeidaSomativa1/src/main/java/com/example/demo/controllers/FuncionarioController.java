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

import com.example.demo.entities.Funcionario;
import com.example.demo.services.FuncionarioService;

@RestController

//URL POSTMAN
@RequestMapping("/funcionarios")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	//cria um novo funcionario
	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}
	
	//traz todos os registros de funcionarios
	@GetMapping
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioService.getAllFuncionarios();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Funcionario getFuncionario(@PathVariable Long id) {
		return funcionarioService.getFuncionarioById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionario(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return funcionarioService.updateFuncionario(id, funcionario);
	}
}
