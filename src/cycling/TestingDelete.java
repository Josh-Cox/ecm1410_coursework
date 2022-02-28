
package cycling;
import java.util.ArrayList;
public class TestingDelete {
    
    public static void main(String[] args){
    
        
    }
    
    public static void createRiderTest() {
        
        //Test create rider
        ArrayList<Rider> riderList = new ArrayList<>();
    
        riderList.add(new Rider(123, 1999, "dora", riderList));
        riderList.add(new Rider(456, 2003, "josh", riderList));

        System.out.println(riderList.get(0).getRiderID());
        System.out.println(riderList.get(1).getRiderID());
    }
}
