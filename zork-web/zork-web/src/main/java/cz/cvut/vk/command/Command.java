package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;

/**
 *  Represents Command interface containing method to indentify and execute command
 */
public interface Command {

    String getName();
    String execute(String[] arguments, GameData gameData);



}
