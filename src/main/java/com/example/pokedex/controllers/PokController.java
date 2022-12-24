package com.example.pokedex.controllers;
import com.example.pokedex.models.PokeSQL;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokSQLService;
import com.example.pokedex.services.PokService;
import java.util.Hashtable;

public class PokController {

    // function to get pokemon using api
    public static Pokemon getPokebyId(String pokemonId, PokService pokemonService){
        Hashtable<String, String> pokedata =pokemonService.getPoke(pokemonId);
            Pokemon pokemon = new Pokemon();
            pokemon.setId(pokemonId);
            pokemon.setName(pokedata.get("name"));
            pokemon.setHeight(pokedata.get("height"));
            pokemon.setWeight(pokedata.get("weight"));
            return pokemon;
    }

    // function to get pokemon using local database
    public static Pokemon getPokebyIdSQL(String pokemonId, PokSQLService pokemonService){
        Hashtable<String, String> pokedata =pokemonService.getPoke(pokemonId);
        PokeSQL pokemon = new PokeSQL();
        pokemon.setId(pokemonId);
        pokemon.setName(pokedata.get("name"));
        pokemon.setHeight(pokedata.get("height"));
        pokemon.setWeight(pokedata.get("weight"));
        pokemon.setDescription(pokedata.get("description"));
        return pokemon;
    }
}