package fr.esgi.config;

import java.util.Map;

public class YearlyEventConfig {

    private Map<Integer, String> choices;
    private Map<String, String> marketFood;
    private Map<String, String> factionsCorruption;
    private Map<Integer, String> factionsName;

    public String[] getChoices() {
        return choices.values().toArray(new String[0]);
    }

    public Map<String, String> getMarketFood() {
        return marketFood;
    }

    public Map<String, String> getFactionsCorruption() {
        return factionsCorruption;
    }

    public String[] getFactionsName() {
        return factionsName.values().toArray(new String[0]);
    }

}
