
package cycling;
import java.util.ArrayList;
public class TestingDelete {
    
    public static void main(String[] args){
        createTeamTest();
        

    }

    public static void createTeamTest() {
        ArrayList<Team> teamList = new ArrayList<>();

        teamList.add(new Team("testName1", "testDesc1"));
        teamList.add(new Team("testName2", "testDesc2"));

        System.out.println(teamList.get(0).getTeamID());
        System.out.println(teamList.get(1).getTeamID());
    }
}
