package org.mps.person;

public class EmptyListException extends RuntimeException{
    public EmptyListException(String errorMessage){
        super(errorMessage);
    }
}
