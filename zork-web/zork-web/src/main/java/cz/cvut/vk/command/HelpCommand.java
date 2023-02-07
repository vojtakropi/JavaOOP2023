package cz.cvut.vk.command;

import cz.cvut.vk.game.GameData;

import java.util.Map;

public class HelpCommand implements Command {

    private Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands){
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "napoveda";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return "Můžeš provádět tyto akce " + commands.keySet() + "\n v místnosti máš tyto přeměty " + gameData.getCurrentRoom().getItems() + "\n tohoto nepřítele "
                + gameData.getCurrentRoom().getEnemy().toString() + "\n toto je tvůj inventář " + gameData.getIventory().toString() + "\n další místonost je: " + gameData.getCurrentRoom().getExits();
    }
}

