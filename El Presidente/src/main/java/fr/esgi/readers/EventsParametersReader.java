package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.jsonconfig.EventsParametersConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EventsParametersReader {

    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String EVENTPARAMFILE = DATAFOLDER + File.separator + "eventsparameters.json";

    public EventsParametersConfig getEventParameters() throws IOException {
        Gson gson = new Gson();

        Reader reader = new FileReader(EVENTPARAMFILE);

        EventsParametersConfig eventsParametersConfig = gson.fromJson(reader, EventsParametersConfig.class);

        return eventsParametersConfig;
    }
}
