package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	//criação do produto 
	public Cliente saveCliente(Cliente client) {
		return clienteRepository.save(client);
	}
	
	//buscar produto
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	//procurar todos os produtos
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll();
	}	
	
	//excluir os produtos
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	//atualizar fornecedor
		public Cliente updateCliente(Long id, Cliente updatedCliente) {
			//criando o optional para receber o produto
			Optional<Cliente> optionalCliente = clienteRepository.findById(id);
			if (optionalCliente.isPresent()) {
				//se encontrou
				Cliente existentCliente = optionalCliente.get();
				existentCliente.setNome(updatedCliente.getNome());
				existentCliente.setCpf(updatedCliente.getCpf());
				existentCliente.setDataNascimento(updatedCliente.getDataNascimento());
				existentCliente.setEndereco(updatedCliente.getEndereco());
				existentCliente.setTelefone(updatedCliente.getTelefone());
				return clienteRepository.save(existentCliente); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
