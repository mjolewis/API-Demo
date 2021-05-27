package com.taurinustrading.dogapi.controller;

import com.taurinustrading.dogapi.entity.Dog;
import com.taurinustrading.dogapi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for valid request format."),
        @ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code = 500, message = "The server is down. Please make sure that the service is running.")
})
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
