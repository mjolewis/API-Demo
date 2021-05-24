package com.taurinustrading.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.taurinustrading.graphql.entity.Dog;
import com.taurinustrading.graphql.repository.DogRepository;
import com.taurinustrading.graphql.exception.graphqlexception.BreedNotFoundException;
import com.taurinustrading.graphql.exception.graphqlexception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**********************************************************************************************************************
 * The Mutation component implements the mutating actions that a client can request from the GraphQL API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@Component
public class Mutation implements GraphQLMutationResolver {
    private final DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> dogs = dogRepository.findAll();

        for (Dog dog : dogs) {
            if (dog.getBreed().equals(breed)) {
                dogRepository.delete(dog);
                deleted = true;
            }
        }

        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return deleted;
    }

    public Dog updateDogName(String name, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}