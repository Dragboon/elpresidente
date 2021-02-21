package fr.esgi.jsonconfig;

import java.util.Map;

public class GameOutputConfig {

    private String newYearScore;
    private String yearlyHarvest;
    private String yearlyTaxes;
    private String food;
    private String money;
    private String islandIndus;
    private String islandFarm;
    private String deathEvent;
    private String birthEvent;
    private String deathDisplay;
    private String birthDisplay;
    private String factionsStatDisplay;
    private String choiceNotValid;
    private String gamePause;
    private String score;
    private String total;
    private Map<Integer, String> factionsName;
    private String gameOver;

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

    public String getDeathEvent() {
        return deathEvent;
    }

    public String getBirthEvent() {
        return birthEvent;
    }

    public String getDeathDisplay() {
        return deathDisplay;
    }

    public String getBirthDisplay() {
        return birthDisplay;
    }

    public String getFactionsStatDisplay() {
        return factionsStatDisplay;
    }

    public String getChoiceNotValid() {
        return choiceNotValid;
    }

    public String getGamePause() {
        return gamePause;
    }

    public String getScore() {
        return score;
    }

    public String getTotal() {
        return total;
    }

    public String[] getFactionsName() {
        return factionsName.values().toArray(new String[0]);
    }

    public String getGameOver() {
        return gameOver;
    }
}
