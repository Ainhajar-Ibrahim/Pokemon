package com.example.pokedex.view;

import com.example.pokedex.models.PokeSQL;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.utilities.HtmlGeneratorInterface;
import com.example.pokedex.utilities.TextGeneratorInterface;

public class PokView implements HtmlGeneratorInterface, TextGeneratorInterface {

    Pokemon pokemon;

    public PokView(Pokemon pokemon){
        this.pokemon = pokemon;
    }


    //implementation of the function that returns the text format of the data retrieved from the api or the local data
    @Override
    public String generateText() {
        String consoleText = "=================================\n" +
                "Pokemon # "+ pokemon.getId() + "\n" +
                "Nom : " + pokemon.getName() + "\n" +
                "Poids : " + pokemon.getWeight() + "\n" +
                "Taille : " + pokemon.getHeight() + "\n";
        if (pokemon instanceof PokeSQL) {
            consoleText += "Description : " + ((PokeSQL) pokemon).getDescription()+ "\n";
        }
        consoleText += "=================================";
        return consoleText;
    }


    //implementation of the function that returns the html format of the data retrieved from the api or the local data
    @Override
    public String generateHtml() {
        String html ="<h1>"+pokemon.getName()+"</h1>\n" +
                "<ul>\n" +
                "<li> Id: "+pokemon.getId()+"</li>\n" +
                "<li>Taille :"+ pokemon.getHeight()+"</li>\n" +
                "<li>Poids : "+pokemon.getWeight()+"</li>\n" ;
        if(pokemon instanceof PokeSQL){
            html+="<li>Description : " + ((PokeSQL) pokemon).getDescription() +"</li>\n"
                    +"</ul>";
        }
        else
            html+="</ul>";
        return html;
    }
}