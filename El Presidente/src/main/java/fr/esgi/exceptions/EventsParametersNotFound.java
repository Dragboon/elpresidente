package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class EventsParametersNotFound extends Exception {

    public EventsParametersNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("eventsParametersNotFound"));
    }
}
