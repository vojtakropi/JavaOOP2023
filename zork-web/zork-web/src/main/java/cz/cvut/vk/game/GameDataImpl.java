package cz.cvut.vk.game;

import java.util.ArrayList;
import java.util.List;

/**
 *  All mutable game data should exist within this class
 *  e.g. room map, finished, inventory, weapons..
 */
public class GameDataImpl implements GameData {

    private Room currentRoom;
    private boolean finished;

    private boolean bygame;
    private List<Room> rooms;

    private boolean win = false;

    private int HP = 100;

    private int maxHp;

    private Inventory inventory;

    @Override
    public void setMaxHP(int maxHp) {
        this.maxHp = maxHp;
    }
    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getMaxHP() {
        return maxHp;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public String inventoryChanged() {
        return inventory.toString();
    }

    @Override
    public boolean didWon() {
        return win;
    }

    @Override
    public void setWon(boolean won) {
        win = won;
        setFinished(true, true);
    }

    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.inventory = new InventoryImpl();
        this.init();
    }

    public void init(){
        maxHp = 100;
        this.rooms = new ArrayList<>();
        Room baseRoom = new RoomImpl("jeskyne", "temná jeskyně se spícím trolem");
        rooms.add(baseRoom);
        Room roomMid = new RoomImpl("hrad", "hrad který obýval král a jeho oddaný voják");
        rooms.add(roomMid);
        Room roomFinal = new RoomImpl("pohrebiste", "zde odpočívá nejsilnější voják hradní stráže - Lucius");
        rooms.add(roomFinal);
        baseRoom.registerExit(roomMid);
        roomMid.registerExit(roomFinal);

        Enemy trol = new EnemyImpl().setName("Trol").setDmgHigh(15).setDmgLow(3).setHP(25);
        Enemy rytir = new EnemyImpl().setName("Rytir").setDmgHigh(20).setDmgLow(10).setHP(48);
        Enemy lucius = new EnemyImpl().setName("Lucius").setDmgHigh(35).setDmgLow(25).setHP(99);
        baseRoom.registerEnemy(trol);
        roomMid.registerEnemy(rytir);
        roomFinal.registerEnemy(lucius);

        Item hul = new Weapon("drevena hul z dreva z temneho lesa", 2, 13, "hul");
        Item mec = new Weapon("mec kovany mistrem skritkem", 11, 27, "mec");
        Item hulka = new Weapon("magicka hul plna magicke magie ktera dela magickou magii", 20, 40, "hulka");
        Item klic = new Key("klic k neznamemu", "klic");
        Item brneni = new Armor(30, "brneni", "zelezne brneni");
        Item lektvar = new Potion("lektvar leceni", "lektvar", 50);
        Item rukavice = new Armor(10, "rukavice", "kozene rukavice");

        baseRoom.addItem(hul);
        baseRoom.addItem(rukavice);
        roomMid.addItem(mec);
        roomMid.addItem(klic);
        roomMid.addItem(brneni);
        roomMid.addItem(lektvar);
        roomFinal.addItem(hulka);

        this.currentRoom = baseRoom;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public Enemy GetEnemy() {
        return currentRoom.getEnemy();
    }

    /**
     *  Sets room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Inventory getIventory() {
        return inventory;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *  Sets finished flag, indicating game is done/finished
     */
    @Override
    public void setFinished(boolean finished, boolean bygame) {
        this.finished = finished;
        this.bygame = bygame;
    }

    /**
     *  Retrieves finished flag -> parent components decides whether to end the game
     *  based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }
    @Override
    public boolean ended() {
        return bygame;
    }
}
