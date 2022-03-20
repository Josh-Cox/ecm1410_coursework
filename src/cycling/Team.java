package cycling;
import java.util.ArrayList;

public class Team {
    //instance attributes
    private String teamName;
    private String teamDesc;
    private int teamID;

    //static attributes
    public static ArrayList<Team> teamList = new ArrayList<>();

    //method: get team ID
    public int getTeamID() {
        return this.teamID;
    }

    //method: get team name
    public String getTeamName() {
        return this.teamName;
    }

    //method: get team desc
    public String getTeamDesc() {
        return this.teamDesc;
    }

    //contructors
    public Team() {
        this.teamName = "Null";
        this.teamDesc = "Null";
        this.teamID = 0;
    }

    public Team(String teamName, String teamDesc) {
        this.teamName = teamName;
        this.teamDesc = teamDesc;

        if (teamList.isEmpty()){
            this.teamID = 2000;
        }
        else{
            //set ID 1 more than last team
            this.teamID = teamList.get(teamList.size() - 1).getTeamID() + 1;
        }
    }
}
