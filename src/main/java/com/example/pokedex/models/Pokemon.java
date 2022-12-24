package com.example.pokedex.models;

public class Pokemon {

    //attributes
    private String id;
    private String name;
    private String height;
    private String weight;

    // constructors
    public Pokemon(){}

    public Pokemon(String id, String name, String height, String weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}