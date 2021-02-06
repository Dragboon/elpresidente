package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.config.SeasonsConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SeasonsReader {

    private Reader reader;
    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String SEASONSFILE = DATAFOLDER + File.separator + "seasons.json";

    public SeasonsConfig getSeasons() throws IOException {
        Gson gson = new Gson();

        reader = new FileReader(SEASONSFILE);

        SeasonsConfig seasonsConfig = gson.fromJson(reader, SeasonsConfig.class);

        return seasonsConfig;
    }

}
