package com.taurinustrading.dogapi.exception.restexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**********************************************************************************************************************
 * The BreedNotFoundException implements custom exception handling for clients that issue invalid breed requests from
 * a REST API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Breed Not Found")
public class BreedNotFoundException extends RuntimeException {
    public BreedNotFoundException() {}

    public BreedNotFoundException(String message) {
        super(message);
    }
}
