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
        capitalistSatisfaction = Math.min(Math.max(factionSatisfaction[0], 0), 100);
        communistSatisfaction = Math.min(Math.max(factionSatisfaction[1], 0),100);
        liberalsSatisfaction = Math.min(Math.max(factionSatisfaction[2], 0),100);
        churchSatisfaction = Math.min(Math.max(factionSatisfaction[3], 0),100);
        militaristSatisfaction = Math.min(Math.max(factionSatisfaction[4], 0),100);
        nationalistSatisfaction = Math.min(Math.max(factionSatisfaction[5], 0),100);
        loyalistSatisfaction = Math.min(Math.max(factionSatisfaction[6], 0),100);
    }

    public void setGlobalSatisfaction(double globalSatisfaction) {
        capitalistSatisfaction = Math.max(capitalistSatisfaction + globalSatisfaction, 0);
        communistSatisfaction += Math.max(communistSatisfaction + globalSatisfaction, 0);
        liberalsSatisfaction += Math.max(liberalsSatisfaction + globalSatisfaction, 0);
        churchSatisfaction += Math.max(churchSatisfaction + globalSatisfaction, 0);
        militaristSatisfaction += Math.max(militaristSatisfaction + globalSatisfaction, 0);
        nationalistSatisfaction += Math.max(nationalistSatisfaction + globalSatisfaction, 0);
        loyalistSatisfaction += Math.max(loyalistSatisfaction + globalSatisfaction, 0);
    }

    public void setPopulation(int[] newPopulation) {
        capitalistPopulation = Math.max(newPopulation[0], 0);
        communistPopulation = Math.max(newPopulation[1], 0);
        liberalsPopulation = Math.max(newPopulation[2], 0);
        churchPopulation = Math.max(newPopulation[3], 0);
        militaristPopulation = Math.max(newPopulation[4], 0);
        nationalistPopulation = Math.max(newPopulation[5], 0);
        loyalistPopulation = Math.max(newPopulation[6], 0);
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
