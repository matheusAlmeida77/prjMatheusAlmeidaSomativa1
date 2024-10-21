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

import com.example.demo.entities.Pet;
import com.example.demo.services.PetService;

@RestController

//URL POSTMAN
@RequestMapping("/pets")
public class PetController {
	private final PetService petService;
	
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	//cria um novo pet
	@PostMapping
	public Pet createPet(@RequestBody Pet pet) {
		return petService.savePet(pet);
	}
	
	//traz todos os registros de pets
	@GetMapping
	public List<Pet> getAllPets(){
		return petService.getAllPets();
	}
	
	//traz somente o objeto específico pelo id
	@GetMapping("/{id}")
	public Pet getPet(@PathVariable Long id) {
		return petService.getPetById(id);
	}
	
	//deleta o objeto específico pelo id
	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable Long id) {
		petService.deletePet(id);
	}
	
	//endpoint de update
	@PutMapping("/{id}")
	public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		return petService.updatePet(id, pet);
	}
}
