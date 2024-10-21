package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Produto;

//classe de conexão
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
