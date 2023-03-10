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

    public Map<String, Command> getCommands() {
        return commands;
    }

    public GameData getGameData() {
        return gameData;
    }

    public List<String> getSingleCommand() {
        return singleCommand;
    }

    public List<String> getNoAtackComand() {
        return noAtackComand;
    }


    private GameData gameData;

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    private long startdate;

    private long diference;

    private List<String> singleCommand =  Arrays.asList("napoveda", "reset", "konec");

    private List<String> noAtackComand = Arrays.asList("napoveda", "reset", "konec", "vypij", "utok");

    private long enddate;

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
        startdate = System.currentTimeMillis();
        return  "V??tej ve h??e Vojt??v Dungeon \n pokud nev??te co a jak, pou??ijte p????kaz 'n??pov??da' \n pr??v?? jste v m??stonti: "
                + gameData.getCurrentRoom().getDescription() +"\n Dal???? m??stnost je " + gameData.getExit(gameData.getCurrentRoom()).getName()+
                "\n v m??stnosti jsou tyto p??edm??ty: " + gameData.getCurrentRoom().getItems() +
                "\n a pozor na tohoto nep??itele: " + gameData.getCurrentRoom().getEnemy().toString();
    }

    /**
     *  Method returns end message which should be printed right after
     *  game is finished
     */
    @Override
    public String endMessage() {
        if (gameData.didWon()){
            return "Gratuluju k v??h??e, jsi opravdov?? ??ampion";
        }
        return "Dobr?? hra, nenech si t??m n??jak zhor??it n??ladu, ??e jsi to nezvl??dl a zkus to znovu";
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
             return "Nezn??m?? p????kaz, zkuste jin?? nebo vyzkou??ejte p????kaz 'napoveda'";
        }
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            log.info(command.getName());
            gameData.setNews("");
            result = command.execute(args, gameData);
            result = result + "\n" + gameData.getNews();
            if(!noAtackComand.contains(command.getName())){
                result = result + "\n" + gameData.getCurrentRoom().getEnemy().strikeBack(gameData);
            }
            if (gameData.isFinished()) {
                diference = (enddate-startdate)/1000;
                return result + "\n" +endMessage() + "\n KONEC HRY: tvuj cas byl: " + diference + "sekund";
            }else return result;
        }
        else{
            result = "Nezn??m?? p????kaz, zkuste jin?? nebo vyzkou??ejte p????kaz 'n??pov??da'";
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
        enddate = System.currentTimeMillis();
        return gameData.isFinished();
    }
    @Override
    public boolean ended() {
        return gameData.ended();
    }


    @Override
    public long getDiference() {
        return (System.currentTimeMillis()-startdate)/1000;
    }
}
