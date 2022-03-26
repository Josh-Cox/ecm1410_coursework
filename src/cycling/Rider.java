package cycling;

import java.util.ArrayList;

public class Rider implements java.io.Serializable{
    
    //instance attributes
    private int riderID;
    private int teamID;
    private String riderName;
    private int yearOfBirth;



    //method: get rider ID
    public int getRiderID() {
        return riderID;
    }
    
    //method: get team ID
    public int getTeamID() {
        return teamID;
    }

    //method: get rider name 
    public String getRiderName() {
        return riderName;
    }

    //method: get year of birth 
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    //contructor
    public Rider() {
        teamID = 0;
        riderName = "Null";
        yearOfBirth = 0;
        riderID = 0;
    }
    public Rider(int teamID, int yearOfBirth, String riderName, ArrayList<Rider> riderList) {

        //set instance attributes
        this.teamID = teamID;
        this.riderName = riderName;
        this.yearOfBirth = yearOfBirth;

        if (riderList.isEmpty()){
            this.riderID = 2000;
        }
        else{
            //set ID 1 more than last rider
            this.riderID = riderList.get(riderList.size() - 1).getRiderID() + 1;
        }
            
    }


}
