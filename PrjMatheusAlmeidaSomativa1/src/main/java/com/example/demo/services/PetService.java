package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Pet;
import com.example.demo.repositories.PetRepository;

@Service
public class PetService {
	private final PetRepository petRepository;
	
	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	//criação do pet
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	//buscar pet
	public Pet getPetById(Long id) {
		return petRepository.findById(id).orElse(null);
	}
	
	//procurar todos os pets
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}	
	
	//excluir os pets
	public void deletePet(Long id) {
		petRepository.deleteById(id);
	}
	
	//atualizar pet
		public Pet updatePet(Long id, Pet updatedPet) {
			//criando o optional para receber o pet
			Optional<Pet> optionalPet = petRepository.findById(id);
			if (optionalPet.isPresent()) {
				//se encontrou
				Pet existentPet = optionalPet.get();
				existentPet.setNome(updatedPet.getNome());
				existentPet.setDataNascimento(updatedPet.getDataNascimento());
				existentPet.setRaca(updatedPet.getRaca());
				existentPet.setPorte(updatedPet.getPorte());
				return petRepository.save(existentPet); 
			}else {
				//se não encontrou
				return null;
			}
		}
}
