package fr.esgi.events;

import fr.esgi.jsonconfig.EventsParametersConfig;
import fr.esgi.exceptions.EventsParametersNotFound;
import fr.esgi.game.Play;
import fr.esgi.readers.EventsParametersReader;

import java.io.IOException;

public class EventsParameters {
    private int money;
    private int food;
    private int industry;
    private int farm;
    private double[] factionsSatisfaction;
    private int[] factionsPopulation;
    private boolean isMandatory;

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getIndustry() {
        return industry;
    }

    public int getFarm() {
        return farm;
    }

    public double[] getFactionsSatisfaction() {
        return factionsSatisfaction;
    }

    public int[] getFactionsPopulation() {
        return factionsPopulation;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public boolean checkChoice(Play play) {
        if (isMandatory) {
            return true;
        }
        if (play.getFood() + food < 0 || play.getMoney() + money < 0) {
            return false;
        }
        return true;
    }

    public void setEventsParameters (String eventName, int choice) throws EventsParametersNotFound {

        EventsParametersReader eventsParametersReader = new EventsParametersReader();
        EventsParametersConfig eventsParametersConfig;

        try {
            eventsParametersConfig = eventsParametersReader.getEventParameters();
            money = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getMoney();
            food = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getFood();
            industry = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getIndustry();
            farm = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getFarm();
            factionsSatisfaction = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getFactionsSatisfaction();
            factionsPopulation = eventsParametersConfig.getParameters().get(eventName)[choice - 1].getFactionsPopulation();
            isMandatory = eventsParametersConfig.getParameters().get(eventName)[choice - 1].isMandatory();
        } catch (IOException e) {
            throw new EventsParametersNotFound();
        }
    }

    public void applyParameters(Play play) {
        double[] satisfaction = new double[factionsSatisfaction.length];
        int[] population = new int[factionsPopulation.length];

        play.setMoney(money + play.getMoney());
        play.setFood(food + play.getFood());
        play.getIsland().setIndusLevel(industry + play.getIsland().getIndusLevel());
        play.getIsland().setFarmLevel(farm + play.getIsland().getFarmLevel());
        for (int i = 0; i < factionsSatisfaction.length; i++) {
            if (play.getFactions().getSatisfaction()[i] != 0) {
                satisfaction[i] = factionsSatisfaction[i] + play.getFactions().getSatisfaction()[i];
            } else {
                satisfaction[i] = 0;
            }
            population[i] = (factionsPopulation[i] * play.getFactions().getPopulation()[i] / 100) + play.getFactions().getPopulation()[i];
        }
        play.getFactions().setSatisfaction(satisfaction);
        play.getFactions().setPopulation(population);
    }

}
