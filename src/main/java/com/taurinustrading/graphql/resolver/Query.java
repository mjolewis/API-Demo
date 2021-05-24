package com.taurinustrading.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.taurinustrading.graphql.entity.Dog;
import com.taurinustrading.graphql.repository.DogRepository;
import com.taurinustrading.graphql.exception.graphqlexception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**********************************************************************************************************************
 * The Query component implements the queries that clients can request from the GraphQL API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@Component
public class Query implements GraphQLQueryResolver {
    private final DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

    public List<String> findAllDogBreeds() {
        return dogRepository.findAllDogBreeds();
    }

    public String findDogBreedById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            return optionalDog.get().getBreed();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

    public List<String> findAllDogNames() {
        return dogRepository.findAllDogNames();
    }
}