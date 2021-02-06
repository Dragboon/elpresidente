package fr.esgi.menu;

import com.google.gson.Gson;
import fr.esgi.config.ErrorsHandler;
import fr.esgi.config.HomepageConfig;
import fr.esgi.exceptions.GameOutputNotFound;
import fr.esgi.exceptions.SeasonDisplayNotFound;
import fr.esgi.exceptions.SeasonFileException;
import fr.esgi.game.Play;
import fr.esgi.readers.HomepageReader;

import java.io.IOException;
import java.util.Scanner;

public class Homepage extends InputMenu {

    public void printMenu(Scanner scanner) {

        HomepageReader homepageReader = new HomepageReader();
        HomepageConfig homepageConfig;
        int choice;

        try {
            homepageConfig = homepageReader.getMenu();
        } catch (IOException e) {
            System.out.println("Le fichier du menu n'existe pas.");
            return;
        }

        System.out.println("\n" + homepageConfig.getTitle().get("name") + "\n\n");

        do {
            choice = display(scanner, homepageConfig.getHomepage().values().toArray(new String[0]));
            menu(scanner, choice);
        } while (choice != 5);

    }

    public void menu(Scanner scanner, int choice) {

        Play game = new Play();

        try {
            switch (choice) {
                case 1 :
                    game.startGame(scanner);
                    break;
                case 2 :
                    // méthode difficulté
                    break;
                case 3 :
                    // sandbox
                    break;
                case 4 :
                    // leaderboard
                    break;
            }
        } catch (SeasonFileException | SeasonDisplayNotFound | GameOutputNotFound e) {
            System.out.println(e.getMessage());
        }

    }

}
