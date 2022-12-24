
package com.example.pokedex.services;

import java.sql.ResultSet;
import java.sql.*;
import java.util.Hashtable;

public class PokSQLService implements PokservInterface{
    //get pokemon data in the form of a hashtable
    String DataBase;
    public PokSQLService(String DataBase){
        this.DataBase = DataBase;
    }
    public Hashtable<String, String> getPoke(String pokemonId) {
        Hashtable<String, String> pokedata
                = new Hashtable<String, String>();
        Connection connexion = null;
        try {
            // database url
            String url = "jdbc:sqlite:"+DataBase;
            // connect to DB
            connexion = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = connexion.prepareStatement(String.format("SELECT name,height,weight, description FROM pokemons WHERE id = ?"));
            stmt.setString(1,pokemonId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            //use the retrieved object to create the pokemon
            pokedata.put("id",pokemonId);
            pokedata.put("name",rs.getString("name"));
            pokedata.put("height",rs.getString("height"));
            pokedata.put("weight",rs.getString("weight"));
            pokedata.put("description",rs.getString("description"));
            return pokedata;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
