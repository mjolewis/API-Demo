package com.taurinustrading.graphql.service;

import com.taurinustrading.graphql.entity.Dog;

import java.util.List;

/**********************************************************************************************************************
 * The DogService interface defines the actions that a REST client can request from the server.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
public interface DogService {
    List<Dog> findAllDogs();
    List<String> findAllDogBreeds();
    String findDogBreedById(Long id);
    List<String> findAllDogNames();
}
