package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Servico;

//classe de conexão
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
