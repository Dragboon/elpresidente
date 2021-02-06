package fr.esgi.config;

import fr.esgi.exceptions.SeasonDisplayNotFound;

import java.util.Map;

public class SeasonsConfig {

    private Map<String, String> spring;
    private Map<String, String> summer;
    private Map<String, String> autumn;
    private Map<String, String> winter;

    public Map<String, String> getSpring() {
        return spring;
    }

    public String print(String event, int season) throws SeasonDisplayNotFound {

        switch (season) {
            case 0 :
                return spring.get(event);
            case 1 :
                return summer.get(event);
            case 2 :
                return autumn.get(event);
            case 3 :
                return winter.get(event);
        }

        throw new SeasonDisplayNotFound("Season display not found.");
    }

}
