package org.mps.person;

public class ImpossibleAgeException extends RuntimeException{
    public ImpossibleAgeException(String errorMessage){
        super(errorMessage);
    }
}
