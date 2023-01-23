package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Potion;

import java.util.Objects;

public class UsePotionCommand implements Command{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public String getName() {
        return "vypij";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemname = arguments[1];
        Potion item = (Potion) gameData.getIventory().getItems().get(4);
        if(!Objects.equals(item.getName(), itemname)) return "nemáš lektvar s tímhle jménem";
        if(gameData.getHP()+item.getRestoreHP() > gameData.getMaxHP()){
            gameData.setHP(gameData.getMaxHP());
            item.Drop(gameData);
            return ANSI_BLUE + "Životy vyléčeny o "+ (gameData.getMaxHP()- gameData.getHP())+" bodů zdraví" + ANSI_RESET;
        }
        gameData.setHP(gameData.getHP()+item.getRestoreHP());
        item.Drop(gameData);
        return ANSI_BLUE + "Životy vyléčeny o " + item.getRestoreHP() +" bodů zdraví" + ANSI_RESET;
    }
}
