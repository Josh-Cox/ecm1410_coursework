package cycling;
import java.util.ArrayList;

public class Team {
    // Instance Attributes
    private String teamName;
    private String teamDesc;
    private int teamID;

    // Static Attributes
    public static ArrayList<Team> teamList = new ArrayList<>();

    // method: get teamID
    public int getTeamID() {
        return this.teamID;
    }

    // method: get teamName
    public String getTeamName() {
        return this.teamName;
    }

    // method: get teamDesc
    public String getTeamDesc() {
        return this.teamDesc;
    }

    // Contructors
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
            // Set ID 1 more than last team
            this.teamID = teamList.get(teamList.size() - 1).getTeamID() + 1;
        }
    }
}
