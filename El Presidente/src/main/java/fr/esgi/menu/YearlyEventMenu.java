package fr.esgi.menu;

import fr.esgi.factions.Factions;
import fr.esgi.config.YearlyEventConfig;
import fr.esgi.game.Play;
import fr.esgi.game.YearlyEvent;
import fr.esgi.readers.YearlyEventReader;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class YearlyEventMenu {

    private YearlyEventReader yearlyEventReader = new YearlyEventReader();
    private YearlyEventConfig yearlyEventConfig;
    private YearlyEvent yearlyEvent;
    private final static int FOODPRICE = 8;
    private final static String ARRAYFORMAT = "%-15s| %-10s | %-12s |";

    public void printMenu(Scanner scanner, Play play) throws IOException {

        yearlyEventConfig = yearlyEventReader.getYearlyEvent();
        yearlyEvent = new YearlyEvent();

        int choice;

        do {
            choice = InputMenu.display(scanner, yearlyEventConfig.getChoices());
            switch (choice) {
                case 1:
                    printMarketMenu(scanner, play);
                    break;
                case 2:
                    corruptFactionMenu(scanner, play);
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }


    public void printMarketMenu(Scanner scanner, Play play) {

        Map<String, String> marketFood = yearlyEventConfig.getMarketFood();
        int foodLeft = yearlyEvent.foodLeft(play.getFood(), play.getFactions());
        int howMuchFood;
        boolean isPurchaseSuccessful;

        if(foodLeft >= 0) {
            System.out.println("\n\n" + marketFood.get("noFoodNeeded") + "\n\n");
            return;
        }
        System.out.println("\n\n" + marketFood.get("actualMoney") + play.getMoney());
        System.out.println(marketFood.get("actualFood") + play.getFood());
        System.out.println(marketFood.get("foodMissing") + (-1 * foodLeft) + "\n");
        System.out.println(marketFood.get("foodWanted"));
        System.out.println(String.format(marketFood.get("foodPrice"), FOODPRICE));
        howMuchFood = InputMenu.getInputNumber(scanner, 0, -1 * foodLeft);
        isPurchaseSuccessful = yearlyEvent.hasEnoughMoneyForFood(howMuchFood, play);
        if (isPurchaseSuccessful) {
            System.out.println("\n" + marketFood.get("foodBought") + howMuchFood + "\n\n");
            return;
        }
        System.out.println(marketFood.get("notEnoughMoney") + "\n\n");

    }

    public void corruptFactionMenu(Scanner scanner, Play play){
        Map<String, String> factionsCorruption = yearlyEventConfig.getFactionsCorruption();
        String[] factionsName = yearlyEventConfig.getFactionsName();
        String[] factionsDisplay = yearlyEventConfig.getFactionsName();
        Factions factions = play.getFactions();
        int[] factionsPopulation = factions.getPopulation();
        double[] factionsSatisfaction = factions.getSatisfaction();
        int choice;
        boolean isPurchaseSuccessful;

        factionsDisplay[factionsDisplay.length - 1] = factionsCorruption.get("doneMenu");
        System.out.println("\n\n" + factionsCorruption.get("corruptPrice"));
        System.out.println(factionsCorruption.get("warningCorruption") + "\n");

        do {
            System.out.println(factionsCorruption.get("globalSatisfaction") + factions.globalSatisfaction());
            System.out.println(factionsCorruption.get("populationSize") + factions.globalPopulation());
            System.out.println(factionsCorruption.get("actualMoney") + play.getMoney() + "\n");
            System.out.println(String.format(factionsCorruption.get("population"), " "));

            for (int i = 0; i < factionsName.length; i++){
                System.out.println(String.format(ARRAYFORMAT,
                        factionsName[i],
                        String.valueOf(factionsPopulation[i]),
                        String.valueOf(factionsSatisfaction[i])));
            }
            System.out.println("\n" + factionsCorruption.get("factionChoice"));
            choice = InputMenu.display(scanner, factionsDisplay);
            if (choice == 7) {
                return;
            }
            isPurchaseSuccessful = yearlyEvent.hasEnoughMoneyToCorrupt(choice - 1, play);
            if(isPurchaseSuccessful) {
                System.out.println("\n" + factionsCorruption.get("corruptionSuccess") + factionsName[choice - 1] + "\n\n");
                return;
            }
            System.out.println(factionsCorruption.get("notEnoughMoney"));

        } while (choice != 7);
    }
}
