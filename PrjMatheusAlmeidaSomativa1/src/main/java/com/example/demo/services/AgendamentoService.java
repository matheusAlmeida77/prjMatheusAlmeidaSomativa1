package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Agendamento;
import com.example.demo.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	private final AgendamentoRepository agendamentoRepository;
	
	@Autowired
	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}
	
	//criação do agendamento
	public Agendamento saveAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}
	
	//buscar agendamento
	public Agendamento getAgendamentoById(Long id) {
		return agendamentoRepository.findById(id).orElse(null);
	}
	
	//procurar todos os agendamentos
	public List<Agendamento> getAllAgendamentos(){
		return agendamentoRepository.findAll();
	}	
	
	//excluir os agendamentos
	public void deleteAgendamento(Long id) {
		agendamentoRepository.deleteById(id);
	}
	
	//atualizar agendamento
		public Agendamento updateAgendamento(Long id, Agendamento updatedAgendamento) {
			//criando o optional para receber o agendamento
			Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(id);
			if (optionalAgendamento.isPresent()) {
				//se encontrou
				Agendamento existentAgendamento = optionalAgendamento.get();
				existentAgendamento.setData(updatedAgendamento.getData());
				existentAgendamento.setHistorico(updatedAgendamento.getHistorico());
				return agendamentoRepository.save(existentAgendamento); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
