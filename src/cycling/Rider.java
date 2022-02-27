
public class Rider {
    
    // Instance Attributes
    private int riderID;
    private int teamID;
    private String riderName;
    private int yearOfBirth;

    // method: get rider ID
    public int getRiderID() {
        return riderID;
    }

    // Contructor
    public Rider() {
        teamID = 0;
        riderName = "Null";
        yearOfBirth = 0;
        riderID = 0;
    }
    public Rider(int teamID, int yearOfBirth, String riderName) {

        this.teamID = teamID;
        this.riderName = riderName;
        this.yearOfBirth = yearOfBirth;
        this.riderID = 1;
    }


}
