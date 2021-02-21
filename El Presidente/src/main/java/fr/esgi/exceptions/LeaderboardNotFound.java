package fr.esgi.exceptions;

import fr.esgi.jsonconfig.ErrorsConfig;

public class LeaderboardNotFound extends Exception {

    public LeaderboardNotFound() {
        super(ErrorsConfig.getInstance().getErrors().get("leaderboardNotFound"));
    }
}
