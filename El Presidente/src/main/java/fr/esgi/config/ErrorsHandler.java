package fr.esgi.config;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class ErrorsHandler {
    public Map<String, String> errors;

    public static void printError(String errorName) {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty("user.dir") + "\\data\\errors.json")) {

            ErrorsHandler errorsHandler = gson.fromJson(reader, ErrorsHandler.class);

            System.out.println(errorsHandler.errors.get(errorName));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
