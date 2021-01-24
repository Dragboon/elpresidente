package fr.esgi.homepage;

import com.google.gson.Gson;
import fr.esgi.config.ErrorsHandler;
import fr.esgi.config.HomepageConfig;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Homepage {

    public HomepageConfig getMenu() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(System.getProperty("user.dir") + "\\data\\homepage.json")) {

            HomepageConfig homepageConfig = gson.fromJson(reader, HomepageConfig.class);

            return homepageConfig;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printMenu() {

        HomepageConfig homepageConfig = getMenu();

        if (homepageConfig == null) {
            //Piocher une erreur dans les exceptions

            return;
        }

        do {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(getMenu().homepage.get("title") + "\n"
                    + getMenu().homepage.get("1") + "\n"
                    + getMenu().homepage.get("2") + "\n"
                    + getMenu().homepage.get("3") + "\n"
                    + getMenu().homepage.get("4") + "\n"
                    + getMenu().homepage.get("5") + "\n");

        } while (menu() == -1);
        return;
    }

    public int menu() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        if (input.length() < 1) {
            ErrorsHandler.printError("wrong_input");
            return -1;
        }

        switch (input.charAt(0)) {
            case '1' :
                // méthode lancement jeu
                break;
            case '2' :
                // méthode difficulté
                break;
            case '3' :
                // sandbox
                break;
            case '4' :
                // leaderboard
                break;
            case '5' :
                return 0;
            default :
                    ErrorsHandler.printError("wrong_input");
                    return -1;
        }
        return 0;
    }

}
