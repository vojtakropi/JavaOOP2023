package cz.cvut.oop.command;

import cz.cvut.vk.command.DropCommand;
import cz.cvut.vk.command.EquipCommand;
import cz.cvut.vk.command.PicUpCommand;
import cz.cvut.vk.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;

public class EquipCommandTest {

    @Test
    public void equip_whenCalled_thenEquipItemThatExistsInInventory() {
        EquipCommand equipCommand = new EquipCommand();
        PicUpCommand picUpCommand = new PicUpCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "hul"};
        picUpCommand.execute(args, gameData);
        String[] args2 = {"nasad", "hul"};
        String result = equipCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("Předmět:hul nasazen"));
    }

    @Test
    public void equip_whenCalled_thenEquipItemThatExistsInRoom() {
        EquipCommand equipCommand = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args2 = {"nasad", "hul"};
        String result = equipCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("Předmět:hul nasazen"));
    }
    @Test
    public void equip_whenCalled_thenEquipItemThatNotExistsInRoomOrInventory() {
        EquipCommand equipCommand = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args2 = {"nasad", "mec"};
        String result = equipCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("neznami predmet"));
    }


}
