package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	//criação do funcionario
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	//buscar funcionario
	public Funcionario getFuncionarioById(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	//procurar todos os funcionarios
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioRepository.findAll();
	}	
	
	//excluir os funcionarios
	public void deleteFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	//atualizar funcionario
		public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
			//criando o optional para receber o funcionario
			Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
			if (optionalFuncionario.isPresent()) {
				//se encontrou
				Funcionario existentFuncionario = optionalFuncionario.get();
				existentFuncionario.setNome(updatedFuncionario.getNome());
				existentFuncionario.setDataNascimento(updatedFuncionario.getDataNascimento());
				existentFuncionario.setCpf(updatedFuncionario.getCpf());
				existentFuncionario.setTelefone(updatedFuncionario.getTelefone());
				existentFuncionario.setDataEntrada(updatedFuncionario.getDataEntrada());
				existentFuncionario.setEducacao(updatedFuncionario.getEducacao());
				existentFuncionario.setCertificacao(updatedFuncionario.getCertificacao());
				return funcionarioRepository.save(existentFuncionario); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
