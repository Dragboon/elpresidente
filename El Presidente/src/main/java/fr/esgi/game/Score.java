package fr.esgi.game;

public class Score {
    private int score = 0;
    private String president;

    public Score(String president) {
        this.president = president;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int globalSatisfaction, int nbYear, int globalPopulation) {
        score = globalSatisfaction * (100 + 10 * nbYear) + globalPopulation / 2;
    }

}
