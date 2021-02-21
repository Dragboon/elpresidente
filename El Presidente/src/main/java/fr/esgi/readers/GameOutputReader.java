package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.jsonconfig.GameOutputConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GameOutputReader {

    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String GAMEOUTPUTFILE = DATAFOLDER + File.separator + "gameoutput.json";

    public GameOutputConfig getOutput() throws IOException {

        Gson gson = new Gson();

        Reader reader = new FileReader(GAMEOUTPUTFILE);

        GameOutputConfig gameOutputConfig = gson.fromJson(reader, GameOutputConfig.class);

        return gameOutputConfig;
    }

}
