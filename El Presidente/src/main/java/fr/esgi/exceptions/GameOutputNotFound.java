package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class GameOutputNotFound extends Exception{

    public GameOutputNotFound () {
        super(ErrorsConfig.getInstance().getErrors().get("gameOutputNotFound"));
    }
}
