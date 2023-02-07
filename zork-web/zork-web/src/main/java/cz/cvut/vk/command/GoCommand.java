package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;
import cz.cvut.vk.game.Room;

import java.util.Objects;

public class GoCommand implements Command{
    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {

        String roomName = arguments[1];
        if (gameData.getCurrentRoom().getEnemy().isAlive()) return "nejdrive zabij nepritele v mistonsti";
        if(Objects.equals(gameData.getCurrentRoom().getName(), "hrad") && !gameData.getIventory().containKey()) return "Seber Klíč aby ses dostal přes tyto dveře";
        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);
        if(exitByName == null){
            return "neexistujici exit";
        }
        gameData.setCurrentRoom(exitByName);
        return "Přesunut do místnosti " + gameData.getCurrentRoom().getDescriptionWithExits() +
                "\n v místnosti jsou tyto předměty: " + gameData.getCurrentRoom().getItems() +
                "\n a pozor na tohoto nepřitele: " + gameData.getCurrentRoom().getEnemy().toString();
    }
}
