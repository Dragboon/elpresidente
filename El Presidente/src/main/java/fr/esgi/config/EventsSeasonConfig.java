package fr.esgi.config;

import java.util.Map;

public class EventsSeasonConfig {

    private Map<Integer, String> winter;
    private Map<Integer, String> spring;
    private Map<Integer, String> summer;
    private Map<Integer, String> autumn;

    public String[] getWinter() {
        return winter.values().toArray(new String[0]);
    }

    public String[] getSpring() {
        return spring.values().toArray(new String[0]);
    }

    public String[] getSummer() {
        return summer.values().toArray(new String[0]);
    }

    public String[] getAutumn() {
        return autumn.values().toArray(new String[0]);
    }
}
