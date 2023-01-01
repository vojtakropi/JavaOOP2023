import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TournamentTest {

    @Test
    public void testdrawTournament(){
        TeamInfo a = new TeamInfo("a");
        TeamInfo b = new TeamInfo("b");
        TeamInfo c = new TeamInfo("c");
        LinkedHashMap<TeamInfo, TeamInfo> draws = new LinkedHashMap<>();
        LinkedHashMap<TeamInfo, TeamInfo> drawsexpected = new LinkedHashMap<>();
        List<TeamInfo> registeredTeams = new ArrayList<>();
        registeredTeams.add(a);
        registeredTeams.add(b);
        registeredTeams.add(c);
        for (TeamInfo team: registeredTeams) {
            for (TeamInfo team2: registeredTeams){
                if ((draws.containsKey(team2) && draws.containsValue(team)) || (draws.containsKey(team) && draws.containsValue(team2)) | (team == team2)){
                    continue;
                }
                draws.put(team, team2);
            }
        }
        drawsexpected.put(a,b);
        drawsexpected.put(b,c);
        drawsexpected.put(a,c);
        Assertions.assertEquals(drawsexpected, draws);
    }


}


