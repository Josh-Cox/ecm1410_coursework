
package cycling;
import java.util.ArrayList;
public class TestingDelete {
    
    public static void main(String[] args){
        createTeamTest();
        

    }
    
    public static void createRiderTest() {
        
        //Test create rider
    
        CyclingPortal.createRider(1, "Dora", 1998);

        System.out.println(riderList.get(0).getRiderID());
        System.out.println(riderList.get(1).getRiderID());
    }

    public static void createTeamTest() {
        ArrayList<Team> teamList = new ArrayList<>();

        teamList.add(new Team("testName1", "testDesc1"));
        teamList.add(new Team("testName2", "testDesc2"));

        System.out.println(teamList.get(0).getTeamID());
        System.out.println(teamList.get(1).getTeamID());
    }
}
