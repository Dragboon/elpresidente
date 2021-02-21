package fr.esgi.jsonconfig;

import fr.esgi.readers.ErrorsReader;

import java.io.IOException;
import java.util.Map;

public class ErrorsConfig {

    private Map<String, String> errors;

    public Map<String, String> getErrors() {
        return errors;
    }

    public static ErrorsConfig getInstance() {
        ErrorsReader errorsReader = new ErrorsReader();
        try {
            ErrorsConfig errorsConfig = errorsReader.getErrors();
            return errorsConfig;
        } catch (IOException e) {
            System.out.println("Errors file not found.");
        }
        System.exit(1);
        return null;
    }
}
