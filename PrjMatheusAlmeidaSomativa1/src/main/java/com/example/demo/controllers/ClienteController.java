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

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;

@RestController

//URL POSTMAN
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	//cria um novo cliente
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}
	
	//traz todos os registros de clientes
	@GetMapping
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.updateCliente(id, cliente);
	}
}
