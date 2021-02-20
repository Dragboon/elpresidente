package fr.esgi.readers;

import com.google.gson.Gson;
import fr.esgi.config.YearlyEventConfig;
import fr.esgi.exceptions.YearlyEventNotFound;

import java.io.*;

public class YearlyEventReader {

    private Reader reader;
    private static final String USERDIR = System.getProperty("user.dir");
    private static final String DATAFOLDER = USERDIR + File.separator + "data";
    private static final String YEARLYEVENT = DATAFOLDER + File.separator + "yearlyevent.json";

    public YearlyEventConfig getYearlyEvent() throws IOException {
        Gson gson = new Gson();

        reader = new FileReader(YEARLYEVENT);

        YearlyEventConfig yearlyEventConfig = gson.fromJson(reader, YearlyEventConfig.class);

        return yearlyEventConfig;
    }
}
