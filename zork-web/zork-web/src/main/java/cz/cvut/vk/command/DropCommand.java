package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Item;

public class DropCommand implements Command{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    @Override
    public String getName() {
        return "zahod";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemname = arguments[1];
        Item item = gameData.getCurrentRoom().GetItemByName(itemname);
        item.Drop(gameData);
        return ANSI_BLUE + "Předmět:" + item.getName() +" zahozen" + ANSI_RESET;
    }
}
