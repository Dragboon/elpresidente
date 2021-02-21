package fr.esgi.game;

public class Island {

    private int farmLevel = 10;
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
        if (farmLevel + indusLevel <= 100 && farmLevel >= 0) {
            this.farmLevel = farmLevel;
        } else if (farmLevel < 0) {
            this.farmLevel = 0;
        } else {
            this.farmLevel = 100 - indusLevel;
        }
    }

    public void setIndusLevel(int indusLevel) {
        if (indusLevel + farmLevel <= 100 && indusLevel >= 0) {
            this.indusLevel = indusLevel;
        } else if (indusLevel < 0) {
            this.indusLevel = 0;
        } else {
            this.indusLevel = 100 - farmLevel;
        }
    }

}
