package cycling;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Stage {
    
    //instance attributes
    private int stageID;
    private String stageName;
    private String stageDesc;
    private double stageLength;
    private LocalDateTime startTime;
    private StageType stageType;
    private int raceID;
    private String stageState;

    
    /** 
     * method: get stageID
     * @return int
     */
    public int getStageID() {
        return this.stageID;
    }

    
    /** 
     * method: get race ID
     * @return int
     */
    public int getRaceID(){
        return this.raceID;
    }

    
    /** 
     * method: get stageName
     * @return String
     */
    public String getStageName() {
        return this.stageName;
    }

    
    /** 
     * method: get stageLength
     * @return double
     */
    public double getStageLength() {
        return this.stageLength;
    }

    
    /** 
     * method: get stageType
     * @return StageType
     */
    public StageType getStageType() {
        return this.stageType;
    }

    
    /** 
     * method: get stageState
     * @return String
     */
    public String getStageState() {
        return this.stageState;
    }

    
    /** 
     * method: set stageState
     * @param state
     */
    public void setStageState(String state) {
        this.stageState = state;
    }

    //contructors 
    public Stage() {

    }

    public Stage(int raceID, String stageName, String stageDesc, double stageLength, LocalDateTime startTime, StageType stageType, ArrayList<Stage> stageList)  {
        this.stageName = stageName;
        this.stageDesc = stageDesc;
        this.stageLength = stageLength;
        this.startTime = startTime;
        this.stageType = stageType;
        this.raceID= raceID;

        if (stageList.isEmpty()){
            this.stageID = 2000;
        }
        else{
            //set ID 1 more than last stage
            this.stageID = stageList.get(stageList.size() - 1).getStageID() + 1;
        }
    }
}
