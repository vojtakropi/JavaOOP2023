package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;

public class ResetCommand implements Command {
    @Override
    public String getName() {
        return "reset";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.init();
        return "hra uspesne resetovana.";
    }
}
