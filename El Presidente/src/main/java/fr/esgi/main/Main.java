package fr.esgi.main;

import fr.esgi.menu.Homepage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Homepage homepage = new Homepage();
        Scanner scanner = new Scanner(System.in);
        homepage.printMenu(scanner);
    }

}
