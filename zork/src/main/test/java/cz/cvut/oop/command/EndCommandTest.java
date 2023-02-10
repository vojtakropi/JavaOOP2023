package cz.cvut.oop.command;

import cz.cvut.vk.command.EndCommand;

import cz.cvut.vk.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;

public class EndCommandTest {

    @Test
    public void end_whenCalled_thenInvokeEndGame(){
        EndCommand endCommand = new EndCommand();

        GameDataImpl gameData = new GameDataImpl();

        String result = endCommand.execute(null, gameData);
        Assert.assertTrue(result.contains("hra skoncila"));
    }
}
