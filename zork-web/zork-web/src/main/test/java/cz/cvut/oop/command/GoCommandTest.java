package cz.cvut.oop.command;

import cz.cvut.vk.command.GoCommand;

import cz.cvut.vk.game.GameDataImpl;
import cz.cvut.vk.game.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GoCommandTest {

    @Test
    public void go_whenCalled_thenInvokeGoOnGameDataNullArgs(){
        GoCommand goCommand = new GoCommand();

        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        String result = goCommand.execute(null, gameData);
        Assert.assertTrue(result.contains("zadej kam chces jit"));
    }

    @Test
    public void go_whenCalled_thenInvokeGoOnGameDataWrongPath(){
        GoCommand goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        gameData.getCurrentRoom().getEnemy().dealDmg(new Weapon("", 100, 100, ""), gameData);
        String[] args = {"jdi", "les"};
        String result = goCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("neexistujici exit"));
    }

    @Test
    public void go_whenCalled_thenInvokeGoOnGameDataRightPath(){
        GoCommand goCommand = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        gameData.getCurrentRoom().getEnemy().dealDmg(new Weapon("", 100, 100, ""), gameData);
        String[] args = {"jdi", "hrad"};
        String result = goCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("Přesunut do místnosti"));
    }
}
