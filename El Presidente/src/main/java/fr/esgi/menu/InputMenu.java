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

            System.out.print("\nYour choice : ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // empty scanner if not an integer
            }

            if (choice < 1 || choice > choices.length) {
                choice = 0;
                System.out.println(String.format("Please, choose an option between 1 and %d.", choices.length));
            }
        }

        return choice;
    }

    public static int getInputNumber(Scanner scanner, int min, int max) {
        int number = min - 1;

        do {
            try {
                number = scanner.nextInt();
                if (number < min || number > max) {
                    number = min - 1;
                    System.out.println(String.format("Please, choose an option between %d and %d.", min, max));
                }
            } catch (InputMismatchException e) {
                scanner.next(); // empty scanner if not an integer
                number = min - 1;
            }
        } while (number == min - 1);

        return number;
    }
}
