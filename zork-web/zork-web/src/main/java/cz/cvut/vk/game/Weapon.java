package cz.cvut.vk.game;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon implements Item {

    private String description;

    private int dmgLow;

    private int dmgHigh;

    private String name;

    private static final int ID = 1;

    public Weapon(String description, int dmgLow, int dmgHigh, String name) {
        this.description = description;
        this.dmgLow = dmgLow;
        this.dmgHigh = dmgHigh;
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getDescription() {
        return description + "\n Poškození je ("+ dmgLow +" - " + dmgHigh+")";
    }

    @Override
    public String picUp(GameData gameData) {
        return gameData.getIventory().addItem(this, gameData);
    }

    @Override
    public void Drop(GameData gameData) {
        gameData.getIventory().dropItem(this, gameData);
    }

    @Override
    public String getName() {
        return name;
    }

    public int calculateDmg(){
        return ThreadLocalRandom.current().nextInt(dmgLow, dmgHigh + 1);
    }

    @Override
    public String toString() {
        return "Zbraň: "+ name + " dmgHigh: "+ dmgHigh+ ", dgmLow: "+ dmgLow;
    }
}
