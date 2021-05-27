package com.taurinustrading.dogapi.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:";

    @BeforeEach
    public void beforeEach() {
        baseUrl = baseUrl + port + "/dogs";
    }

    @Test
    public void getAllDogs() {
        ResponseEntity<List> responseEntity =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity(baseUrl, List.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllDogBreeds() {
        ResponseEntity<List> responseEntity =
                restTemplate.withBasicAuth("admin", "password")
                        .getForEntity(baseUrl + "/breeds", List.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedById() {
        ResponseEntity<String> responseEntity =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity(baseUrl + "/1/breeds", String.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getAllDogNames() {
        ResponseEntity<List> responseEntity =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity(baseUrl + "/names", List.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
