package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pet;

//classe de conexão
public interface PetRepository extends JpaRepository<Pet, Long>{

}
