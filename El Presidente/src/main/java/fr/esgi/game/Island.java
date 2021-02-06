package fr.esgi.game;

public class Island {

    private int farmLevel = 30;
    private int indusLevel = 30;

    public int yearlyHarvest() {
        return 40 * farmLevel;
    }

    public int yearlyTaxes() {
        return 10 * indusLevel;
    }

    public boolean checkIslandUsage(int farm, int indus) {
        return farm + indus + farmLevel + indusLevel <= 100;
    }

    public int getFarmLevel() {
        return farmLevel;
    }

    public int getIndusLevel() {
        return indusLevel;
    }

    public void setFarmLevel(int farmLevel) {
        this.farmLevel = farmLevel;
    }

    public void setIndusLevel(int indusLevel) {
        this.indusLevel = indusLevel;
    }


}
