package cycling;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Stage {
    
    //static attributes
    public static ArrayList<Integer> stageIDList = new ArrayList<>();

    //instance attributes
    private int stageID;
    private String stageName;
    private String stageDesc;
    private double stageLength;
    private LocalDateTime stageTime;
    private StageType stageType;

    //contructors 
    public Stage() {

    }

    public Stage(String stageName, String stageDesc, double stageLength, LocalDateTime stageTime, StageType stageType) {
        this.stageName = stageName;
        this.stageDesc = stageDesc;
        this.stageLength = stageLength;
        this.stageTime = stageTime;
        this.stageType = stageType;

        if (stageIDList.isEmpty()){
            this.stageID = 2000;
        }
        else{
            // Set ID 1 more than last team
            this.stageID = stageIDList.get(stageIDList.size() - 1) + 1;
        }
    }
}
