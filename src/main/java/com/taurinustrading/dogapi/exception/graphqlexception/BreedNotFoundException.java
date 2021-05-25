package com.taurinustrading.dogapi.exception.graphqlexception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * The BreedNotFoundException implements custom exception handling for clients that issue invalid breed requests from
 * a GraphQL API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
public class BreedNotFoundException extends RuntimeException implements GraphQLError {
    private final Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String invalidBreed) {
        super(message);
        extensions.put("invalidDogBreed", invalidBreed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
