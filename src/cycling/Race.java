package cycling;
import java.util.ArrayList;

public class Race {
    
    //instance attributes
    private int raceID;
    private String raceName;
    private String raceDesc;
    private int numOfStages = 0;
    private double totalLength = 0;

    
    /** 
     * toString
     * @return String
     */
    public String toString() {
        return ("Race ID: " + raceID + "\nName: " + raceName + "\nDescription: " + raceDesc + 
        "\nNumber of Stages: " + numOfStages + "\nTotal Length: " + totalLength);
    }

    
    /** 
     * get race ID
     * @return int
     */
    public int getRaceID(){
        return this.raceID;
    }

    
    /** 
     * get race name
     * @return String
     */
    public String getRaceName(){
        return this.raceName;
    }

    
    /** 
     * get race description
     * @return String
     */
    public String getRaceDesc(){
        return this.raceDesc;
    }

    
    /** 
     * get total length
     * @return double
     */
    public double getTotalLength() {
        return this.totalLength;
    }

    
    /** 
     * get number of stages
     * @return int
     */
    public int getNumOfStages() {
        return this.numOfStages;
    }

    
    /** ,
     * set number of stages
     * @param stageList
     */
    public void setNumOfStages(ArrayList<Stage> stageList) {
        numOfStages = 0;
        for (int i = 0; i < stageList.size(); i++) {
            if (stageList.get(i).getRaceID() == this.raceID) {
                this.numOfStages ++;
            }
        }
    }

    
    /** 
     * set total length
     * @param stageList
     */
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
