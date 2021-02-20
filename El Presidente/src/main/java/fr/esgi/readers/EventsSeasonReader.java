package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.config.EventsSeasonConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EventsSeasonReader {

    private Reader reader;
    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String EVENTSNAMEFILE = DATAFOLDER + File.separator + "eventsseason.json";

    public EventsSeasonConfig getEventsName() throws IOException {
        Gson gson = new Gson();

        reader = new FileReader(EVENTSNAMEFILE);

        EventsSeasonConfig eventsSeasonsConfig = gson.fromJson(reader, EventsSeasonConfig.class);

        return eventsSeasonsConfig;
    }

}
