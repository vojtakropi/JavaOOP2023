package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Potion;

import java.util.Objects;

public class UsePotionCommand implements Command{

    @Override
    public String getName() {
        return "vypij";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemname = arguments[1];
        Potion item = (Potion) gameData.getIventory().getItems().get(4);
        if(item == null) return "nemas lektvary";
        if(!Objects.equals(item.getName(), itemname)) return "nemáš lektvar s tímhle jménem";
        if(gameData.getHP()+item.getRestoreHP() > gameData.getMaxHP()){
            gameData.setHP(gameData.getMaxHP());
            item.Drop(gameData);
            return "Životy vyléčeny o "+ (gameData.getMaxHP()- gameData.getHP())+" bodů zdraví";
        }
        gameData.setHP(gameData.getHP()+item.getRestoreHP());
        item.Drop(gameData);
        return "Životy vyléčeny o " + item.getRestoreHP() +" bodů zdraví";
    }
}
