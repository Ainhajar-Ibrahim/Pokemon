package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Hashtable;

public class PokService implements PokservInterface{

    //get pokemon data in the form of a hashtable
    public Hashtable<String, String> getPoke(String pokeId) {
        Hashtable<String, String> pokedata
                = new Hashtable<String, String>();
        String jsonResponse = "";
        try {
            //fetch the pokemon using the api
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(String.format("https://pokeapi.co/api/v2/pokemon/%s",pokeId));
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            //parsing
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                //use the retrieved object to create the pokemon
                pokedata.put("id",obj.get("id").toString());
                pokedata.put("name",obj.get("name").toString());
                pokedata.put("height",obj.get("height").toString());
                pokedata.put("weight",obj.get("weight").toString());
                return pokedata;
            }  else {
            System.err.println("Error, we expected a JSON Object from the API");
        }


    } catch (
    IOException e) {
        e.printStackTrace();
    } catch (
    ParseException e) {
        System.err.println("Could not parse the response given by the API as JSON");
        System.err.println("Response body is :");
        System.err.println(jsonResponse);
        e.printStackTrace();
    }
        return null;
    }

}