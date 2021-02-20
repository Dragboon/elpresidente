package fr.esgi.game;

public class Score {
    private double score = 0;
    private String president;

    public Score(String president) {
        this.president = president;
    }

    public double getScore() {
        return score;
    }

    public void setScore(Play play) {
        score += play.getFactions().globalSatisfaction() * (100 + 10 * play.getNbYears()) + play.getFactions().globalPopulation() / 2;
    }

}
