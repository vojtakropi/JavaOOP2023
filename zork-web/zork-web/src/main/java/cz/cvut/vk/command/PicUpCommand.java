package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Item;



public class PicUpCommand implements Command {
    @Override
    public String getName() {
        return "seber";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemname = arguments[1];
        Item item = gameData.getCurrentRoom().GetItemByName(itemname);
        if (item == null) return "neznami predmet";
        String inventory = item.picUp(gameData);
        gameData.getCurrentRoom().removeItem(item);
        return  "Předmět:" + item.getName() +" sebrán" + "\n" + inventory;
    }
}
