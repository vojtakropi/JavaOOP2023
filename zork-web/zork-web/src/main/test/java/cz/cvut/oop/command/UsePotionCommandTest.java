package cz.cvut.oop.command;

import cz.cvut.vk.command.PicUpCommand;
import cz.cvut.vk.command.UsePotionCommand;
import cz.cvut.vk.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;

public class UsePotionCommandTest {

    @Test
    public void usePotion_whenCalled_thenUsePotionThatExistsInInventory() {
        UsePotionCommand usePotionCommand= new UsePotionCommand();
        PicUpCommand picUpCommand = new PicUpCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "kapka"};
        picUpCommand.execute(args, gameData);
        String[] args2 = {"vypij", "kapka"};
        String result = usePotionCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("Životy vyléčeny o 0 bodů zdraví"));
    }

    @Test
    public void usePotion_whenCalled_thenUsePotionThatNotExistsInInventory() {
        UsePotionCommand usePotionCommand = new UsePotionCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args2 = {"vypij", "kapka"};
        String result = usePotionCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("nemas lektvary"));
    }
    @Test
    public void usePotion_whenCalled_thenUsePotionThatExistsInInventoryBadName() {
        UsePotionCommand usePotionCommand= new UsePotionCommand();
        PicUpCommand picUpCommand = new PicUpCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args = {"seber", "kapka"};
        picUpCommand.execute(args, gameData);
        String[] args2 = {"vypij", "kappa"};
        String result = usePotionCommand.execute(args2, gameData);
        Assert.assertTrue(result.contains("nemáš lektvar s tímhle jménem"));
    }
}
