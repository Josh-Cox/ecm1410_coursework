package cycling;

import java.time.LocalTime;
import java.util.ArrayList;

public class Result {

    //instance attributes
    private int resultID;
    private int stageID;
    private int riderID;
    private LocalTime checkpoints;

    //method: get resultID
    public int getResultID() {
        return this.resultID;
    }

    //method: get riderID
    public int getRiderID() {
        return this.riderID;
    }

    //method: get stageID
    public int getStageID() {
        return this.stageID;
    }

    //constructor 
    public Result(int stageID, int riderID, LocalTime checkpoints, ArrayList<Result> resultList) {
        this.stageID = stageID;
        this.riderID = riderID;
        this.checkpoints = checkpoints;

        if (resultList.isEmpty()){
            this.resultID = 2000;
        }
        else{
            //set ID 1 more than last team
            this.resultID = resultList.get(resultList.size() - 1).getResultID() + 1;
        }

    }


    
    

}
