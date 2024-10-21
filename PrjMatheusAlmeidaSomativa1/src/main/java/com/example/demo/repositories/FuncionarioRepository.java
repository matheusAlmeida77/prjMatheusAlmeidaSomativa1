package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Funcionario;

//classe de conexão
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
