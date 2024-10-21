package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Servico;
import com.example.demo.repositories.ServicoRepository;

@Service
public class ServicoService {
	private final ServicoRepository servicoRepository;
	
	@Autowired
	public ServicoService(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
	}
	
	//criação do servico
	public Servico saveServico(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	//buscar servico
	public Servico getServicoById(Long id) {
		return servicoRepository.findById(id).orElse(null);
	}
	
	//procurar todos os servicos
	public List<Servico> getAllServicos(){
		return servicoRepository.findAll();
	}	
	
	//excluir os servicos
	public void deleteServico(Long id) {
		servicoRepository.deleteById(id);
	}
	
	//atualizar servico
		public Servico updateServico(Long id, Servico updatedServico) {
			//criando o optional para receber o servico
			Optional<Servico> optionalServico = servicoRepository.findById(id);
			if (optionalServico.isPresent()) {
				//se encontrou
				Servico existentServico = optionalServico.get();
				existentServico.setNome(updatedServico.getNome());
				existentServico.setDescricao(updatedServico.getDescricao());
				existentServico.setMaterialUtilizado(updatedServico.getMaterialUtilizado());
				existentServico.setHistorico(updatedServico.getHistorico());
				existentServico.setPreco(updatedServico.getPreco());
				return servicoRepository.save(existentServico); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
