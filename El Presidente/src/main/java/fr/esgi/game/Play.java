package fr.esgi.game;

import fr.esgi.jsonconfig.GameOutputConfig;
import fr.esgi.exceptions.*;
import fr.esgi.factions.Factions;
import fr.esgi.menu.EventsMenu;
import fr.esgi.menu.YearlyEventMenu;
import fr.esgi.readers.GameOutputReader;

import java.io.IOException;
import java.util.Scanner;

public class Play {

    private int nbRounds;
    private int nbYears = 0;
    private int food;
    private int money;

    private final Island island = new Island();
    private Score playerScore;
    private final GameOutputReader gameOutputReader = new GameOutputReader();
    private GameOutputConfig gameOutputConfig;
    private final Factions factions = new Factions();
    private final YearlyEvent yearlyEvents = new YearlyEvent();
    private final YearlyEventMenu yearlyEventMenu = new YearlyEventMenu();
    private final EventsMenu eventsMenu = new EventsMenu();
    private final static String ARRAYFORMAT = "%-15s| %-6s | %-5s |";

    public void startGame(Scanner scanner, String username) {

        playerScore = new Score(username);

        try {
            gameOutputConfig = gameOutputReader.getOutput();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        while (factions.globalPopulation() >= 0 && factions.globalSatisfaction() >= 45) {
            try {
                if (nbRounds % 4 == 0 && nbRounds != 0) {
                    printYearlyEvent(scanner);
                }
                eventsMenu.eventManager(scanner, nbRounds, this);

            } catch (YearlyEventNotFound | EventsSeasonNotFound | EventsParametersNotFound | EventsDisplayNotFound | SeasonFileNotFound e) {
                System.out.println(e.getMessage());
            }
            nbRounds++;
        }
        System.out.println("\n" + gameOutputConfig.getGameOver());
        System.out.println("\n" + gameOutputConfig.getScore() + playerScore.getScore() + "\n\n");
        GamePause.pauseGame(gameOutputConfig.getGamePause(), scanner);
    }

    private void printYearlyEvent(Scanner scanner) throws YearlyEventNotFound {

        int foodBis;
        nbYears++;
        food += island.yearlyHarvest();
        money += island.yearlyTaxes();
        playerScore.setScore(this);
        System.out.println("\n\n" + gameOutputConfig.getNewYearScore() + (int) playerScore.getScore());
        System.out.println(gameOutputConfig.getYearlyHarvest() + island.yearlyHarvest());
        System.out.println(gameOutputConfig.getYearlyTaxes() + island.yearlyTaxes() + "\n\n");
        yearlyEventMenu.printMenu(scanner, this);

        foodBis = yearlyEvents.foodLeft(getFood(), getFactions());
        if (foodBis >= 0) {
            food = yearlyEvents.foodLeft(getFood(), getFactions());
            displayNewPopulation(true, scanner);
        } else {
            displayNewPopulation(false, scanner);
            food = 0;
        }
    }

    private void displayNewPopulation(boolean growth, Scanner scanner) {
        int[] populationGrowth;
        int[] totalPopulation;
        int birthsCounter = 0;
        String[] factionsName = gameOutputConfig.getFactionsName();

        if (growth) {
            System.out.println("\n\n" + gameOutputConfig.getBirthEvent());
            populationGrowth = yearlyEvents.factionBirth(this);
            System.out.println("\n" + String.format(gameOutputConfig.getBirthDisplay(), " "));
        } else {
            System.out.println("\n\n" + gameOutputConfig.getDeathEvent());
            populationGrowth = yearlyEvents.starvationDeath(this);
            System.out.println("\n" + String.format(gameOutputConfig.getDeathDisplay()," "));
        }
        totalPopulation = factions.getPopulation();

        for (int i = 0; i < populationGrowth.length; i++) {
            birthsCounter += populationGrowth[i];
            System.out.println(String.format(ARRAYFORMAT,
                    factionsName[i],
                    populationGrowth[i],
                    totalPopulation[i]));
        }
        System.out.println(String.format(ARRAYFORMAT,
                "Total",
                birthsCounter,
                factions.globalPopulation()));
        System.out.println("\n");
        GamePause.pauseGame(gameOutputConfig.getGamePause(), scanner);
    }

    public void setFood(int food) { this.food = food; }

    public void setMoney(int money) { this.money = money; }

    public int getFood() { return food; }

    public int getMoney() { return money; }

    public Factions getFactions() { return factions; }

    public int getNbYears() { return nbYears; }

    public Island getIsland() { return island; }

    public GameOutputConfig getGameOutputConfig() { return gameOutputConfig; }
}