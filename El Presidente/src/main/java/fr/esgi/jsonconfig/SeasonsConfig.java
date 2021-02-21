package fr.esgi.jsonconfig;

import java.util.Map;

public class SeasonsConfig {

    private Map<String, String> spring;
    private Map<String, String> summer;
    private Map<String, String> autumn;
    private Map<String, String> winter;

    public String print(String event, int season) {

        switch (season) {
            case 0 :
                return spring.get(event);
            case 1 :
                return summer.get(event);
            case 2 :
                return autumn.get(event);
            default :
                return winter.get(event);
        }

    }

}
