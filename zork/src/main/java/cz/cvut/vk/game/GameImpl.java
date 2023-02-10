package cz.cvut.vk.game;

import cz.cvut.vk.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 *  Class represents running game instance
 *
 */
public class GameImpl implements Game {

    private Map<String, Command> commands = new HashMap<>();
    private GameData gameData;

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    private LocalDateTime startdate;

    private long diference;

    private List<String> singleCommand =  Arrays.asList("napoveda", "reset", "konec");

    private List<String> noAtackComand = Arrays.asList("napoveda", "reset", "konec", "vypij", "utok");

    private LocalDateTime enddate;



    public GameImpl(){
        this.registerCommands();
        this.gameData = new GameDataImpl();
    }

    /**
     *  Method registering immutable Command instances
     *
     */
    private void registerCommands(){
        Command reset = new ResetCommand();
        GoCommand go = new GoCommand();
        AttackCommand attack = new AttackCommand();
        PicUpCommand picUp = new PicUpCommand();
        EndCommand end = new EndCommand();
        DropCommand drop = new DropCommand();
        UsePotionCommand potion = new UsePotionCommand();
        EquipCommand equip = new EquipCommand();
        commands.put(equip.getName(), equip);
        commands.put(potion.getName(), potion);
        commands.put(drop.getName(), drop);
        commands.put(end.getName(), end);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
        commands.put(attack.getName(), attack);
        commands.put(picUp.getName(), picUp);
        Command help = new HelpCommand(commands);
        commands.put(help.getName(), help);

    }

    /**
     *  Method returns welcome message which should be printed right after
     *  game is started
     */
    @Override
    public String welcomeMessage() {
        //startdate = java.time.LocalDateTime.now();
        return  "Vítej ve hře Vojtův Dungeon \n pokud nevíte co a jak, použijte příkaz 'nápověda' \n právě jste v místonti: "
                + gameData.getCurrentRoom().getDescription() +"\n Další místnost je " + gameData.getExit(gameData.getCurrentRoom()).getName()+
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
            return "Gratuluju k výhře, jsi opravdový šampion";
        }
        return "Dobrá hra, nenech si tím nějak zhoršit náladu, že jsi to nezvládl a zkus to znovu";
    }

    /**
     *  Method parses input line and should divide its parts to command name
     *  and array of input arguments (0-N). Based on parsed command name,
     *  specific command should be looked up and executed. If none is found,
     *  default message should be returned
     */
    @Override
    public String processTextCommand(String line) {
        String result;
        String[] args = line.split(" ");
        if (args.length<2 && !singleCommand.contains(args[0])){
             return "Neznámý příkaz, zkuste jiný nebo vyzkoušejte příkaz 'napoveda'";
        }
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            log.info(command.getName());
            gameData.setNews("");
            result = command.execute(args, gameData);
            result = result + "\n" + gameData.getNews();
            if(!noAtackComand.contains(command.getName()) && gameData.GetEnemy().isAlive()){
                result = result + "\n" + gameData.getCurrentRoom().getEnemy().strikeBack(gameData);
            }
            if (gameData.isFinished()) {
                diference = ChronoUnit.SECONDS.between(startdate, enddate);
                return result + "\n" +endMessage() + "\n KONEC HRY: tvuj cas byl: " + diference + "sekund";
            }else return result;
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
        enddate = java.time.LocalDateTime.now();
        return gameData.isFinished();
    }
    @Override
    public boolean ended() {
        return gameData.ended();
    }


    @Override
    public long getDiference() {
        return diference;
    }
}
