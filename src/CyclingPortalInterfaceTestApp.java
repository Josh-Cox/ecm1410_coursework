

import java.time.LocalDate;
import java.time.LocalDateTime;

import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.IDNotRecognisedException;
import cycling.IllegalNameException;
import cycling.InvalidLengthException;
import cycling.InvalidLocationException;
import cycling.InvalidNameException;
import cycling.InvalidStageStateException;
import cycling.InvalidStageTypeException;
import cycling.NameNotRecognisedException;
import cycling.SegmentType;
import cycling.StageType;


/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the CyclingPortalInterface interface -- note you
 * will want to increase these checks, and run it on your CyclingPortal class
 * (not the BadCyclingPortal class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class CyclingPortalInterfaceTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 * 
	 */

	
	public static void main(String[] args) throws IllegalNameException, InvalidNameException {
		System.out.println("The system compiled and started the execution...");

		CyclingPortalInterface portal = new CyclingPortal();
//		CyclingPortalInterface portal = new CyclingPortal();

		//create race
		assert (portal.createRace("testRace", "testDesc") == 2000);
		
		//add stage to race
		try {
			assert (portal.addStageToRace(2000, "testStage", "testDesc", 5.0, LocalDateTime.of(2022, 3, 29, 10, 0, 0), StageType.FLAT)) == 2000;
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		} catch (InvalidLengthException e1) {
			e1.printStackTrace();
		}
		
		//add sprint to stage
		try {
			assert (portal.addIntermediateSprintToStage(2000, 5.0) == 2000);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		} catch (InvalidLocationException e1) {
			e1.printStackTrace();
		} catch (InvalidStageStateException e1) {
			e1.printStackTrace();
		} catch (InvalidStageTypeException e1) {
			e1.printStackTrace();
		}

		//add catergorized climb to stage
		try {
			assert (portal.addCategorizedClimbToStage(2000, 5.0, SegmentType.C4, 5.0, 5.0) == 2001);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		} catch (InvalidLocationException e1) {
			e1.printStackTrace();
		} catch (InvalidStageStateException e1) {
			e1.printStackTrace();
		} catch (InvalidStageTypeException e1) {
			e1.printStackTrace();
		}

		//create team
		assert (portal.createTeam("testTeam", "testDesc") == 2000);

		//create rider
		try {
			assert (portal.createRider(2000, "testRider", 2022) == 2000);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		//get number of stages
		try {
			assert (portal.getNumberOfStages(2000) == 1);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		//get race stages
		try {
			assert (portal.getRaceStages(2000).length == 1);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		//get stage length
		try {
			assert (portal.getStageLength(2000) == 5.0);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		
		//get stage segments
		try {
			assert (portal.getStageSegments(2000).length == 2);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		
		//get teams
		assert (portal.getTeams().length == 1);
		
		//get team riders
		try {
			assert (portal.getTeamRiders(2000).length == 1);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		
		//view race details
		try {
			System.out.println(portal.viewRaceDetails(2000));
		} catch (IDNotRecognisedException e) {
			e.printStackTrace();
		}
		
		//get race IDs
		assert (portal.getRaceIds()[0] == 2000);

		//remove segment
		try {
			portal.removeSegment(2000);
			portal.removeSegment(2001);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		} catch (InvalidStageStateException e1) {
			e1.printStackTrace();
		}
		try {
			assert (portal.getStageSegments(2000).length == 0);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		
		//remove stage
		try {
			portal.removeStageById(2000);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		try {
			assert (portal.getRaceStages(2000).length == 0);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		//remove rider
		try {
			portal.removeRider(2000);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		try {
			assert (portal.getTeamRiders(2000).length == 0);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}

		//remove team
		try {
			portal.removeTeam(2000);
		} catch (IDNotRecognisedException e1) {
			e1.printStackTrace();
		}
		assert (portal.getTeams().length == 0);


		//remove race by ID
		try {
			portal.removeRaceById(2000);
			assert (portal.getRaceIds().length == 0);
		} catch (IDNotRecognisedException e) {
			e.printStackTrace();
		}
		assert (portal.getRaceIds().length == 0);

		//remove race by name
		portal.createRace("testRemove", "testDesc");

		try {
			portal.removeRaceByName("testRemove");
		} catch (NameNotRecognisedException e) {
			e.printStackTrace();
		}
		assert (portal.getRaceIds().length == 0);

	}

}
