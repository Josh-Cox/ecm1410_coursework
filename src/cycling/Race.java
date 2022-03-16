package cycling;
import java.util.ArrayList;

public class Race {
    // static attributes 
    public static ArrayList<Race> raceList = new ArrayList<>();
    
    // instance attributes
    private int raceID;
    private String raceName;
    private String raceDesc;
    private int numOfStages = 0;
    private double totalLength = 0;
    private ArrayList<Stage> raceStageList = new ArrayList<>();

    // method: toString
    public String toString() {
        return ("Race ID: " + raceID + "\nName: " + raceName + "\nDescription: " + raceDesc + 
        "\nNumber of Stages: " + numOfStages + "\nTotal Length: " + totalLength);
    }

    // method: get race ID
    public int getRaceID(){
        return this.raceID;
    }

    // method: get race name
    public String getRaceName(){
        return this.raceName;
    }

    // method: get race description
    public String getRaceDesc(){
        return this.raceDesc;
    }

    // method: get stage list
    public ArrayList<Stage> getRaceStage() {
        return this.raceStageList;
    }

    // method: get total length
    public double getTotalLength() {
        return this.totalLength;
    }

    // method: get number of stages
    public int getNumOfStages() {
        return this.numOfStages;
    }

    // method: get number of stages
    public void setNumOfStages() {
        numOfStages = raceStageList.size();
    }

    // method: get total length
    public void setTotalLength() {
        for (int i = 0; i < raceStageList.size(); i++) {
            totalLength += raceStageList.get(i).getStageLength();
        }
    }


    // constructors
    
    public Race() {
         
    } 
    
    public Race(String raceName, String raceDesc) {
        this.raceName = raceName;
        this.raceDesc = raceDesc;

        if (raceList.isEmpty()){
            this.raceID = 2000;
        }
        else{
            // Set ID 1 more than last team
            this.raceID = raceList.get(raceList.size() - 1).getRaceID() + 1;
        }
    }
}
