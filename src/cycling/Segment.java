package cycling;
import java.util.ArrayList;

public class Segment {
    
    //static attributes
    public static ArrayList<Segment> segmentList = new ArrayList<>();

    //instance attrbutes
    private int segmentID;
    private int stageID;
    private double location;
    private SegmentType type;
    private double averageGradient;
    private double length;

    //method: get segment id 
    public int getSegmentID() {
        return this.segmentID;
    }

    //constructor 
    public Segment() {

    }
    
    public Segment(int stageID, double location, SegmentType type, double averageGradient, double length) {
        
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
