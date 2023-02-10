package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Weapon;

import java.util.Objects;

public class AttackCommand implements Command{
    @Override
    public String getName() {
        return "utok";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if(arguments == null || arguments.length<2){
            return "zadej nepritele k utoku";
        }
            Weapon weapon = (Weapon) gameData.getIventory().getItems().get(1);
            if (weapon!=null && gameData.getIventory().isEquiped(weapon)){
                return gameData.GetEnemy().dealDmg(weapon, gameData);
            }
            return "nemáš nasazenou zbraň";
        }
    }

