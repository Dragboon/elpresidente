package fr.esgi.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMenu {

    public static int display(Scanner scanner, String choices[]) {
        int choice = 0;

        while (choice == 0) {
            for (int i = 0; i < choices.length; i++) {
                System.out.println(String.format("%d - %s", i + 1, choices[i]));
            }

            System.out.print("\nVotre choix : ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); //vide le scanner de la saisie erronnée
            }

            if (choice < 1 || choice > choices.length) {
                choice = 0;
                System.out.println(String.format("Merci de choisir une option entre 1 et %d.", choices.length));
            }
        }

        return choice;
    }

}
