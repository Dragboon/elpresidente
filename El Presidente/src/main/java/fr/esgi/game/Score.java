package fr.esgi.game;

import fr.esgi.exceptions.LeaderboardNotFound;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Score {
    private double score = 0;
    private String president;
    private File leaderboardFile;
    private FileWriter leaderboardWriter;
    private final static String USERDIR = "user.dir";
    private final static String DATAFOLDER = System.getProperty(USERDIR) + File.separator + "data";
    private final static String LEADERBOARDFILE = DATAFOLDER + File.separator + "leaderboard.txt";

    public Score(String president) {
        this.president = president;
    }

    public double getScore() {
        return score;
    }

    public void setScore(Play play) {
        score += play.getFactions().globalSatisfaction() * (100 + 10 * play.getNbYears()) + play.getFactions().globalPopulation() / 2;
    }

    public void newScore() throws LeaderboardNotFound {

        String playerScore;
        leaderboardFile = new File(LEADERBOARDFILE);

        try {
            leaderboardWriter = new FileWriter(leaderboardFile, true);

            playerScore = president + "===" + score;

            leaderboardWriter.append(playerScore);
            leaderboardWriter.flush();
            leaderboardWriter.close();

        } catch (IOException e) {
            throw new LeaderboardNotFound();
        }
    }

    public static String getLeaderboard() {
        Scanner scanner;
        String result;
        String leaderboard = "";
        String[] data;

        File leaderboardFile = new File(LEADERBOARDFILE);

        try {
            scanner = new Scanner(leaderboardFile);

            while (scanner.hasNextLine()) {
                result = scanner.nextLine();

                data = result.split("===");
                leaderboard += data[0] + " : " + data[1] + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return leaderboard;
    }

}
