package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class EventsSeasonNotFound extends Exception {

    public EventsSeasonNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("eventsSeasonNotFound"));
    }
}
