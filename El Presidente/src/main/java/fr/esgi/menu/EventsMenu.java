package fr.esgi.menu;

import fr.esgi.events.EventsDisplay;
import fr.esgi.events.EventsName;
import fr.esgi.events.EventsParameters;
import fr.esgi.exceptions.EventsDisplayNotFound;
import fr.esgi.exceptions.EventsParametersNotFound;
import fr.esgi.exceptions.EventsSeasonNotFound;
import fr.esgi.exceptions.SeasonFileNotFound;
import fr.esgi.game.GamePause;
import fr.esgi.game.Play;
import fr.esgi.game.Season;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EventsMenu {

    EventsParameters eventsParameters = new EventsParameters();

    public void eventManager(Scanner scanner, int nbRounds, Play play) throws EventsSeasonNotFound, EventsDisplayNotFound, SeasonFileNotFound, EventsParametersNotFound {
        Season season = new Season();
        String eventName;

        eventName = EventsName.getRandomEvent(nbRounds % 4);
        season.getSeason(eventName, nbRounds);
        GamePause.pauseGame(play.getGameOutputConfig().getGamePause(), scanner);
        printIslandStats(play);
        displayEvent(eventName, scanner, play);
        eventsParameters.applyParameters(play);
    }

    private void displayEvent(String eventName, Scanner scanner, Play play) throws EventsDisplayNotFound, EventsParametersNotFound {
        EventsDisplay event;
        int choice;
        boolean isValid;
        String[] propositions;

        event = EventsDisplay.getEventDisplay(eventName);
        propositions = event.getPropositions();

        do {
            System.out.println("\n" + event.getTitle() + "\n");
            System.out.println(event.getDescription() + "\n");
            choice = InputMenu.display(scanner, propositions);
            eventsParameters.setEventsParameters(eventName, choice);
            isValid = eventsParameters.checkChoice(play);

            if (!isValid) {
                System.out.println("\n\n" + play.getGameOutputConfig().getChoiceNotValid() + "\n");
            }
        } while (!isValid);

    }

    private void printIslandStats(Play play) {
        String[] factionsName = play.getGameOutputConfig().getFactionsName();
        final String ARRAYFORMAT = "%-15s| %-10s | %-12s |";
        int[] factionsPopulation = play.getFactions().getPopulation();
        double[] factionsSatisfaction = play.getFactions().getSatisfaction();
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(play.getGameOutputConfig().getFood() + play.getFood());
        System.out.println(play.getGameOutputConfig().getMoney() + play.getMoney());
        System.out.println(play.getGameOutputConfig().getIslandIndus() + play.getIsland().getIndusLevel());
        System.out.println(play.getGameOutputConfig().getIslandFarm() + play.getIsland().getFarmLevel() + "\n");

        System.out.println(String.format(play.getGameOutputConfig().getFactionsStatDisplay(), " "));
        for (int i = 0; i < factionsName.length; i++) {
            System.out.println(String.format(ARRAYFORMAT,
                    factionsName[i],
                    String.valueOf(factionsPopulation[i]),
                    String.valueOf(factionsSatisfaction[i])));
        }
        System.out.println(String.format(play.getGameOutputConfig().getTotal(),
                play.getFactions().globalPopulation(),
                df.format(play.getFactions().globalSatisfaction())));
    }
}
