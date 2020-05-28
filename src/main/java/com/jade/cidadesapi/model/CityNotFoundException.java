package com.jade.cidadesapi.model;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String id) {
        super("A cidade referente ao id " + id + " não foi encontrada");
    }
}
