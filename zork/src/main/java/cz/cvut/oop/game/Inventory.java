package cz.cvut.oop.game;

import java.util.HashMap;

public interface Inventory {

    void addItem(Item item, GameData gameData);

    HashMap<Integer, Item> getItems();

    void dropItem(Item item, GameData gameData);

    boolean containKey();

}
