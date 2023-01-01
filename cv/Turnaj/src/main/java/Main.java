import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Tournament tournament = new Tournament();
        tournament.setLogger("turnaj");
        TeamInfo barca = new TeamInfo("barca");
        TeamInfo real = new TeamInfo("real madrid");
        TeamInfo bayern = new TeamInfo("bayern");
        // optional for auto tournament - tournament.registerTeam(new TeamInfo("barca"));
        tournament.registerTeam(barca);
        tournament.registerTeam(bayern);
        tournament.registerTeam(real);
        tournament.drawTournament();

        //automatic tournament simulation
        LinkedHashMap<TeamInfo, TeamInfo> draws = tournament.getDraws();
        Iterator<Map.Entry<TeamInfo, TeamInfo>> it = draws.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<TeamInfo, TeamInfo> pair = it.next();
            tournament.playGame(pair.getKey(), pair.getValue());
            it.remove();
        }
        System.out.println("TOURNAMENT WINNER IS !!!!!" + tournament.getTournamentWinner());

        //step by step just add games to play
        //tournament.playGame(barca, real);






    }
}