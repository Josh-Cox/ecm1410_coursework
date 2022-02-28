
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.LocalTime;

/**
 * BadCyclingPortal is a minimally compiling, but non-functioning implementor
 * of the CyclingPortalInterface interface.
 * 
 * @author Josh Cox
 * @author Dora Napier
 * @version 1.0
 *
 */

public class test implements CyclingPortalInterface {

	/**
	 * Creates a rider
	 * @param riderName
	 * @param teamID
	 * @param yearOfBirth
	 * @return riderID
	 */

	//Rider riderObjects [] = new Rider[5];

	public int createRider(String riderName, int teamID, int yearOfBirth) {

		Rider riderObjects[];
		riderObjects[1] = new Rider(teamID, yearOfBirth, riderName);
		System.out.print(riderObjects[1]);
		return tempRider.getRiderID();
	}

	
 } //javac -sourcepath src src/CyclingPortalInterfaceTestApp.java