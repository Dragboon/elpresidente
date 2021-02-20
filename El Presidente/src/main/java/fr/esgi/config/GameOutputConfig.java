package fr.esgi.config;

import java.util.Map;

public class GameOutputConfig {

    private String newYearScore;
    private String yearlyHarvest;
    private String yearlyTaxes;
    private String food;
    private String money;
    private String islandIndus;
    private String islandFarm;
    private String deathDisplay;
    private String birthDisplay;
    private Map<Integer, String> factionsName;

    public String getNewYearScore() {
        return newYearScore;
    }

    public String getYearlyHarvest() {
        return yearlyHarvest;
    }

    public String getYearlyTaxes() {
        return yearlyTaxes;
    }

    public String getFood() {
        return food;
    }

    public String getMoney() {
        return money;
    }

    public String getIslandIndus() {
        return islandIndus;
    }

    public String getIslandFarm() {
        return islandFarm;
    }

    public String getDeathDisplay() {
        return deathDisplay;
    }

    public String getBirthDisplay() {
        return birthDisplay;
    }

    public String[] getFactionsName() {
        return factionsName.values().toArray(new String[0]);
    }
}
