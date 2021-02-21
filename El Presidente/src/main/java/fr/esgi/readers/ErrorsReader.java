package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.jsonconfig.ErrorsConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ErrorsReader {

    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String ERRORSFILE = DATAFOLDER + File.separator + "errors.json";

    public ErrorsConfig getErrors() throws IOException {
        Gson gson = new Gson();

        Reader reader = new FileReader(ERRORSFILE);

        ErrorsConfig errorsConfig = gson.fromJson(reader, ErrorsConfig.class);

        return errorsConfig;
    }

}
