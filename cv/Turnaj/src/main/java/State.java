import java.util.List;
import java.util.logging.Logger;

public class State {

    private boolean inProgress;

    private int matchTime;


    public int checkMatchWin(int home, int away){
        if (home > away){
            return 1;
        } else if (home < away) {
            return 2;
        }else return 0;
    }

    public void Goal(TeamInfo team, Logger logger){
        if (!inProgress){ return; }
        logger.info(": team " + team.getName() + " scored a goal");
        int goals = team.getGoals();
        team.setGoals(goals+1);
    }

    public int[] GetMatchScore(TeamInfo team1, TeamInfo team2){
        if (!inProgress){ return new int[]{}; }
        return new int[]{team1.getGoals(), team2.getGoals()};
    }


    public void Start(TeamInfo team1, TeamInfo team2, Logger logger){
        matchTime=0;
        team1.setGoals(0);
        team2.setGoals(0);
        logger.info(": game between " + team1.getName() + " and " + team2.getName() + " has started");
        inProgress = true;
    }

    public void End(TeamInfo team1, TeamInfo team2, Logger logger, String winer){
        logger.info(": game between " + team1.getName() + " and " + team2.getName() + " has ended, the winner of the match:" + winer);
        inProgress = false;
    }

    public void Faul(TeamInfo team, Logger logger){
        if (!inProgress){ return; }
        logger.info(team.getName() + " has made a faul");
    }

    public void SwitchPlayer(TeamInfo team, Logger logger){
        if (!inProgress){ return; }
        logger.info(team.getName() + " switched player");
    }
    public String checkTournamentWin(List<TeamInfo> teams){
        int maxpoints = 0;
        String bestteam = null;
        for (TeamInfo team : teams) {
            if (team.getPoints() > maxpoints){
                bestteam = team.getName();
                maxpoints = team.getPoints();
            }
        }
        return bestteam;
    }

    public int getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(int matchTime) {
        this.matchTime = matchTime;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}

