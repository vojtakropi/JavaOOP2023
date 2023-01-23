package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

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
