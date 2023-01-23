package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

public class EndCommand implements Command{
    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true);
        return "hra skoncila";
    }
}
