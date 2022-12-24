package com.example.pokedex.models;

public class PokeSQL extends Pokemon {
    //attributes
    private String description;

    // constructors
    public PokeSQL(){}

    public PokeSQL(String description) {
        this.description = description;
    }

    //getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
