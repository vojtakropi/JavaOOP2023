package cz.cvut.vk.game;

public class Key implements Item{

    public String description;

    private String name;

    private static final int ID = 2;

    public Key(String description, String name) {
        this.description = description;
        this.name = name;
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
        return "Klíč: " + name;
    }
}
