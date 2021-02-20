package fr.esgi.game;

import fr.esgi.factions.Factions;

import java.util.Random;

public class YearlyEvent {

    private static final int MAXBIRTHS = 10;
    private static final int MINBIRTHS = 1;

    public int foodLeft(int food, Factions factions) {
        return food - foodEaten(factions);
    }

    public int foodEaten(Factions factions) {
        int food = factions.globalPopulation() * 4;
        return food;
    }

    public int starvedPeople(int food, Factions factions) {
        int foodNeeded = -(food - foodEaten(factions));
        int starvingPeople;
        if (foodNeeded < 0){
            return 0;
        } else {
            starvingPeople = (int) Math.ceil(foodNeeded / 4);
            return starvingPeople;
        }
    }

    public int[] randomDeath(int starvedPeople, Factions factions) {
        int[] population = factions.getPopulation();
        Random random = new Random();
        int randomNumber;
        while (starvedPeople > 0) {
            randomNumber = random.nextInt(7);
            if (population[randomNumber] > 0) {
                starvedPeople -= 1;
                population[randomNumber] -= 1;
            }
        }
        return population;
    }

    public int[] newBorn(Factions factions) {
        int[] population = factions.getPopulation();
        Random random = new Random();
        int globalPopulation = factions.globalPopulation();
        int births = random.nextInt(MAXBIRTHS) + MINBIRTHS;
        int newBorns = globalPopulation * births / 100;

        while (newBorns != 0) {
            population[random.nextInt(7)] += 1;
            newBorns -= 1;
        }
        return population;
    }

    public boolean hasEnoughMoneyForFood(int howMuchFood, Play play) {

        int newMoneyValue = play.getMoney() - howMuchFood * 8;
        if (newMoneyValue < 0) {
            return false;
        }
        play.setMoney(newMoneyValue);
        play.setFood(play.getFood() + howMuchFood);
        return true;
    }

    public boolean hasEnoughMoneyToCorrupt(int factionIndex, Play play) {
        int[] factionsPartisans = play.getFactions().getPopulation();
        double[] factionSatisfaction = play.getFactions().getSatisfaction();

        if (play.getMoney() < factionsPartisans[factionIndex] * 15) {
            return false;
        }
        play.setMoney(play.getMoney() - factionsPartisans[factionIndex] * 15);
        factionSatisfaction[factionIndex] += 10.0;
        factionSatisfaction[6] -= 1.5 * factionsPartisans[factionIndex];
        play.getFactions().setSatisfaction(factionSatisfaction);
        return true;
    }
    
    public int[] starvationDeath(Play play) {
        int starvedPeople = starvedPeople(play.getFood(), play.getFactions());
        int[] oldPopulation = play.getFactions().getPopulation();
        int[] newPopulation = randomDeath(starvedPeople, play.getFactions());
        int[] deathList = new int[7];
        int reduceSatisfaction = - (2 * starvedPeople);
        play.getFactions().setGlobalSatisfaction(reduceSatisfaction);

        for (int i = 0; i < oldPopulation.length; i++) {
           deathList[i] = oldPopulation[i] - newPopulation[i];
        }
        play.getFactions().setPopulation(newPopulation);
        return deathList;
    }

    public int[] factionBirth(Play play) {
        int[] oldPopulation = play.getFactions().getPopulation();
        int[] newPopulation = newBorn(play.getFactions());
        int[] newBorn = new int[7];

        for (int i = 0; i < oldPopulation.length; i++) {
            newBorn[i] = newPopulation[i] - oldPopulation[i];
        }
        play.getFactions().setPopulation(newPopulation);
        return newBorn;
    }

}
