package com.example.pokedex;
import com.example.pokedex.controllers.PokController;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokSQLService;
import com.example.pokedex.services.PokService;
import com.example.pokedex.view.PokView;
import com.example.pokedex.utilities.FileLogUtility;
import com.example.pokedex.utilities.ConsoleLogUtility;

import java.io.IOException;

public class Pokedex {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        //if 1 argument is given means it's the id and we will use the api
        if(args.length == 1){
            Pokemon pokemon=PokController.getPokebyId(args[0], new PokService());
            PokView view = new PokView(pokemon);
            ConsoleLogUtility.logTextToConsole(view);
            //generate the html
            FileLogUtility.logHtmlToFile("./output.html",view);
        }
        //if 2 arguments are given means that we will use the local database
        else if(args.length == 2){
            Pokemon pokemon=PokController.getPokebyIdSQL(args[0], new PokSQLService(args[1]));
            PokView view = new PokView(pokemon);
            ConsoleLogUtility.logTextToConsole(view);
            //generate the html
            FileLogUtility.logHtmlToFile("./output.html",view);
        }


    }
    public String getName(){
        return "Hello";
    }
}
