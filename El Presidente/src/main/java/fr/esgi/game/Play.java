package fr.esgi.game;

import fr.esgi.config.GameOutputConfig;
import fr.esgi.exceptions.GameOutputNotFound;
import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.exceptions.SeasonFileException;
import fr.esgi.readers.GameOutputReader;

import java.io.IOException;
import java.util.Scanner;

public class Play {

    int nbRounds;
    int nbYears = 0;
    Season season = new Season();
    Score playerScore = new Score("Lolitler");
    GameOutputReader gameOutputReader = new GameOutputReader();
    GameOutputConfig gameOutputConfig;


    public void startGame(Scanner scanner) throws SeasonFileException, SeasonDisplayNotFound, GameOutputNotFound {

        try {
            gameOutputConfig = gameOutputReader.getOutput();
        } catch (IOException e) {
            throw new GameOutputNotFound("Game output file not found.");
        }

        while(nbYears != 1) {

            if (nbRounds % 4 == 0 && nbRounds != 0) {
                nbYears++;
                System.out.println(gameOutputConfig.getNewYearScore() + playerScore.getScore());
            }

            try {
                season.getSeason("firstyear",nbRounds);
            } catch (IOException e) {
                throw new SeasonFileException("Season file not found.");
            } catch (SeasonDisplayNotFound e) {
                throw new SeasonDisplayNotFound("Season display not found.");
            }

            // getEvents(nbRounds % 4);

            nbRounds++;
        }
    }



}
