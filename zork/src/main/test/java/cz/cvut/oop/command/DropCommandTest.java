package cz.cvut.oop.command;

import cz.cvut.vk.command.DropCommand;
import cz.cvut.vk.command.PicUpCommand;
import cz.cvut.vk.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;

public class DropCommandTest {

    @Test
    public void pickUp_whenCalled_thenPickUpItemThatExists() {
        DropCommand dropCommand = new DropCommand();
        PicUpCommand picUpCommand = new PicUpCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "hul"};
        picUpCommand.execute(args, gameData);
        String[] args2 = {"zahod", "hul"};
        String result = dropCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("Předmět:hul zahozen"));
    }

    @Test
    public void pickUp_whenCalled_thenPickUpItemThatNotExists() {
        DropCommand dropCommand = new DropCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args2 = {"zahod", "hul"};
        String result = dropCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("nemas v inventari tento predmet"));
    }
}
