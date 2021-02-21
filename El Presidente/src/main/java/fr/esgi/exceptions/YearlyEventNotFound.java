package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class YearlyEventNotFound extends Exception {

    public YearlyEventNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("yearlyEventNotFound"));
    }

}
