package fr.esgi.main;

import fr.esgi.homepage.Homepage;

public class Main {

    public static void main(String[] args) {
        Homepage p = new Homepage();
        p.menu();
        System.out.println(System.getProperty("user.dir"));
    }

}
