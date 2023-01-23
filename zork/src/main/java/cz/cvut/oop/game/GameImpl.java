package cz.cvut.oop.game;

import cz.cvut.oop.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  Class represents running game instance
 *
 */
public class GameImpl implements Game {

    private Map<String, Command> commands = new HashMap<>();
    private GameData gameData;

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public static final String ANSI_GREEN = "\u001B[32m";


    public static final String ANSI_RED = "\u001B[31m";



    public GameImpl(){
        this.registerCommands();
        this.gameData = new GameDataImpl();
    }

    /**
     *  Method registering immutable Command instances
     *
     */
    private void registerCommands(){
        Command help = new HelpCommand(commands);
        Command reset = new ResetCommand();
        GoCommand go = new GoCommand();
        AttackCommand attack = new AttackCommand();
        PicUpCommand picUp = new PicUpCommand();
        EndCommand end = new EndCommand();
        DropCommand drop = new DropCommand();
        UsePotionCommand potion = new UsePotionCommand();
        commands.put(potion.getName(), potion);
        commands.put(drop.getName(), drop);
        commands.put(end.getName(), end);
        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
        commands.put(attack.getName(), attack);
        commands.put(picUp.getName(), picUp);

    }

    /**
     *  Method returns welcome message which should be printed right after
     *  game is started
     */
    @Override
    public String welcomeMessage() {
        //TODO doplnit pořádnou uvítací hlášku
        return  ANSI_RED_BACKGROUND + ANSI_GREEN  + "Vítej ve hře Vojtův Dungeon" + ANSI_RESET  + "\n pokud nevíte co a jak, použijte příkaz 'nápověda' \n právě jste v místonti: "
                + gameData.getCurrentRoom().getDescription() +"\n Další místnost je " + gameData.getCurrentRoom().getExits()+
                "\n v místnosti jsou tyto předměty: " + gameData.getCurrentRoom().getItems() +
                "\n a pozor na tohoto nepřitele: " + gameData.getCurrentRoom().getEnemy().toString();
    }

    /**
     *  Method returns end message which should be printed right after
     *  game is finished
     */
    @Override
    public String endMessage() {
        if (gameData.didWon()){
            return ANSI_RED + "Gratuluju k výhře, jsi opravdový šampion" + ANSI_RESET;
        }
        return ANSI_RED + "Dobrá hra, nenech si tím nějak zhoršit náladu, že jsi to nezvládl a zkus to znovu" + ANSI_RESET;
    }

    /**
     *  Method parses input line and should divide its parts to command name
     *  and array of input arguments (0-N). Based on parsed command name,
     *  specific command should be looked up and executed. If none is found,
     *  default message should be returned
     */
    @Override
    public String processTextCommand(String line) {
        //TODO zpracovat z řádku příkaz a argumenty a naplnit kde je to potřeba
        String result;
        String[] args = line.split(" ");
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            result = command.execute(args, gameData);
            if(!Objects.equals(command.getName(), "utok") && !Objects.equals(command.getName(), "reset" ) && gameData.getCurrentRoom().getEnemy().isAlive()
            && !Objects.equals(command.getName(), "vypij") && !Objects.equals(command.getName(), "konec")){
                System.out.println(gameData.getCurrentRoom().getEnemy().strikeBack(gameData));
            }
        }
        else{
            result = "Neznámý příkaz, zkuste jiný nebo vyzkoušejte příkaz 'nápověda'";
        }
        return result;
    }

    /**
     *  Method delegates its call to mutable GameData instance, which hold current game state. This
     *  state should be checked after each command evaluation a possibly terminate whole app if
     *  true is returned
     */
    @Override
    public boolean isFinished() {
        return gameData.isFinished();
    }
}
