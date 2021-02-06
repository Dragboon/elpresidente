package fr.esgi.game;

import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.exceptions.SeasonFileException;

import java.io.IOException;
import java.util.Scanner;

public class Play {

    int nbRounds;
    int nbYears = 0;
    Season season = new Season();


    public void startGame(Scanner scanner) throws SeasonFileException, SeasonDisplayNotFound {

        while(nbYears != 1) {

            if (nbRounds % 4 == 0 && nbRounds != 0) {
                nbYears++;
            }

            try {
                season.getSeason("sdv",nbRounds);
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
