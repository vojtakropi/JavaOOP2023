package cz.cvut.oop.command;

import cz.cvut.vk.command.Command;
import cz.cvut.vk.command.EquipCommand;
import cz.cvut.vk.command.HelpCommand;

import cz.cvut.vk.game.GameDataImpl;

import org.junit.Assert;
import org.junit.Test;


import java.util.HashMap;

public class HelpCommandTest {

    @Test
    public void help_whenCalled_thenInvokeHelpDialog(){
        EquipCommand equip = new EquipCommand();
        HashMap<String, Command> commands = new HashMap<>();
        commands.put(equip.getName(), equip);
        HelpCommand helpCommand = new HelpCommand(commands);

        GameDataImpl gameData = new GameDataImpl();

        String result = helpCommand.execute(null, gameData);
        Assert.assertTrue(result.contains("Nepřítel{"));
        Assert.assertTrue(result.contains("nasad"));
    }
}
