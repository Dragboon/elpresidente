package fr.esgi.game;

import java.util.Scanner;

public class GamePause {

    public static void pauseGame(String display, Scanner scanner) {
        System.out.println(display);
        scanner.next();
    }

}
