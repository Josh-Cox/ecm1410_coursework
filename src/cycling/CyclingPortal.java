package cycling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

	// method: create a rider
	public int createRider(String riderName, int teamID, int yearOfBirth) {
		Rider tempRider = new Rider(teamID, yearOfBirth, riderName);

		return tempRider.getRiderID();
	}
 }