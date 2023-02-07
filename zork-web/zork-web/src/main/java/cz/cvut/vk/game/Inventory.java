package cz.cvut.vk.game;

import java.util.HashMap;

public interface Inventory {

    String addItem(Item item, GameData gameData);

    HashMap<Integer, Item> getItems();

    void dropItem(Item item, GameData gameData);

    boolean containKey();

}
