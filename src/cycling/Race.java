package cycling;
import java.util.ArrayList;

public class Race {
    
    //instance attributes
    private int raceID;
    private String raceName;
    private String raceDesc;
    private int numOfStages = 0;
    private double totalLength = 0;

    //method: toString
    public String toString() {
        return ("Race ID: " + raceID + "\nName: " + raceName + "\nDescription: " + raceDesc + 
        "\nNumber of Stages: " + numOfStages + "\nTotal Length: " + totalLength);
    }

    //method: get race ID
    public int getRaceID(){
        return this.raceID;
    }

    //method: get race name
    public String getRaceName(){
        return this.raceName;
    }

    //method: get race description
    public String getRaceDesc(){
        return this.raceDesc;
    }

    //method: get total length
    public double getTotalLength() {
        return this.totalLength;
    }

    //method: get number of stages
    public int getNumOfStages() {
        return this.numOfStages;
    }

    //method: set number of stages
    public void setNumOfStages(ArrayList<Stage> stageList) {
        numOfStages = 0;
        for (int i = 0; i < stageList.size(); i++) {
            if (stageList.get(i).getRaceID() == this.raceID) {
                this.numOfStages ++;
            }
        }
    }

    //method: set total length
    public void setTotalLength(ArrayList<Stage> stageList) {
        totalLength = 0;
        for (int i = 0; i < stageList.size(); i++) {
            if (stageList.get(i).getRaceID() == this.raceID) {
                this.totalLength += stageList.get(i).getStageLength();
            }
        }
    }


    //constructor
    public Race(String raceName, String raceDesc, ArrayList<Race> raceList)  {
        this.raceName = raceName;
        this.raceDesc = raceDesc;

        if (raceList.isEmpty()){
            this.raceID = 2000;
        }
        else{
            //set ID 1 more than last race
            this.raceID = raceList.get(raceList.size() - 1).getRaceID() + 1;
        }
    }
}
