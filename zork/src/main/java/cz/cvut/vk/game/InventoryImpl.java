package cz.cvut.vk.game;

import java.util.*;


public class InventoryImpl implements Inventory {

    private HashMap<Integer, Item> items = new HashMap<>();

    private List<Item> equipedItems = new ArrayList<>();

    private List<Observer> observers = new ArrayList<>();

    public InventoryImpl() {
    }

    @Override
    public String addItem(Item item, GameData gameData) {
        if (items.size()>5){
            return "moc veci v inventari, nejdrive neco zahod";        
        }
       if(items.containsKey(item.getID())){
           items.put(item.getID(), item);
           gameData.getCurrentRoom().addItem(item);
           setNews(gameData);
           return item.getName() + " pridan do inventare";

       }else {
           items.put(item.getID(), item);
           setNews(gameData);
           return item.getName() + " pridan do inventare";
       }
    }
    @Override
    public String equipItem(Item item, GameData gameData) {
        if (items.size()>5){
            return "moc veci v inventari, nejdrive neco zahod";
        }
        if(items.containsKey(item.getID()) && items.get(item.getID()) == item) {
            equipedItems.add(item);
            return item.getName() + " nasazen";

        } else if (items.containsKey(item.getID()) && items.get(item.getID()) != item) {
            items.put(item.getID(), item);
            gameData.getCurrentRoom().addItem(item);
            equipedItems.add(item);
            setNews(gameData);
            return item.getName() + " nasazen";
        } else {
            items.put(item.getID(), item);
            equipedItems.add(item);
            setNews(gameData);
            return item.getName() + " nasazen";
        }
    }

    
    public Item getItemByName(String name){
        for (Map.Entry<Integer, Item> set: items.entrySet()) {
            if (Objects.equals(set.getValue().getName(), name)){
                return set.getValue();
            }
        }
        return null;
    }
    @Override
    public HashMap<Integer, Item> getItems() {
        return items;
    }

    @Override
    public void dropItem(Item item, GameData gameData) {
        gameData.getCurrentRoom().addItem(item);
        items.remove(item.getID());
        equipedItems.remove(item);
        setNews(gameData);
    }

    @Override
    public boolean containKey() {
        return items.containsKey(2);
    }

    @Override
    public String toString() {
        return "Invenář:" + items;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void setNews(GameData gameData) {
        for (Observer observer : this.observers) {
            observer.update(gameData.inventoryChanged());
        }
    }

    public boolean isEquiped(Item item) {
        if (equipedItems.contains(item)){
            return true;
        }
        return false;
    }
}
