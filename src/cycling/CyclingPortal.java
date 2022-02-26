//package cycling;

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

public class CyclingPortal {

	/**
	 * Creates a rider
	 * @param riderName
	 * @param teamID
	 * @param yearOfBirth
	 * @return riderID
	 */

	Rider riderObjects [] = new Rider[5];

	public int createRider(String riderName, int teamID, int yearOfBirth) {

		Rider tempRider = new Rider(teamID, yearOfBirth, riderName);
		riderObjects[0] = tempRider;
		return tempRider.getRiderID();
	}

	
 }