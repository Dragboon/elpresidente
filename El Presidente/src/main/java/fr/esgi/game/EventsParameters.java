package fr.esgi.game;

public class EventsParameters {
    private int money;
    private int food;
    private int industry;
    private int farm;
    private int[] factionsSatisfaction;
    private int[] factionsPopulation;

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getIndustry() {
        return industry;
    }

    public int getFarm() {
        return farm;
    }

    public int[] getFactionsSatisfaction() {
        return factionsSatisfaction;
    }

    public int[] getFactionsPopulation() {
        return factionsPopulation;
    }
}
