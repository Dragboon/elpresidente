package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.jsonconfig.EventsDisplayConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EventsDisplayReader {

    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String EVENTSDISPLAYFILE = DATAFOLDER + File.separator + "eventsdisplay.json";

    public EventsDisplayConfig getEventDisplay() throws IOException {
        Gson gson = new Gson();

        Reader reader = new FileReader(EVENTSDISPLAYFILE);

        EventsDisplayConfig eventsDisplayConfig = gson.fromJson(reader, EventsDisplayConfig.class);

        return eventsDisplayConfig;
    }

}
