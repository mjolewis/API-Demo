package com.taurinustrading.graphql.exception.graphqlexception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * The DogNotFoundException implements custom exception handling for clients that issue non-resolvable requests from
 * a GraphQL API.
 *
 * @author Michael Lewis
 *********************************************************************************************************************/
public class DogNotFoundException extends RuntimeException implements GraphQLError {
    private final Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException() {}

    public DogNotFoundException(String message, Long invalidDogId) {
        super(message);
        extensions.put("invalidDogId", invalidDogId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
