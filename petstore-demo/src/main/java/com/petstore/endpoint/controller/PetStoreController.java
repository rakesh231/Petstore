package com.petstore.endpoint.controller;

import com.petstore.endpoint.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PetStoreController {

	Logger logger = LoggerFactory.getLogger(PetStoreController.class);

	private final String URI_PETS = "/pets";
	private final String URI_PETS_ID = "/pets/{id}";

	@Autowired
	RestTemplate restTemplate;


	@GetMapping("all-pets")
	public ResponseEntity<List<Pet>> getAllPets() {
		logger.info("invoked getAllPets");
		Pet[] petsArray = restTemplate.getForObject(URI_PETS, Pet[].class);
		return new ResponseEntity<>(Arrays.asList(petsArray), HttpStatus.OK);
	}

	@GetMapping("all-pets/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable final long id) {
		logger.info("invoked getPetById with ID: "+id);
		Map<String, String> params = new HashMap<>();
		params.put("id", String.valueOf(id));
		Pet pet = restTemplate.getForObject(URI_PETS_ID, Pet.class, params);
		return new ResponseEntity<>(pet, HttpStatus.OK);
	}

	@PostMapping("pets")
	public Pet create(@RequestBody final Pet newPet) {
		Pet createdPet = restTemplate.postForObject(URI_PETS, newPet, Pet.class);
		return createdPet;
	}

	@DeleteMapping("all-pets/{id}")
	public void deletePetById(@PathVariable final long id) {
		logger.info("invoked deletePetById with ID: "+id);
		Map<String, String> params = new HashMap<>();
		params.put("id", String.valueOf(id));
		restTemplate.delete(URI_PETS_ID,  params);
		logger.info("Delete finished");
	}

}
