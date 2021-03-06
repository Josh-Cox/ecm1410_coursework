package cycling;
import java.util.ArrayList;

public class Team {
    //instance attributes
    private String teamName;
    private String teamDesc;
    private int teamID;


    
    /** 
     * method: get team ID
     * @return int
     */
    public int getTeamID() {
        return this.teamID;
    }

    
    /** 
     * method: get team name
     * @return String
     */
    public String getTeamName() {
        return this.teamName;
    }

    
    /** 
     * method: get team desc
     * @return String
     */
    public String getTeamDesc() {
        return this.teamDesc;
    }

    //contructors
    public Team() {
        this.teamName = "Null";
        this.teamDesc = "Null";
        this.teamID = 0;
    }

    public Team(String teamName, String teamDesc, ArrayList<Team> teamList) {
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
