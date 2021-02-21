package fr.esgi.events;

import fr.esgi.jsonconfig.EventsDisplayConfig;
import fr.esgi.exceptions.EventsDisplayNotFound;
import fr.esgi.readers.EventsDisplayReader;

import java.io.IOException;

public class EventsDisplay {

    private String title;
    private String description;
    private String[] propositions;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPropositions() {
        return propositions;
    }

    public static EventsDisplay getEventDisplay(String eventName) throws EventsDisplayNotFound {
        EventsDisplayReader eventsDisplayReader = new EventsDisplayReader();
        EventsDisplayConfig eventsDisplayConfig;

        try {
            eventsDisplayConfig = eventsDisplayReader.getEventDisplay();
            return eventsDisplayConfig.getEvents().get(eventName);
        } catch (IOException e) {
            throw new EventsDisplayNotFound();
        }


    }


}
