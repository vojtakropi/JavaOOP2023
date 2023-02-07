package cz.cvut.vk.game;

public class Potion implements Item{

    private static final int ID = 4;

    private String description;

    private int restoreHP;

    private String name;

    public Potion(String description, String name, int restoreHP) {
        this.description = description;
        this.name = name;
        this.restoreHP = restoreHP;
    }

    public int getRestoreHP() {
        return restoreHP;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return "Lektvar životů " + name +
                ", Léčení=" + restoreHP;
    }
}
