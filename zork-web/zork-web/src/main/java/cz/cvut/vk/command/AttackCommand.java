package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Weapon;

public class AttackCommand implements Command{
    @Override
    public String getName() {
        return "utok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        try {
            Weapon weapon = (Weapon) gameData.getIventory().getItems().get(1);
            return gameData.GetEnemy().dealDmg(weapon, gameData);
        }catch (Exception e){
            return "nemáš zbraň";
        }
    }
}
