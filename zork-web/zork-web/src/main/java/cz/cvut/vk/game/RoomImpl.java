package cz.cvut.vk.game;

import java.util.*;

/**
 *  Class represents Room, e.g. space in our game. It contains exits and can form a map of Rooms
 */
public class RoomImpl implements Room {

    private String name;
    private String description;
    private Map<String,Room> exits = new HashMap<>();

    private LinkedList<Item> items = new LinkedList<>();

    private Enemy enemy;


    public RoomImpl() {
    }

    public RoomImpl(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     *  Adds new exit to map
     */
    @Override
    public void registerExit(Room room){
        exits.put(room.getName(), room);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     *  Method returns description of this room (from getDescription call)
     *  and should add possible exit names
     */
    @Override
    public String getDescriptionWithExits() {
        return this.name + ": " +this.description + "\n východy: " + String.join(", ", this.exits.keySet());
    }

    /**
     *  Method returns description of this room
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Return unmodifiable view of our map
     */
    @Override
    public Set<String> getExits() {
        return exits.keySet();
    }

    @Override
    public StringBuilder getItems() {
        StringBuilder it = new StringBuilder();
        for (Item temp : items) {
           it.append(temp.getName()).append(",");
        }
        return it;
    }

    /**
     *  Returns room based on entered room (exit) name
     */
    @Override
    public Room getExitByName(String name) {
        return exits.getOrDefault(name, null);
    }

    @Override
    public void registerEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }


    @Override
    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public void removeItem(Item item){
        items.remove(item);
    }

    @Override
    public Item GetItemByName(String name) {
        for (Item temp : items) {
            if(temp.getName().equals(name)){
              return temp;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomImpl room = (RoomImpl) o;
        return Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
