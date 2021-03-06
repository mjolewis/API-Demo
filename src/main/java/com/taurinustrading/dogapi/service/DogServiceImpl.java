package com.taurinustrading.dogapi.service;

import com.taurinustrading.dogapi.entity.Dog;
import com.taurinustrading.dogapi.exception.restexception.BreedNotFoundException;
import com.taurinustrading.dogapi.repository.DogRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**********************************************************************************************************************
 * The DogServiceImpl implements the actions that a client can request from the server.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@Service
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<Dog> findAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> findAllDogBreeds() {
        return dogRepository.findAllDogBreeds();
    }

    @Override
    public String findDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogBreedById(id));
        return optionalBreed.orElseThrow(BreedNotFoundException::new);
    }

    @Override
    public List<String> findAllDogNames() {
        return dogRepository.findAllDogNames();
    }
}
