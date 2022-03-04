package cycling;

import java.util.ArrayList;

public class Rider {
    
    // Instance Attributes
    private int riderID;
    private int teamID;
    private String riderName;
    private int yearOfBirth;

    // Static Attributes
    public static ArrayList<Rider> riderList = new ArrayList<>();

    // method: get rider ID
    public int getRiderID() {
        return riderID;
    }
    // method: get team ID
    public int getTeamID() {
        return teamID;
    }

    // method: get rider name 
    public String getRiderName() {
        return riderName;
    }

    // method: get year of birth 
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // method: sets rider ID
    public void setRiderID(int riderID, ArrayList<Rider> riderList){
        //REPLACE WITH BINARY SEARCH
        for(int i = 0;i < riderList.size(); i++) {
            if (riderList.get(i).getRiderID() == riderID) {
                System.out.println("ERROR: ID already exists");
            }
            else {
                this.riderID= riderID;
            }
        }
    }

    // method: sets rider name 
    public void setRiderName(String riderName){
        this.riderName= riderName;
    }

    // method: sets team ID
    public void setTeamID(int teamID){
        this.teamID= teamID;
    }

    // method: sets year of birth
    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth= yearOfBirth; 
    }

    // Contructor
    public Rider() {
        teamID = 0;
        riderName = "Null";
        yearOfBirth = 0;
        riderID = 0;
    }
    public Rider(int teamID, int yearOfBirth, String riderName, ArrayList<Rider> riderList) {

        // Set instance attributes
        this.teamID = teamID;
        this.riderName = riderName;
        this.yearOfBirth = yearOfBirth;

        if (riderList.isEmpty()){
            this.riderID = 2000;
        }
        else{
            // Set ID 1 more than last rider
            this.riderID = riderList.get(riderList.size() - 1).getRiderID() + 1;
        }
            
    }


}
