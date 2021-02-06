package fr.esgi.game;

import fr.esgi.config.SeasonsConfig;
import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.readers.SeasonsReader;

import java.io.IOException;

public class Season {

    private SeasonsConfig seasons;
    private SeasonsReader seasonsReader = new SeasonsReader();


    public void getSeason(String event, int round) throws IOException, SeasonDisplayNotFound {

        seasons = seasonsReader.getSeasons();
        String seasonDisplay;

        System.out.println("Année " + (int) (round / 4) + " - " + seasons.print("base", round % 4));
        if (!event.equals("base")) {
            seasonDisplay = seasons.print(event, round % 4);
            if (seasonDisplay != null) {
                System.out.println(seasonDisplay);
            }

        }
    }

}
