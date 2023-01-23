package cz.cvut.oop.game;

public interface Item {


    int getID();
    String getDescription();

    void picUp(GameData gameData);

    void Drop(GameData gameData);

    String getName();

}
