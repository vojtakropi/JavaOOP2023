package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Item;

public class EquipCommand implements Command{
    @Override
    public String getName() {
        return "nasad";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String itemname = arguments[1];
        Item item;
        item = gameData.getCurrentRoom().GetItemByName(itemname);
        if (item == null){
            item = gameData.getIventory().getItemByName(itemname);
            if (item == null){
            return "neznami predmet";
            }
        }
        String inventory = item.equip(gameData);
        return  "Předmět:" + item.getName() +" nasazen" + "\n" + inventory;
    }
}
