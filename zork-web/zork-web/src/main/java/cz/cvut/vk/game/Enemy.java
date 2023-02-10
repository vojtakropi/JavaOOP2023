package cz.cvut.vk.game;

public interface Enemy {

    String getName();

    int getHp();

    String dealDmg(Weapon weapon, GameData gameData);

    boolean isAlive();

    String strikeBack(GameData gameData);


    boolean isBoss();

}
