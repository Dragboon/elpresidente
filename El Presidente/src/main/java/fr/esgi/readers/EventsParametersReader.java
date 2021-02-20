package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.config.EventsDisplayConfig;
import fr.esgi.config.EventsParametersConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EventsParametersReader {

    private Reader reader;
    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String EVENTPARAMFILE = DATAFOLDER + File.separator + "eventsparameters.json";

    public EventsParametersConfig getEventDisplay() throws IOException {
        Gson gson = new Gson();

        reader = new FileReader(EVENTPARAMFILE);

        EventsParametersConfig eventsParametersConfig = gson.fromJson(reader, EventsParametersConfig.class);

        return eventsParametersConfig;
    }
}
