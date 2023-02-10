package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;

public class EndCommand implements Command{
    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true, false);
        return "hra skoncila";
    }
}
