import java.util.*;
import java.util.logging.Logger;

public class Tournament {
    private final List<TeamInfo> registeredTeams = new ArrayList<>();
    private final State states = new State();

    private String input;

    LinkedHashMap<TeamInfo, TeamInfo> draws = new LinkedHashMap<>();

    public LinkedHashMap<TeamInfo, TeamInfo> getDraws() {
        return draws;
    }

    private Logger logger;


    public void registerTeam(TeamInfo teamInfo) {
        registeredTeams.add(teamInfo);
    }

    public String getTournamentWinner(){
        return states.checkTournamentWin(registeredTeams);
    }

    public void drawTournament(){
        if (registeredTeams.isEmpty() | registeredTeams.size() < 2){
            throw new IllegalStateException("Not enought team, add more");
        }
        //this doesnt work as it should, netusim jak udelat kazdy s kazdym hezku bez pouziti mega moc ifu
        for (TeamInfo team: registeredTeams) {
            for (TeamInfo team2: registeredTeams){
                if ((draws.containsKey(team2) && draws.containsValue(team)) || (draws.containsKey(team) && draws.containsValue(team2)) | (team == team2)){
                    continue;
                }
                draws.put(team, team2);
            }
        }
    }

    public void setLogger(String nameoflogger){
        logger = Logger.getLogger(nameoflogger);
    }

    public void playGame(TeamInfo team1, TeamInfo team2) {
        states.Start(team1, team2, logger);
        System.out.println("write a name of team who should score");
        //thread for user input so we can cycle throu match
        StressThread thread1 = new StressThread();
        Random random = new Random();
        thread1.start();
        // check who scored goal
        while (states.getMatchTime()<91) {
            if (states.isInProgress() && input!=null) {
                if (input.equals(team1.getName())) {
                    states.Goal(team1, logger);
                } else if (input.equals(team2.getName())) {
                    states.Goal(team2, logger);
                } else System.out.println("wrong team name");
                input = null;
            }
            //fauls and switches
            var rand = random.nextInt(100);
            if (rand % 11 == 0){
                states.Faul(team1, logger);
            } else if (rand % 12 == 0) {
                states.Faul(team2, logger);
            } else if (rand % 50 == 0) {
                states.SwitchPlayer(team1, logger);
            } else if (rand % 40 == 0) {
                states.SwitchPlayer(team2, logger);
            } // for autonomous playing even with goals can be commented out
            else if (rand % 30 == 0) {
                states.Goal(team1, logger);
            }
            else if (rand % 31 == 0) {
                states.Goal(team2, logger);
            }

            // plus minute of match
            int matchtime = states.getMatchTime();
            System.out.println("minuta zapasu " + matchtime);
            states.setMatchTime(matchtime+1);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //kills thread waiting for userinput
        thread1.interrupt();

        //check winner
        int winner = states.checkMatchWin(team1.getGoals(), team2.getGoals());
        String winerName = null;
        if (winner == 1) {
            int points = team1.getPoints();
            team1.setPoints(points + 3);
            winerName = team1.getName();
        } else if (winner == 2) {
            int points = team2.getPoints();
            team2.setPoints(points + 3);
            winerName = team2.getName();
        } else {
            int points = team1.getPoints();
            int points2 = team2.getPoints();
            team1.setPoints(points + 1);
            team2.setPoints(points2 + 1);
            winerName ="remiza";
        }
        //end match logs winner
        states.End(team1, team2, logger, winerName);
    }
    class StressThread extends Thread {
        @Override
        public void run() {
            Scanner inputReader = new Scanner(System.in);
            while (true) {
                if (inputReader.hasNext()) {
                    input = inputReader.next();
                }
            }
        }


    }
}



