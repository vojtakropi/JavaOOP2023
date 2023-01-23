package cz.cvut.oop.game;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class EnemyImpl implements Enemy{

    private String name;

    private int HP;

    private boolean alive;

    private int dmgLow;

    private int dmgHigh;

    public EnemyImpl() {
        this.alive = true;
    }

    public Enemy setName(String name) {
        this.name = name;
        return this;
    }

    public Enemy setHP(int HP) {
        this.HP = HP;
        return this;
    }

    public Enemy setDmgLow(int dmgLow) {
        this.dmgLow = dmgLow;
        return this;
    }

    public Enemy setDmgHigh(int dmgHigh) {
        this.dmgHigh = dmgHigh;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return HP;
    }

    @Override
    public String dealDmg(Weapon weapon, GameData gameData) {
        int dmg = weapon.calculateDmg();
        HP = HP - dmg;
        if (!alive) return name + " je již mrtev, můžes postoupit do další místnosti";
        if (HP<=0){
            alive = false;
            gameData.setHP(gameData.getMaxHP());
            if (Objects.equals(gameData.getCurrentRoom().getEnemy().getName(), "Lucius")) {
                gameData.setWon(true);
            }
            return "Zabil jsi: " + name + " a obnovil sis všechny životy:" + gameData.getMaxHP();
        }
        String enemyHit = strikeBack(gameData);
        return "dobrá rána: "+ name +" má ještě "+ HP +" životů \n" + enemyHit;
    }
    @Override
    public String strikeBack(GameData gameData){
        int dmg = ThreadLocalRandom.current().nextInt(dmgLow, dmgHigh + 1);
        int hp = gameData.getHP();
        hp = hp - dmg;
        if(hp <= 0){
            gameData.setFinished(true);
            return "umřel jsi";
        }else {
            gameData.setHP(hp);
            return name + " tě trefil za " +dmg + " bodů poškození. Zbývá ti " + hp +" životů";
        }
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return "Nepřítel{" +
                "jméno='" + name + '\'' +
                ", Životy=" + HP +
                ", dmgLow=" + dmgLow +
                ", dmgHigh=" + dmgHigh +
                '}';
    }
}
