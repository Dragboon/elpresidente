package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.config.HomepageConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class HomepageReader {

    private Reader reader;
    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String HOMEPAGEFILE = DATAFOLDER + File.separator + "homepage.json";

    public HomepageConfig getMenu() throws IOException {
        Gson gson = new Gson();

        reader = new FileReader(HOMEPAGEFILE);

        HomepageConfig homepageConfig = gson.fromJson(reader, HomepageConfig.class);

        return homepageConfig;
    }

}
