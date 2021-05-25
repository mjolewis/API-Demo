package com.taurinustrading.dogapi.exception.restexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**********************************************************************************************************************
 * The DogNotFoundException implements custom exception handling for REST clients that issue non-resolvable requests.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog Not Found")
public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException() {}

    public DogNotFoundException(String message) {
        super(message);
    }
}
