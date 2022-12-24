package com.example.pokedex.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogUtility {
    public static void logHtmlToFile(String filePath, HtmlGeneratorInterface generator) throws IOException {
        Files.write(Paths.get(filePath), generator.generateHtml().getBytes(StandardCharsets.UTF_8));
    }
}
