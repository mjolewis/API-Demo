package com.taurinustrading.dogapi.repository;

import com.taurinustrading.dogapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**********************************************************************************************************************
 * The DogRepository interface defines the CRUD operations that a client can request from a REST API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.id, d.breed FROM Dog d")
    List<String> findAllDogBreeds();

    @Query("SELECT d.id, d.breed FROM Dog d WHERE d.id=:id")
    String findDogBreedById(Long id);

    @Query("SELECT d.id, d.name FROM Dog d")
    List<String> findAllDogNames();
}
