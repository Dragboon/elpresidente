package fr.esgi.game;

import fr.esgi.jsonconfig.SeasonsConfig;
import fr.esgi.exceptions.SeasonFileNotFound;
import fr.esgi.readers.SeasonsReader;

import java.io.IOException;

public class Season {

    private SeasonsConfig seasons;
    private SeasonsReader seasonsReader = new SeasonsReader();


    public void getSeason(String event, int round) throws SeasonFileNotFound {

        try {
            seasons = seasonsReader.getSeasons();
        } catch (IOException e) {
            throw new SeasonFileNotFound();
        }
        String seasonDisplay;

        System.out.println("\n\nYear " + (int) (round / 4) + " - " + seasons.print("base", round % 4));
        if (!event.equals("base")) {
            seasonDisplay = seasons.print(event, round % 4);
            if (seasonDisplay != null) {
                System.out.println(seasonDisplay);
            } else {
                System.out.println(seasons.print("basic", round % 4));
            }

        }
    }

}
