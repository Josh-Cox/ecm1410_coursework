package cycling;
import java.util.ArrayList;

public class Race {
    // static attributes 
    public static ArrayList<Race> raceList = new ArrayList<>();
    
    // instance attributes
    private int raceID;
    private String raceName;
    private String raceDesc;
    private int NumOfStages;
    private double totalLength; 
    private ArrayList<Stage> stageList = new ArrayList<>();

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
        return this.stageList;
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
