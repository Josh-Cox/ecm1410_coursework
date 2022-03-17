package cycling;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Stage {
    
    //static attributes
    public static ArrayList<Stage> stageList = new ArrayList<>();

    //instance attributes
    private int stageID;
    private String stageName;
    private String stageDesc;
    private double stageLength;
    private LocalDateTime stageTime;
    private StageType stageType;
    private int raceID; 

    //method: get stageID
    public int getStageID() {
        return this.stageID;
    }

    // meathod: get race ID
    public int getRaceID(){
        return this.raceID;
    }

    //method: get stageName
    public String getStageName() {
        return this.stageName;
    }

    //method: get stageLength
    public double getStageLength() {
        return this.stageLength;
    }

    //contructors 
    public Stage() {

    }

    public Stage(int raceID, String stageName, String stageDesc, double stageLength, LocalDateTime stageTime, StageType stageType) {
        this.stageName = stageName;
        this.stageDesc = stageDesc;
        this.stageLength = stageLength;
        this.stageTime = stageTime;
        this.stageType = stageType;
        this.raceID= raceID;

        if (stageList.isEmpty()){
            this.stageID = 2000;
        }
        else{
            // Set ID 1 more than last stage
            this.stageID = stageList.get(stageList.size() - 1).getStageID() + 1;
        }
    }
}
