package cz.cvut.vk.game;

import java.util.List;
import java.util.Set;

public interface Room {

    String getName();
    String getDescription();
    void registerEnemy(Enemy enemy);

    Enemy getEnemy();

    StringBuilder getItems();

    void addItem(Item item);

    void removeItem(Item item);

    Item GetItemByName(String name);

    boolean isFinalRoom();

}
