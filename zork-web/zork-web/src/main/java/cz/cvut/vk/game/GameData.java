package cz.cvut.vk.game;

import java.util.List;

public interface GameData {

    boolean isFinished();
    void setFinished(boolean finished, boolean bygame);
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

    String inventoryChanged();

    boolean didWon();

    void setWon(boolean won);

    boolean ended();

    Room getExit(Room room);

    void setNews(String news);

    String getNews();
}
