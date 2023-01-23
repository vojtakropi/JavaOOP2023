package cz.cvut.oop.game;

import java.util.Set;

public interface Room {

    String getName();
    String getDescription();
    String getDescriptionWithExits();
    Set<String> getExits();
    Room getExitByName(String name);

    void registerEnemy(Enemy enemy);

    Enemy getEnemy();

    StringBuilder getItems();

    void addItem(Item item);

    void showItems();

    Item GetItemByName(String name);
    void registerExit(Room room);

}
