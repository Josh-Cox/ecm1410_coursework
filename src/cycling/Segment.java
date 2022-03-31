package cycling;
import java.util.ArrayList;

public class Segment {
    
    //instance attrbutes
    private int segmentID;
    private int stageID;
    private double location;
    private SegmentType type;
    private double averageGradient;
    private double length;

    
    /** 
     * method: get segment id 
     * @return int
     */
    public int getSegmentID() {
        return this.segmentID;
    }

    
    /** 
     * method: get stage id
     * @return int
     */
    public int getStageID() {
        return this.stageID;
    }

    
    /** 
     * method: get segment type
     * @return SegmentType
     */
    public SegmentType getSegmentType() {
        return this.type;
    }

    
    /** 
     * method: get segment location
     * @return double
     */
    public double getSegmentLocation() {
        return this.location;
    }

    //constructor 
    public Segment(int stageID, double location, ArrayList<Segment> segmentList) {
        this.stageID = stageID;
        this.location = location;
        this.type = SegmentType.SPRINT;

        if (segmentList.isEmpty()){
            this.segmentID = 2000;
        }
        else{
            //set ID 1 more than last segment
            this.segmentID = segmentList.get(segmentList.size() - 1).getSegmentID() + 1;
        }
    }
    
    public Segment(int stageID, double location, SegmentType type, double averageGradient, double length, ArrayList<Segment> segmentList   ) {
        
        this.stageID = stageID;
        this.location = location;
        this.type = type;
        this.averageGradient = averageGradient;
        this.length = length;

        if (segmentList.isEmpty()){
            this.segmentID = 2000;
        }
        else{
            //set ID 1 more than last segment
            this.segmentID = segmentList.get(segmentList.size() - 1).getSegmentID() + 1;
        }
    }
}
