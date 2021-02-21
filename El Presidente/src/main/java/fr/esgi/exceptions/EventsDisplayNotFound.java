package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class EventsDisplayNotFound extends Exception {

    public EventsDisplayNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("eventsDisplayNotFound"));
    }

}
