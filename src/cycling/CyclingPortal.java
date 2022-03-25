package cycling;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;


/**
 * CyclingPortal is an implementor
 * of the CyclingPortalInterface interface.
 * 
 * @author 710030198
 * @author 710045992
 * @version 1.0
 *
 */
public class CyclingPortal implements CyclingPortalInterface {
	
	/**
	 * Checks the id of a race exists 
	 * @param raceID
	 * @return validID
	 */

	public boolean checkRaceID(int raceID) {
		
		boolean validID = false;

		//for every race
		for (int i = 0; i < Race.raceList.size(); i++) {
			//if race exists
			if (Race.raceList.get(i).getRaceID() == raceID) {
				//race is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Checks the id of a rider exists 
	 * @param riderID
	 * @return validID
	 */

	public boolean checkRiderID(int riderID) {

		boolean validID = false;

		//for every rider
		for (int i = 0; i < Rider.riderList.size(); i++) {
			//if rider exists
			if (Rider.riderList.get(i).getRiderID() == riderID) {
				//rider is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Checks the id of a team exists 
	 * @param teamID
	 * @return validID
	 */

	public boolean checkTeamID(int teamID) {

		boolean validID = false;

		//for every team
		for (int i = 0; i < Team.teamList.size(); i++) {
			//if team exists
			if (Team.teamList.get(i).getTeamID() == teamID) {
				//team is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Checks the id of a stage exists 
	 * @param stageID
	 * @return validID
	 */

	public boolean checkStageID(int stageID) {

		boolean validID = false;

		//for every stage
		for (int i = 0; i < Stage.stageList.size(); i++) {
			//if stage exists
			if (Stage.stageList.get(i).getStageID() == stageID) {
				//stage is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Checks the id of a segment exists 
	 * @param segmentID
	 * @return validID
	 */

	public boolean checkSegmentID(int segmentID) {

		boolean validID = false;

		//for every segement
		for (int i = 0; i < Segment.segmentList.size(); i++) {
			//if segment exists
			if (Segment.segmentList.get(i).getSegmentID() == segmentID) {
				//segment is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Gets an array of all race id's
	 * @return raceIDlist 
	 */

	@Override
	public int[] getRaceIds() {
		
		//create array of correct size
		int [] raceIDList = new int[Race.raceList.size()];
		if (Race.raceList.size() > 0 ) {
			for(int i = 0;i < Race.raceList.size(); i++) {
				//fill array with race IDs
				raceIDList[i]= Race.raceList.get(i).getRaceID();
			}
			//check first ID is correct
			assert raceIDList[0]== Race.raceList.get(0).getRaceID();
		}
		
		return raceIDList;
	}

	/**
	 * Creates a new race object
	 * @param name
	 * @param description
	 * @return validID
	 */

	@Override
	public int createRace(String name, String description) throws IllegalNameException, InvalidNameException {

		boolean legalRaceName = true;
		boolean validRaceName = true;

		//for every race
		for(int i = 0;i < Race.raceList.size(); i++) {
			//if race exists
			if (Race.raceList.get(i).getRaceName() == name) {
				//illegal race name
				legalRaceName = false;
			}
		}
		//if name has invalid attributes
		if((name == null) || (name == "") || (name.length() > 30) || (name.contains(" "))) {
			//name is invalid
			validRaceName = false;
		}

		//if name is invalid
		if(validRaceName == false) {
			//throw exception
			throw new InvalidNameException();
		}
		//if name is illegal
		else if(legalRaceName == false) {
			//throw exception
			throw new IllegalNameException();
		}
		else {
			//add new race to raceList
			Race.raceList.add(new Race(name, description));
			//assert race was added
			assert Race.raceList.get(Race.raceList.size() - 1).getRaceName() == name;
			//return race ID
			return Race.raceList.get(Race.raceList.size() - 1).getRaceID();
		}
	
	}

	/**
	 * Gets details from a race
	 * @param raceId
	 * @return Formatted ArrayList Object raceList
	 */

	@Override
	public String viewRaceDetails(int raceId) throws IDNotRecognisedException {

		//if race doesn't exist
		if (checkRaceID(raceId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {

			int correctRace = 0;
			//for all races
			for (int i = 0; i < Race.raceList.size(); i++) {
				//if race exists
				if (Race.raceList.get(i).getRaceID() == raceId) {
					//set correctRace
					correctRace = i;
					break;
				}
			}
			//return formatted race details
			return Race.raceList.get(correctRace).toString();
			
		}
		
	}

	/**
	 * Removes a race
	 * @param raceId
	 * @return validID
	 */

	@Override
	public void removeRaceById(int raceId) throws IDNotRecognisedException {



		//if race doesn't exist
		if (checkRaceID(raceId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {
			//for every race
			for (int i = 0; i < Race.raceList.size(); i++) {
				//if race exists
				if (Race.raceList.get(i).getRaceID() == raceId) {
					//remove race
					Race.raceList.remove(i);
				}
			}
		}

	}

	/**
	 * Gets number of stages of a race
	 * @param raceId
	 * @return numStages
	 */

	@Override
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
		
		int numStages = 0;

		//if race doesn't exist
		if (checkRaceID(raceId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {

			//for every race
			for (int i = 0; i < Race.raceList.size(); i++) {
				//if race exists
				if (Race.raceList.get(i).getRaceID() == raceId) {
					//set numStages to number of stages
					numStages = Race.raceList.get(i).getNumOfStages();
				}
			}
		}
		return numStages;
	}

	/**
	 * Creates a stage and adds it to a race
	 * @param raceId
	 * @param stageName
	 * @param description
	 * @param length
	 * @param startTime
	 * @param type
	 * @return ID of created stage
	 */

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime,
			StageType type)
			throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		
		boolean legalStageName = true, validStageName = true, validStageLength = true;
		
		//for every stage
		for(int i = 0;i < Stage.stageList.size(); i++) {
			//if stage exists
			if (Stage.stageList.get(i).getStageName() == stageName) {
				//illegal stage name
				legalStageName = false;
			}
		}

		//if name has invalid attributes
		if((stageName == null) || (stageName == "") || (stageName.length() > 30) || (stageName.contains(" "))) {
			//invalid name
			validStageName = false;
		}

		//if length < 5
		if (length < 5) {
			//invalid length
			validStageLength = false;
		}

		//if race doesn't exists
		if (checkRaceID(raceId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		//if name is illegal
		else if (legalStageName == false) {
			//throw exception
			throw new IllegalNameException();
		}
		//if name is invalid
		else if (validStageName == false) {
			//throw exception
			throw new InvalidNameException();
		}
		//if length is invalid
		else if (validStageLength == false) {
			//throw exception
			throw new InvalidLengthException();
		}	
		else {
			int correctRace = 0;
			//for every race
			for (int i = 0; i < Race.raceList.size(); i++) {
				//if race exists
				if (Race.raceList.get(i).getRaceID() == raceId) {
					//set correctRace
					correctRace = i;
				}
			}
			//add new stage to stageList and raceStageList
			Stage.stageList.add(new Stage(raceId, stageName, description, length, startTime, type));
			Race.raceList.get(correctRace).getRaceStage().add(
				Stage.stageList.get(Stage.stageList.size() - 1));
		}

		//return stageID
		return Stage.stageList.get(Stage.stageList.size() - 1).getStageID();
	}

	/**
	 * Gets the stage IDs of a race
	 * @param raceId
	 * @return raceStageIDList
	 */

	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {

		int counter = 0;
		int arraySize = 0;
		int [] raceStageIDList = new int[arraySize];

		//if race doesn't exist
		if (checkRaceID(raceId) == false){
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {

			//for every stage
			for (int i = 0; i < Stage.stageList.size(); i++) {
				//if stage exists
				if (Stage.stageList.get(i).getRaceID() == raceId) {
					//incremenet arraySize
					arraySize ++;
				}
			}
	
			//if array contains values
			if (Stage.stageList.size() > 0 ) {
				//for every stage
				for(int i = 0;i < Stage.stageList.size(); i++) {
					//if stage exists
					if (Stage.stageList.get(i).getRaceID() == raceId) {
						//add stageID to raceStageIDList
						raceStageIDList[counter] = Stage.stageList.get(i).getStageID();
						counter ++;
					} 
				}
				
			}
		}
		
		return raceStageIDList;
	}

	/**
	 * Gets the length of a stage
	 * @param stageId
	 * @return stageLength
	 */

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		
		double stageLength = 0;

		//if stage doesn't exist
		if (checkStageID(stageId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {
			//for every stage
			for (int i = 0; i < Stage.stageList.size(); i++) {
				//if stage exists
				if (Stage.stageList.get(i).getStageID() == stageId) {
					//set stageLength to length of stage
					stageLength = Stage.stageList.get(i).getStageLength();
				}
			}
		}

		return stageLength;
	}

	/**
	 * Removes a stage
	 * @param stageId
	 */

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {

		//if stage doesn't exist
		if (checkStageID(stageId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}
		else {
			//for every stage
			for (int i = 0; i < Stage.stageList.size(); i++) {
				//if stage exists
				if (Stage.stageList.get(i).getStageID() == stageId) {
					//remove stage
					Stage.stageList.remove(i);
				}
			}
		}

	}


	@Override
	public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient,
			Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,
			InvalidStageTypeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addIntermediateSprintToStage(int stageId, double location) throws IDNotRecognisedException,
			InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeSegment(int segmentId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates a team
	 * @param name
	 * @param description
	 * @return ID of created team
	 */

	@Override
	public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
		
		boolean validTeamName = true, legalTeamName = true;

		//for every team
		for(int i = 0;i < Team.teamList.size(); i++) {
			//if team name exists
			if (Team.teamList.get(i).getTeamName() == name) {
				//illegal team name
				legalTeamName = false;
			}
			//if team name has invalid attributes
			else if((name == null) || (name == "") || (name.length() > 30) || (name.contains(" "))) {
				validTeamName = false;
			}
            else {
            }
        }

		if(validTeamName == false) {
			throw new InvalidNameException();
		}
		else if(legalTeamName == false) {
			throw new IllegalNameException();
		}
		else {
			Team.teamList.add(new Team(name, description));
			return Team.teamList.get(Team.teamList.size() - 1).getTeamID();
		}
		
	}

	/**
	 * Removes a team
	 * @param teamId
	 */

	@Override
	public void removeTeam(int teamId) throws IDNotRecognisedException {

		if (checkTeamID(teamId) == false) {
			throw new IDNotRecognisedException();
		}

		for (int i = 0; i < Team.teamList.size(); i++) {
			if (Team.teamList.get(i).getTeamID() == teamId) {

				Team.teamList.remove(i);
			}
		}
	}

	/**
	 * GetsIDs of all teams
	 * @return teamIDList
	 */

	@Override
	public int[] getTeams() {

		int [] teamIDList = new int[Team.teamList.size()];
		if (Team.teamList.size() > 0 ) {
			for(int i = 0;i < Team.teamList.size(); i++) {
				teamIDList[i]= Team.teamList.get(i).getTeamID();
			}
			assert teamIDList[0] == Team.teamList.get(0).getTeamID();
		}
		
		return teamIDList;
	}

	/**
	 * Get IDs of riders of a team
	 * @param teamId
	 * @return teamRiderIDList
	 */

	@Override
	public int[] getTeamRiders(int teamId) throws IDNotRecognisedException {

		if (checkTeamID(teamId) == false) {
			throw new IDNotRecognisedException();
		}

		int counter = 0;
		int arraySize = 0;

		for (int i = 0; i < Rider.riderList.size(); i++) {
			if (Rider.riderList.get(i).getTeamID() == teamId) {
				arraySize ++;
			}
		}

		int [] teamRiderIDList = new int[arraySize];

		if (Rider.riderList.size() > 0 ) {
			for(int i = 0;i < Rider.riderList.size(); i++) {
				if (Rider.riderList.get(i).getTeamID() == teamId) {
					teamRiderIDList[counter] = Rider.riderList.get(i).getRiderID();
					counter ++;
				}
			}
			
		}
		
		return teamRiderIDList;
	} 

	/**
	 * Creates a rider
	 * @param name
	 * @param teamID
	 * @param yearOfBirth
	 * @return riderID
	 */

	@Override
	public int createRider(int teamID, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException {
		
		
		boolean validName = true, validYOB = true;

		
		if(name == null) {
			validName = false;
		}

		if(yearOfBirth < 1900) {
			validYOB = false;
		}

		if(checkTeamID(teamID) == false) {
			throw new IDNotRecognisedException();
		}
		else if((validName == false) || (validYOB == false)) {
			throw new IllegalArgumentException();
		}
		else {
			Rider.riderList.add(new Rider(teamID, yearOfBirth, name, Rider.riderList));
			return Rider.riderList.get(Rider.riderList.size() - 1).getRiderID();
		}
	}

	/**
	 * Removes a rider
	 * @param riderId
	 */

	@Override
	public void removeRider(int riderId) throws IDNotRecognisedException {
		if (checkRiderID(riderId) == false) {
					throw new IDNotRecognisedException();
				}

		for (int i = 0; i < Rider.riderList.size(); i++) {
			if (Rider.riderList.get(i).getRiderID() == riderId) {
				Rider.riderList.remove(i);
			}
		}
	}

	@Override
	public void registerRiderResultsInStage(int stageId, int riderId, LocalTime... checkpoints)
			throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
			InvalidStageStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public LocalTime[] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] getRidersRankInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime[] getRankedAdjustedElapsedTimesInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointsInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointsInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eraseCyclingPortal() {
		// TODO Auto-generated method stub

	}

	/**
	 * Saves cycling portal objects to file
	 * @param filename
	 */

	@Override
	public void saveCyclingPortal(String filename) throws IOException {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(filename));
			out.writeObject(Rider.riderList);
			out.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		

	}

	/**
	 * Loads cycling portal objects from file
	 * @param filename
	 */

	@Override
	public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				filename));
			Rider.riderList = (ArrayList<Rider>)in.readObject();
			in.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Removes a race
	 * @param name
	 */

	@Override
	public void removeRaceByName(String name) throws NameNotRecognisedException {
		
		boolean validName = false;

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceName() == name) {
				validName = true;
				Race.raceList.remove(i);
			}
		}

		if (validName == false) {
			throw new NameNotRecognisedException();
		}

	}

	@Override
	public LocalTime[] getGeneralClassificationTimesInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointsInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointsInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersGeneralClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

}
