package fr.esgi.factions;

public class Factions {

    private double capitalistSatisfaction = 50.0;
    private double communistSatisfaction = 50.0;
    private double liberalsSatisfaction = 50.0;
    private double churchSatisfaction = 50.0;
    private double militaristSatisfaction = 50.0;
    private double nationalistSatisfaction = 50.0;
    private double loyalistSatisfaction = 50.0;

    private int capitalistPopulation = 10;
    private int communistPopulation = 10;
    private int liberalsPopulation = 10;
    private int churchPopulation = 10;
    private int militaristPopulation = 10;
    private int nationalistPopulation = 10;
    private int loyalistPopulation = 20;

    public double globalSatisfaction() {
        double globalPopulation = globalPopulation();
        return (capitalistSatisfaction * capitalistPopulation +
                communistSatisfaction * communistPopulation +
                liberalsSatisfaction * liberalsPopulation +
                churchSatisfaction * churchPopulation +
                militaristSatisfaction * militaristPopulation +
                nationalistSatisfaction * nationalistPopulation +
                loyalistSatisfaction * loyalistPopulation) / globalPopulation;
    }

    public int globalPopulation() {
        return capitalistPopulation +
                communistPopulation +
                liberalsPopulation +
                churchPopulation +
                militaristPopulation +
                nationalistPopulation +
                loyalistPopulation;
    }

    public void setSatisfaction(double[] factionSatisfaction) {
        capitalistSatisfaction = factionSatisfaction[0];
        communistSatisfaction = factionSatisfaction[1];
        liberalsSatisfaction = factionSatisfaction[2];
        churchSatisfaction = factionSatisfaction[3];
        militaristSatisfaction = factionSatisfaction[4];
        nationalistSatisfaction = factionSatisfaction[5];
        loyalistSatisfaction = factionSatisfaction[6];
    }

    public void setGlobalSatisfaction(double globalSatisfaction) {
        capitalistSatisfaction += globalSatisfaction;
        communistSatisfaction += globalSatisfaction;
        liberalsSatisfaction += globalSatisfaction;
        churchSatisfaction += globalSatisfaction;
        militaristSatisfaction += globalSatisfaction;
        nationalistSatisfaction += globalSatisfaction;
        loyalistSatisfaction += globalSatisfaction;
    }

    public void setPopulation(int[] newPopulation) {
        capitalistPopulation = newPopulation[0];
        communistPopulation = newPopulation[1];
        liberalsPopulation = newPopulation[2];
        churchPopulation = newPopulation[3];
        militaristPopulation = newPopulation[4];
        nationalistPopulation = newPopulation[5];
        loyalistPopulation = newPopulation[6];
    }

    public int[] getPopulation() {
        return new int[]{capitalistPopulation,
                communistPopulation,
                liberalsPopulation,
                churchPopulation,
                militaristPopulation,
                nationalistPopulation,
                loyalistPopulation};
    }

    public double[] getSatisfaction() {
        return new double[]{capitalistSatisfaction,
                communistSatisfaction,
                liberalsSatisfaction,
                churchSatisfaction,
                militaristSatisfaction,
                nationalistSatisfaction,
                loyalistSatisfaction};
    }
}
