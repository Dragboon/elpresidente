package fr.esgi.game;

import fr.esgi.factions.Factions;

import java.util.Random;

public class YearlyEvents {

    private static final int MAXBIRTHS = 10;
    private static final int MINBIRTHS = 1;
    private Factions factions = new Factions();

    public int foodLeft(int food) {
        return food - foodEaten();
    }

    public int foodEaten() {
        return factions.globalPopulation() * 4;
    }

    public int starvedPeople(int food) {
        int foodNeeded = -(food - foodEaten());
        if (foodNeeded < 0){
            return 0;
        } else {
            return (int) Math.ceil(foodNeeded / 4);
        }
    }

    public int[] randomDeath(int starvedPeople, int[] population) {
        Random random = new Random();
        int randomNumber;
        while (starvedPeople != 0) {
            randomNumber = random.nextInt(7);
            if(population[randomNumber] != 0){
                starvedPeople -= 1;
                population[randomNumber] -= 1;
            }
        }
        return population;
    }

    public int[] newBorn(int[] population) {
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
    // achat food
    // corruption
    // menu d'affichage

}
