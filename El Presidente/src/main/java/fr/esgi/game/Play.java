package fr.esgi.game;

import fr.esgi.config.GameOutputConfig;
import fr.esgi.exceptions.GameOutputNotFound;
import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.exceptions.SeasonFileException;
import fr.esgi.exceptions.YearlyEventNotFound;
import fr.esgi.factions.Factions;
import fr.esgi.menu.YearlyEventMenu;
import fr.esgi.readers.GameOutputReader;

import java.io.IOException;
import java.util.Scanner;

public class Play {

    private int nbRounds;
    private int nbYears = 0;
    private int food;
    private int money;

    private Season season = new Season();
    private Island island = new Island();
    private Score playerScore = new Score("Lolitler");
    private GameOutputReader gameOutputReader = new GameOutputReader();
    private GameOutputConfig gameOutputConfig;
    private Factions factions = new Factions();
    private YearlyEvent yearlyEvents = new YearlyEvent();
    private YearlyEventMenu yearlyEventMenu = new YearlyEventMenu();
    private final static String ARRAYFORMAT = "%-15s | %-6s | %-5s |";

    public void startGame(Scanner scanner) throws SeasonFileException, SeasonDisplayNotFound, GameOutputNotFound, YearlyEventNotFound {

        try {
            gameOutputConfig = gameOutputReader.getOutput();
        } catch (IOException e) {
            throw new GameOutputNotFound("Game output file not found.");
        }

        while (factions.globalPopulation() >= 0 && factions.globalSatisfaction() >= 30) {

            try {
                if (nbRounds % 4 == 0 && nbRounds != 0) {
                    printYearlyEvent(scanner);
                }
            } catch (IOException e) {
                throw new YearlyEventNotFound("Yearly event file not found.");
            }

            try {
                season.getSeason("basic", nbRounds);
                printIslandStats();
            } catch (IOException e) {
                throw new SeasonFileException("Season file not found.");
            } catch (SeasonDisplayNotFound e) {
                throw new SeasonDisplayNotFound("Season display not found.");
            }
            nbRounds++;
        }
    }

    private void printYearlyEvent(Scanner scanner) throws IOException {

        int foodBis;
        nbYears++;
        food += island.yearlyHarvest();
        money += island.yearlyTaxes();
        playerScore.setScore(this);
        System.out.println(gameOutputConfig.getNewYearScore() + playerScore.getScore());
        System.out.println(gameOutputConfig.getYearlyHarvest() + island.yearlyHarvest());
        System.out.println(gameOutputConfig.getYearlyTaxes() + island.yearlyTaxes() + "\n\n");
        yearlyEventMenu.printMenu(scanner, this);

        foodBis = yearlyEvents.foodLeft(getFood(), getFactions());
        if (foodBis >= 0) {
            food = yearlyEvents.foodLeft(getFood(), getFactions());
            displayNewPopulation(true);
        } else {
            displayNewPopulation(false);
            food = 0;
        }
    }

    private void printIslandStats() {
        System.out.println(gameOutputConfig.getFood() + food);
        System.out.println(gameOutputConfig.getMoney() + money);
        System.out.println(gameOutputConfig.getIslandIndus() + island.getIndusLevel());
        System.out.println(gameOutputConfig.getIslandFarm() + island.getFarmLevel() + "\n\n");
    }

    private void displayNewPopulation(boolean growth) {
        int[] populationGrowth;
        int[] totalPopulation;
        int birthsCounter = 0;
        String[] factionsName = gameOutputConfig.getFactionsName();

        if (growth) {
            populationGrowth = yearlyEvents.factionBirth(this);
            System.out.println("\n" + String.format(gameOutputConfig.getBirthDisplay(), " "));
        } else {
            populationGrowth = yearlyEvents.starvationDeath(this);
            System.out.println("\n" + String.format(gameOutputConfig.getDeathDisplay()," "));
        }
        totalPopulation = factions.getPopulation();

        for (int i = 0; i < populationGrowth.length; i++) {
            birthsCounter += populationGrowth[i];
            System.out.println(String.format(ARRAYFORMAT,
                    factionsName[i],
                    String.valueOf(populationGrowth[i]),
                    String.valueOf(totalPopulation[i])));
        }
        System.out.println(String.format(ARRAYFORMAT,
                "Total",
                birthsCounter,
                String.valueOf(factions.globalPopulation())));
        System.out.println("\n");
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getFood() {
        return food;
    }

    public int getMoney() {
        return money;
    }

    public Factions getFactions() {
        return factions;
    }

    public int getNbYears() {
        return nbYears;
    }
}
