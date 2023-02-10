package cz.cvut.vk.game;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class EnemyImpl implements Enemy{

    private String name;

    private boolean isBoss;

    private int HP;

    private boolean alive;

    private int dmgLow;

    private int dmgHigh;

    private EnemyImpl(EnemyBuilder builder) {
        this.alive = true;
        this.name = builder.name;
        this.HP = builder.HP;
        this.dmgLow = builder.dmgLow;
        this.dmgHigh = builder.dmgHigh;
        this.isBoss = builder.isBoss;
    }

    @Override
    public boolean isBoss() {
        return isBoss;
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
            if (isBoss) {
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
            gameData.setFinished(true, true);
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
    public static class EnemyBuilder {


        private String name;

        private boolean isBoss;

        private int HP;

        private int dmgLow;

        private int dmgHigh;

        public EnemyBuilder(String name) {
            this.name = name;
        }

        public EnemyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EnemyBuilder setBoss(boolean boss) {
            isBoss = boss;
            return this;
        }

        public EnemyBuilder setHP(int HP) {
            this.HP = HP;
            return this;
        }

        public EnemyBuilder setDmgLow(int dmgLow) {
            this.dmgLow = dmgLow;
            return this;
        }

        public EnemyBuilder setDmgHigh(int dmgHigh) {
            this.dmgHigh = dmgHigh;
            return this;
        }

        public Enemy build() {
            return new EnemyImpl(this);
        }
    }
}
