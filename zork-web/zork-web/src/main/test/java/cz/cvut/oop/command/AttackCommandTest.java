package cz.cvut.oop.command;

import cz.cvut.vk.command.AttackCommand;
import cz.cvut.vk.command.EquipCommand;
import cz.cvut.vk.command.GoCommand;
import cz.cvut.vk.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AttackCommandTest {


    @Test
    public void atack_whenCalled_thenInvokeAtackOnEnemyWithoutWeapon(){
        AttackCommand attackCommand = new AttackCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());
        String[] args = {"utok", "trol"};
        String result = attackCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("nemáš nasazenou zbraň"));
    }

    @Test
    public void atack_whenCalled_thenInvokeAtackOnEnemyWithWeapon(){
        AttackCommand attackCommand = new AttackCommand();
        EquipCommand equipCommand = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        String[] args2 = {"nasad", "hul"};
        equipCommand.execute(args2, gameData);
        String[] args = {"utok", "trol"};
        String result = attackCommand.execute(args, gameData);
        Assert.assertTrue(result.contains("dobrá rána:"));
    }

    @Test
    public void atack_whenCalled_thenInvokeAtackOnEnemyWithoutEnemy(){
        AttackCommand attackCommand = new AttackCommand();
        GameDataImpl gameData = Mockito.spy(new GameDataImpl());
        String result = attackCommand.execute(null, gameData);
        Assert.assertTrue(result.contains("zadej nepritele k utoku"));
    }
}
