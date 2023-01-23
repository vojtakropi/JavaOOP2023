package cz.cvut.oop.game;

public interface Enemy {

    String getName();

    int getHp();

    Enemy setHP(int HP);
    String dealDmg(Weapon weapon, GameData gameData);

    boolean isAlive();

    String strikeBack(GameData gameData);

    Enemy setName(String name);

    Enemy setDmgHigh(int dmgHigh);

    Enemy setDmgLow(int dmgLow);

}
