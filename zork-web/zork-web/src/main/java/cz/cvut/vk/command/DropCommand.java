package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Item;

public class DropCommand implements Command{
    @Override
    public String getName() {
        return "zahod";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if(arguments == null || arguments.length<2){
            return "zadej predmet k zahozeni";
        }
        String itemname = arguments[1];
        Item item = gameData.getIventory().getItemByName(itemname);
        if(item == null){
            return "nemas v inventari tento predmet";
        }
        item.Drop(gameData);
        return "Předmět:" + item.getName() +" zahozen";
    }
}
