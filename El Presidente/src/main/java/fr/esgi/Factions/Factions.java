package fr.esgi.factions;

public class Factions {

    private int capitalistSatisfaction = 50;
    private int communistSatisfaction = 50;
    private int liberalsSatisfaction = 50;
    private int churchSatisfaction = 50;
    private int militaristSatisfaction = 50;
    private int nationalistSatisfaction = 50;
    private int loyalistSatisfaction = 50;

    private int capitalistPopulation = 10;
    private int communistPopulation = 10;
    private int liberalsPopulation = 10;
    private int churchPopulation = 10;
    private int militaristPopulation = 10;
    private int nationalistPopulation = 10;
    private int loyalistPopulation = 20;

    public int globalSatisfaction() {
        return ((capitalistSatisfaction * capitalistPopulation) +
                (communistSatisfaction * communistPopulation) +
                (liberalsSatisfaction * liberalsPopulation) +
                (churchSatisfaction * churchPopulation) +
                (militaristSatisfaction * militaristPopulation) +
                (nationalistSatisfaction * nationalistPopulation) +
                (loyalistSatisfaction * loyalistPopulation)) / globalPopulation();
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

    public void setSatisfaction(int cap, int com, int lib, int church, int mil, int nat, int loy) {
        capitalistSatisfaction = cap;
        communistSatisfaction = com;
        liberalsSatisfaction = lib;
        churchSatisfaction = church;
        militaristSatisfaction = mil;
        nationalistSatisfaction = nat;
        loyalistSatisfaction = loy;
    }

    public void setGlobalSatisfaction(int globalSatisfaction) {
        capitalistSatisfaction = globalSatisfaction;
        communistSatisfaction = globalSatisfaction;
        liberalsSatisfaction = globalSatisfaction;
        churchSatisfaction = globalSatisfaction;
        militaristSatisfaction = globalSatisfaction;
        nationalistSatisfaction = globalSatisfaction;
        loyalistSatisfaction = globalSatisfaction;
    }

    public void setPopulation(int cap, int com, int lib, int church, int mil, int nat, int loy) {
        capitalistPopulation = cap;
        communistPopulation = com;
        liberalsPopulation = lib;
        churchPopulation = church;
        militaristPopulation = mil;
        nationalistPopulation = nat;
        loyalistPopulation = loy;
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

    public int[] getSatisfaction() {
        return new int[]{capitalistSatisfaction,
                communistSatisfaction,
                liberalsSatisfaction,
                churchSatisfaction,
                militaristSatisfaction,
                nationalistSatisfaction,
                loyalistSatisfaction};
    }
}
