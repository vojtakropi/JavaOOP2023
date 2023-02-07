package cz.cvut.vk.game;

public interface Item {


    int getID();
    String getDescription();

    String picUp(GameData gameData);

    void Drop(GameData gameData);

    String getName();

}
