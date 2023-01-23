package cz.cvut.oop.game;

import java.util.List;

public interface GameData {

    boolean isFinished();
    void setFinished(boolean finished);
    Room getCurrentRoom();
    List<Room> getRooms();

    Enemy GetEnemy();
    void setCurrentRoom(Room currentRoom);

    Inventory getIventory();
    void init();

    int getHP();

    void setMaxHP(int maxHP);

    int getMaxHP();

    void setHP(int hp);

    void inventoryChanged();

    boolean didWon();

    void setWon(boolean won);
}
