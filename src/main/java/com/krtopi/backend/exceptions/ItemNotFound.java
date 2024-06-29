package com.krtopi.backend.exceptions;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(Long id) {
        super("Could not find with id " + id);
    }
}
