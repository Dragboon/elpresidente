package fr.esgi.events;

import fr.esgi.jsonconfig.EventsSeasonConfig;
import fr.esgi.exceptions.EventsSeasonNotFound;
import fr.esgi.readers.EventsSeasonReader;

import java.io.IOException;
import java.util.Random;

public class EventsName {

    private static final String[] SEASONS = {"spring", "summer", "autumn", "winter"};

    public static String getRandomEvent(int season) throws EventsSeasonNotFound {

        EventsSeasonReader eventsSeasonReader = new EventsSeasonReader();
        EventsSeasonConfig eventsSeasonConfig;
        Random random = new Random();
        int eventIndex;

        try {
            eventsSeasonConfig = eventsSeasonReader.getEventsName();
            eventIndex = random.nextInt(eventsSeasonConfig.getSeasons().get(SEASONS[season]).length);
            return eventsSeasonConfig.getSeasons().get(SEASONS[season])[eventIndex];
        } catch (IOException e) {
            throw new EventsSeasonNotFound();
        }


    }

}
