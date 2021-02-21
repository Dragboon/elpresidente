package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class SeasonFileNotFound extends Exception {

    public SeasonFileNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("seasonFileNotFound"));
    }
}
