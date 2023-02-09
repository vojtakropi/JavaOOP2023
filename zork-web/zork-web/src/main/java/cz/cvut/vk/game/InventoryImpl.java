package cz.cvut.vk.game;

import java.util.HashMap;



public class InventoryImpl implements Inventory {

    private HashMap<Integer, Item> items = new HashMap<>();

    public InventoryImpl() {
    }

    @Override
    public String addItem(Item item, GameData gameData) {
       if(items.containsKey(item.getID())){
           items.put(item.getID(), item);
           gameData.getCurrentRoom().addItem(item);
           return gameData.inventoryChanged();

       }else {
           items.put(item.getID(), item);
           return gameData.inventoryChanged();
       }
    }

    @Override
    public HashMap<Integer, Item> getItems() {
        return items;
    }

    @Override
    public void dropItem(Item item, GameData gameData) {
        gameData.getCurrentRoom().addItem(item);
        items.remove(item.getID());
        gameData.inventoryChanged();
    }

    @Override
    public boolean containKey() {
        return items.containsKey(2);
    }

    @Override
    public String toString() {
        return "Invenář:" + items;
    }


}
