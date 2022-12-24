package com.example.pokedex.services;

import java.util.Hashtable;

public interface PokservInterface {
    public Hashtable<String, String> getPoke(String pokeId);
}