package cz.cvut.vk.game;

public class Armor implements Item{

    private static final int ID = 3;

    private int HPGain;

    private String name;

    private String description;

    public Armor() {
    }

    public Armor(int HPGain, String name, String description) {
        this.HPGain = HPGain;
        this.name = name;
        this.description = description;
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
    public String equip(GameData gameData) {
        gameData.setMaxHP(gameData.getMaxHP()+HPGain);
        return this.name + " nasazeno, celkovy pocet zivotu se zvysil o " + HPGain;
    }

    @Override
    public void Drop(GameData gameData) {
        gameData.setMaxHP(gameData.getMaxHP()-HPGain);
        gameData.getIventory().dropItem(this, gameData);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Brnění: " + name +
                ", Životy navíc=" + HPGain;
    }
}
