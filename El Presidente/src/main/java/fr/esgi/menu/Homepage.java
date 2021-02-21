package fr.esgi.menu;

import fr.esgi.game.Score;
import fr.esgi.jsonconfig.HomepageConfig;
import fr.esgi.game.Play;
import fr.esgi.readers.HomepageReader;

import java.io.IOException;
import java.util.Scanner;

public class Homepage extends InputMenu {

    HomepageConfig homepageConfig;


    public void printMenu(Scanner scanner) {

        HomepageReader homepageReader = new HomepageReader();
        int choice;

        try {
            homepageConfig = homepageReader.getMenu();
        } catch (IOException e) {
            System.out.println("Homepage file not found.");
            return;
        }

        System.out.println("\n" + homepageConfig.getTitle().get("name") + "\n\n");

        do {
            choice = display(scanner, homepageConfig.getHomepage().values().toArray(new String[0]));
            menu(scanner, choice);
        } while (choice != 5);

    }

    public void menu(Scanner scanner, int choice) {

        String username;

        Play game = new Play();
        switch (choice) {
            case 1:
                System.out.println("\n\n" + homepageConfig.getUsername());
                username = scanner.next();
                game.startGame(scanner, username);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                System.out.println("\n\n" + Score.getLeaderboard());
                break;
        }
    }

}
