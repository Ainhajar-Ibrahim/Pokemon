package com.example.pokedex.utilities;

public class ConsoleLogUtility {
    public static void logTextToConsole(TextGeneratorInterface generator) {
        System.out.println(generator.generateText());
    }
}