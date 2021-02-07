package fr.esgi.game;

import fr.esgi.config.GameOutputConfig;
import fr.esgi.exceptions.GameOutputNotFound;
import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.exceptions.SeasonFileException;
import fr.esgi.factions.Factions;
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
    private YearlyEvents yearlyevents = new YearlyEvents();

    public void startGame(Scanner scanner) throws SeasonFileException, SeasonDisplayNotFound, GameOutputNotFound {

        try {
            gameOutputConfig = gameOutputReader.getOutput();
        } catch (IOException e) {
            throw new GameOutputNotFound("Game output file not found.");
        }

        while(factions.globalPopulation() >= 0 && factions.globalSatisfaction() >= 30) {

            printYearlyEvent();

            try {
                season.getSeason("firstyear",nbRounds);
                printIslandStats();
            } catch (IOException e) {
                throw new SeasonFileException("Season file not found.");
            } catch (SeasonDisplayNotFound e) {
                throw new SeasonDisplayNotFound("Season display not found.");
            }

            // getEvents(nbRounds % 4);

            nbRounds++;
        }
    }

    private void printYearlyEvent() {

        if (nbRounds % 4 == 0 && nbRounds != 0) {
            nbYears++;
            food += island.yearlyHarvest();
            money += island.yearlyTaxes();
            System.out.println(gameOutputConfig.getNewYearScore() + playerScore.getScore());
            System.out.println(gameOutputConfig.getYearlyHarvest() + island.yearlyHarvest());
            System.out.println(gameOutputConfig.getYearlyTaxes() + island.yearlyTaxes() + "\n\n");
        }
    }

    private void printIslandStats() {
        System.out.println(gameOutputConfig.getFood() + food);
        System.out.println(gameOutputConfig.getMoney() + money);
        System.out.println(gameOutputConfig.getIslandIndus() + island.getIndusLevel());
        System.out.println(gameOutputConfig.getIslandFarm() + island.getFarmLevel() + "\n\n");
    }

}
