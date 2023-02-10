package cz.cvut.vk.game;

import java.util.HashMap;

public class EnemyFactory {

    private static final HashMap<String, EnemyImpl.EnemyBuilder> enemymap= new HashMap<>();

    public static EnemyImpl.EnemyBuilder getEnemy(String name) {
        EnemyImpl.EnemyBuilder enemy = enemymap.get(name);

        if(enemy == null) {
            switch (name) {
                case "trol" -> {
                    enemy = new EnemyImpl.EnemyBuilder("trol");
                    enemymap.put(name, enemy);
                }
                case "rytir" -> {
                    enemy = new EnemyImpl.EnemyBuilder("rytir");
                    enemymap.put(name, enemy);
                }
                case "Lucius" -> {
                    enemy = new EnemyImpl.EnemyBuilder("Lucius");
                    enemymap.put(name, enemy);
                }
            }
        }
        return enemy;
    }

}
