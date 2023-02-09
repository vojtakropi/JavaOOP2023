package cz.cvut.vk.game;

import cz.cvut.vk.command.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    private LocalDateTime startdate;

    private long diference;

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
        //startdate = java.time.LocalDateTime.now();
        return  "Vítej ve hře Vojtův Dungeon \n pokud nevíte co a jak, použijte příkaz 'nápověda' \n právě jste v místonti: "
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
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            result = command.execute(args, gameData);
            if(!Objects.equals(command.getName(), "utok") && !Objects.equals(command.getName(), "reset" ) && gameData.getCurrentRoom().getEnemy().isAlive()
            && !Objects.equals(command.getName(), "vypij") && !Objects.equals(command.getName(), "konec") && !Objects.equals(command.getName(), "napoveda")){
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
        //enddate = java.time.LocalDateTime.now();
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
