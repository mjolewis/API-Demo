package com.taurinustrading.graphql.controller;

import com.taurinustrading.graphql.entity.Dog;
import com.taurinustrading.graphql.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**********************************************************************************************************************
 * The DogController enables client-server communication through the HTTP protocol and GraphQL.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@RestController
@RequestMapping("/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping()
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.findAllDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> breeds = dogService.findAllDogBreeds();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/{id}/breeds")
    public ResponseEntity<String> getBreedById(@PathVariable Long id) {
        String breed = dogService.findDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> names = dogService.findAllDogNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }
}
