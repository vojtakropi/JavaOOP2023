import java.util.Random;

public class TeamInfo {
    private final String name;
    private int points;

    private int goals;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }


    public TeamInfo(String teamName){
        this.name = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
