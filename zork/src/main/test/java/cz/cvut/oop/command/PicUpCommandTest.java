package cz.cvut.oop.command;


import cz.cvut.vk.command.PicUpCommand;
import cz.cvut.vk.game.GameDataImpl;
import cz.cvut.vk.game.Item;
import cz.cvut.vk.game.Weapon;
import org.junit.Assert;
import org.junit.Test;

public class PicUpCommandTest {

    @Test
    public void pickUp_whenCalled_thenPickUpItemThatExists(){
        PicUpCommand picUpCommand = new PicUpCommand();

        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "hul"};
        String result = picUpCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("sebrán"));
    }
    @Test
    public void pickUp_whenCalled_thenPickUpItemThatNotExists(){
        PicUpCommand picUpCommand = new PicUpCommand();

        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "mec"};
        String result = picUpCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("neznami predmet"));
    }
}
