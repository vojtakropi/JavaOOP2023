package cz.cvut.vk.game;

import java.util.HashMap;

public interface Inventory {

    String addItem(Item item, GameData gameData);

    String equipItem(Item item, GameData gameData);

    HashMap<Integer, Item> getItems();

    void dropItem(Item item, GameData gameData);

    boolean containKey();

    Item getItemByName(String name);

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void setNews(GameData gameData);

    boolean isEquiped(Item item);

}
