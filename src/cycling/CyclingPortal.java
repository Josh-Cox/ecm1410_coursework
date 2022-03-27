package cycling;

import java.io.FileInputStream;
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

	ArrayList<Rider> riderList = new ArrayList<>();
	ArrayList<Stage> stageList = new ArrayList<>();
	ArrayList<Segment> segmentList = new ArrayList<>();
	ArrayList<Race> raceList = new ArrayList<>();
	ArrayList<Team> teamList = new ArrayList<>();
	ArrayList<Result> resultList = new ArrayList<>();

	public boolean checkRaceName(String name) {
		boolean validName = false;

		//for every race
		for (int i = 0; i < raceList.size(); i++) {
			//if race exists
			if (raceList.get(i).getRaceName() == name) {
				validName = true;
			}
		}

		return validName;
	}
	/**
	 * Checks the id of a race exists 
	 * @param raceID
	 * @return validID
	 */
	
	public boolean checkRaceID(int raceID) {
		
		boolean validID = false;

		//for every race
		for (int i = 0; i < raceList.size(); i++) {
			//if race exists
			if (raceList.get(i).getRaceID() == raceID) {
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
		for (int i = 0; i < riderList.size(); i++) {
			//if rider exists
			if (riderList.get(i).getRiderID() == riderID) {
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
		for (int i = 0; i < teamList.size(); i++) {
			//if team exists
			if (teamList.get(i).getTeamID() == teamID) {
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
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageID) {
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
		for (int i = 0; i < segmentList.size(); i++) {
			//if segment exists
			if (segmentList.get(i).getSegmentID() == segmentID) {
				//segment is valid
				validID = true;
			}
		}

		return validID;
	}

	/**
	 * Checks if stage is a time trial
	 * @param stageID
	 * @return validStage
	 */

	public boolean checkStageType(int stageID) {

		boolean validStage = true;

		//for every stage
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageID) {
				//if stage is time trials
				if ( stageList.get(i).getStageType() == StageType.TT) {
					//throw exception
					validStage = false;
				}
			}
		}

		return validStage;
	}


	/**
	 * Checks the location of segment
	 * @param stageId
	 * @param location
	 * @return validLocation
	 */
	public boolean checkSegmentLocation(int stageID, double location) {
		boolean validLocation = true;

		//for every segment
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageID) {
				//if invalid length
				if (stageList.get(i).getStageLength() < location) {
					validLocation = false;
				}
			}
		}

		return validLocation;
	}

	/**
	 * Checks the state of stage
	 * @param stageID
	 * @return validState
	 */
	public boolean checkStageState(int stageID) {
		boolean validState = true;

		//for every stage
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageID) {
				//if stage is waiting for results
				if (stageList.get(i).getStageState() == "waiting for results") {
					validState = false;
				}
			}
		}

		return validState;
	}

	/**
	 * Gets an array of all race id's
	 * @return raceIDlist 
	 */

	@Override
	public int[] getRaceIds() {
		
		//create array of correct size
		int [] raceIDList = new int[raceList.size()];
		if (raceList.size() > 0 ) {
			for(int i = 0;i < raceList.size(); i++) {
				//fill array with race IDs
				raceIDList[i]= raceList.get(i).getRaceID();
			}
			//check first ID is correct
			assert raceIDList[0]== raceList.get(0).getRaceID();
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
		for(int i = 0;i < raceList.size(); i++) {
			//if race exists
			if (raceList.get(i).getRaceName() == name) {
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
			raceList.add(new Race(name, description, raceList));
			//assert race was added
			assert raceList.get(raceList.size() - 1).getRaceName() == name;
			//return race ID
			return raceList.get(raceList.size() - 1).getRaceID();
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
			for (int i = 0; i < raceList.size(); i++) {
				//if race exists
				if (raceList.get(i).getRaceID() == raceId) {
					//set correctRace
					correctRace = i;
					break;
				}
			}
			//return formatted race details
			return raceList.get(correctRace).toString();
			
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
		
		//for every race
		for (int i = 0; i < raceList.size(); i++) {
			//if race exists
			if (raceList.get(i).getRaceID() == raceId) {
				//remove stages
				//for every stage
				for (int j = 0; j < stageList.size(); j++) {
					//if stage is part of race
					if (stageList.get(j).getRaceID() == raceId) {
						try {
							removeStageById(stageList.get(j).getStageID());
						}
						catch (IDNotRecognisedException e) {
							System.out.println("ID not recognised");
						}
					}
				}
				//remove race
				raceList.remove(i);
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
			for (int i = 0; i < raceList.size(); i++) {
				//if race exists
				if (raceList.get(i).getRaceID() == raceId) {
					//set numStages to number of stages
					numStages = raceList.get(i).getNumOfStages();
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
		for(int i = 0;i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageName() == stageName) {
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
			for (int i = 0; i < raceList.size(); i++) {
				//if race exists
				if (raceList.get(i).getRaceID() == raceId) {
					//set correctRace
					correctRace = i;
				}
			}
			//add new stage to stageList
			stageList.add(new Stage(raceId, stageName, description, length, startTime, type, stageList));
		}

		//return stageID
		return stageList.get(stageList.size() - 1).getStageID();
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
			for (int i = 0; i < stageList.size(); i++) {
				//if stage exists
				if (stageList.get(i).getRaceID() == raceId) {
					//incremenet arraySize
					arraySize ++;
				}
			}
	
			//if array contains values
			if (stageList.size() > 0 ) {
				//for every stage
				for(int i = 0;i < stageList.size(); i++) {
					//if stage exists
					if (stageList.get(i).getRaceID() == raceId) {
						//add stageID to raceStageIDList
						raceStageIDList[counter] = stageList.get(i).getStageID();
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
			for (int i = 0; i < stageList.size(); i++) {
				//if stage exists
				if (stageList.get(i).getStageID() == stageId) {
					//set stageLength to length of stage
					stageLength = stageList.get(i).getStageLength();
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

		//for every stage
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageId) {

				//for every segment
				for (int j = 0; j < segmentList.size(); j++) {
					//if segment is part of stage
					if (segmentList.get(j).getStageID() == stageId) {
						//remove segment
						try {
							removeSegment(segmentList.get(j).getSegmentID());
						} catch (InvalidStageStateException e) {
							System.out.println("Invalid Stage State");
						}
					}
				}
				//for every result
				for (int j = 0; j < resultList.size(); j++) {
					//if result is part of stage
					if (resultList.get(j).getStageID() == stageId) {
						//remove result
						resultList.remove(j);
					}
				}
				//remove stage
				stageList.remove(i);
			}
		}
		

	}

	/**
	 * Adds catergorized climb
	 * @param stageId
	 * @param location
	 * @param type
	 * @param averageGradient
	 * @param length
	 * @return ID of created segment
	 */

	@Override
	public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient,
			Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,
			InvalidStageTypeException {
		//if stage doesn't exists
		if (checkStageID(stageId) == false){
			//throw exception
			throw new IDNotRecognisedException();
		}

		//if invalid stageType
		if (checkStageType(stageId) == false) {
			//throw exception
			throw new InvalidStageTypeException();
		}
		
		//if invalid location
		if (checkSegmentLocation(stageId, location) == false) {
			//throw exception
			throw new InvalidLocationException();
		}
		
		//if invalid state
		if (checkStageState(stageId) == false) {
			//throw exception
			throw new InvalidStageStateException();
		}

		//add new segment to segmentList
		segmentList.add(new Segment(stageId, location, type, averageGradient, length, segmentList));
		//return id of created segment
		return segmentList.get(segmentList.size() - 1).getSegmentID();
	}


	/**
	 * Adds intermediate sprint
	 * @param stageId
	 * @param location
	 * @return ID of created segment
	 */

	@Override
	public int addIntermediateSprintToStage(int stageId, double location) throws IDNotRecognisedException,
			InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
		
		//if stage doesn't exist
		if (checkStageID(stageId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		//if invalid location
		if (checkSegmentLocation(stageId, location) == false) {
			//throw exception
			throw new InvalidLocationException();
		}

		//if invalid stageType
		if (checkStageType(stageId) == false) {
			//throw exception
			throw new InvalidStageTypeException();
		}

		//if invalid state
		if (checkStageState(stageId) == false) {
			//throw exception
			throw new InvalidStageStateException();
		}

		//add new segment to segmentList
		segmentList.add(new Segment(stageId, location, segmentList));
		//return id of created segment
		return segmentList.get(segmentList.size() - 1).getSegmentID();

		
	}

	/**
	 * Removes a segment
	 * @param segmentId
	 */

	@Override
	public void removeSegment(int segmentId) throws IDNotRecognisedException, InvalidStageStateException {

		//if segment doesn't exist
		if (checkSegmentID(segmentId) == false) {
			throw new IDNotRecognisedException();
		}

		for (int i = 0; i < segmentList.size(); i++) {
			if (segmentList.get(i).getSegmentID() == segmentId) {
				//if invalid state
				if (checkStageState(segmentList.get(i).getStageID()) == false) {
					//throw exception
					throw new InvalidStageStateException();
				}
			}
		}

		//for every segment
		for (int i = 0; i < segmentList.size(); i++) {
			//if segment exists
			if (segmentList.get(i).getSegmentID() == segmentId) {
				//remove segment
				segmentList.remove(i);
			}
		}

	}

	/**
	 * Changes state of Stage
	 * @param stageId
	 */
	@Override
	public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
		
		//if stage doesn't exist
		if (checkStageID(stageId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		//if invalid state
		if (checkStageState(stageId) == false) {
			//throw exception
			throw new InvalidStageStateException();
		}

		//for every stage
		for (int i = 0; i < stageList.size(); i++) {
			//if stage exists
			if (stageList.get(i).getStageID() == stageId) {
				//chaneg stage state
				stageList.get(i).setStageState("waiting for results");
			}
		}

	}

	/**
	 * Gets a list of all segment IDs in a stage
	 * @param stageId
	 * @return stageSegmentIDList
	 */
	@Override
	public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
		
		//if stage doesn't exist
		if (checkStageID(stageId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		int counter = 0;
		int arraySize = 0;

		//for every segment
		for (int i = 0; i < segmentList.size(); i++) {
			//if segment is part of stage
			if (segmentList.get(i).getStageID() == stageId) {
				//increment array size
				arraySize ++;
			}
		}

		//create correct length array
		int [] stageSegmentIDList = new int[arraySize];

		//if a segment exists
		if (segmentList.size() > 0 ) {
			//for every segment
			for(int i = 0;i < segmentList.size(); i++) {
				//if rider is part of team
				if (segmentList.get(i).getStageID() == stageId) {
					//add rider id to array
					stageSegmentIDList[counter] = segmentList.get(i).getSegmentID();
					counter ++;
				}
			}
			
		}
		
		return stageSegmentIDList;
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
		for(int i = 0;i < teamList.size(); i++) {
			//if team name exists
			if (teamList.get(i).getTeamName() == name) {
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

		//if invalid name
		if(validTeamName == false) {
			//throw exception
			throw new InvalidNameException();
		}

		//if illegal name
		if(legalTeamName == false) {
			//throw exception
			throw new IllegalNameException();
		}

		//add team to teamList
		teamList.add(new Team(name, description, teamList));
		//return ID of created team
		return teamList.get(teamList.size() - 1).getTeamID();
		
	}

	/**
	 * Removes a team
	 * @param teamId
	 */

	@Override
	public void removeTeam(int teamId) throws IDNotRecognisedException {

		//if team doesn't exist
		if (checkTeamID(teamId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		//array of riderIDs to remove
		int[] ridersToRemove = getTeamRiders(teamId);

		//for every rider to remove
		for (int i = 0; i < ridersToRemove.length; i++) {
			//remove rider
			removeRider(ridersToRemove[i]);
		}

		//for every team
		for (int i = 0; i < teamList.size(); i++) {
			//if team exists
			if (teamList.get(i).getTeamID() == teamId) {
				teamList.remove(i);
			}
		}

	}

	/**
	 * GetsIDs of all teams
	 * @return teamIDList
	 */

	@Override
	public int[] getTeams() {

		int [] teamIDList = new int[teamList.size()];
		if (teamList.size() > 0 ) {
			for(int i = 0;i < teamList.size(); i++) {
				teamIDList[i]= teamList.get(i).getTeamID();
			}
			assert teamIDList[0] == teamList.get(0).getTeamID();
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

		//if team doesn't exist
		if (checkTeamID(teamId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		int counter = 0;
		int arraySize = 0;

		//for every rider
		for (int i = 0; i < riderList.size(); i++) {
			//if rider is part of team
			if (riderList.get(i).getTeamID() == teamId) {
				//increment array size
				arraySize ++;
			}
		}

		//create correct length array
		int [] teamRiderIDList = new int[arraySize];

		//if a rider exists
		if (riderList.size() > 0 ) {
			//for every rider
			for(int i = 0;i < riderList.size(); i++) {
				//if rider is part of team
				if (riderList.get(i).getTeamID() == teamId) {
					//add rider id to array
					teamRiderIDList[counter] = riderList.get(i).getRiderID();
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

		//if name or year of birth is invalid
		if ((name == null) || (yearOfBirth < 1900)) {
			//throw exception
			throw new IllegalArgumentException();
		}

		//if team doesn't exist
		if(checkTeamID(teamID) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		//add created rider to riderList
		riderList.add(new Rider(teamID, yearOfBirth, name, riderList));
		//return ID of created rider
		return riderList.get(riderList.size() - 1).getRiderID();
		
	}

	/**
	 * Removes a rider
	 * @param riderId
	 */

	@Override
	public void removeRider(int riderId) throws IDNotRecognisedException {

		//if rider doesn't exist
		if (checkRiderID(riderId) == false) {
			//throw exception
				throw new IDNotRecognisedException();
			}

		//for every result
		for (int i = 0; i < resultList.size(); i++) {
			//if result is part of rider
			if (resultList.get(i).getRiderID() == riderId) {
				//remove result
				resultList.remove(i);
			}
		}

		//for every rider
		for (int i = 0; i < riderList.size(); i++) {
			//if rider exists
			if (riderList.get(i).getRiderID() == riderId) {
				//remove rider
				riderList.remove(i);
			}
		}
	}

	@Override
	public void registerRiderResultsInStage(int stageId, int riderId, LocalTime... checkpoints)
			throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
			InvalidStageStateException {
		
			//if stage doesn't exist
			if (checkStageID(stageId) == false) {
				//throw exception
				throw new IDNotRecognisedException();
			}

			//if rider doesn't exist
			if (checkRiderID(riderId) == false) {
				//throw exception
				throw new IDNotRecognisedException();
			}

			//if stage state is invalid
			if (checkStageState(stageId) == true) {
				//throw exception
				throw new InvalidStageStateException();
			}

			//TODO: ValidCheckpointsException
			
			//for every result
			for (int i = 0; i < resultList.size(); i++) {
				//if result is part of rider and stage
				if ((resultList.get(i).getRiderID() == riderId) &&
				(resultList.get(i).getStageID() == stageId)) {
					//throw exception
					throw new DuplicatedResultException();
				}
			}

		//add created result to resultList
		resultList.add(new Result(stageId, riderId, checkpoints, resultList));

	}

	@Override
	public LocalTime[] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		
		return null;
	}

	@Override
	public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes rider results from stage
	 * @param riderId
	 * @param stageId
	 */

	@Override
	public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		
		//if rider doesn't exist
		if (checkRiderID(riderId) == false) {
			//throw exception
			throw new IDNotRecognisedException();
		}

		//for every result
		for (int i = 0; i < resultList.size(); i++) {
			//if result is part of rider
			if ((resultList.get(i).getRiderID() == riderId) && 
			(resultList.get(i).getStageID() == stageId)) {
				//remove result
				resultList.remove(i);
			}
		}

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
		riderList.clear();
		raceList.clear();
		stageList.clear();
		segmentList.clear();
		resultList.clear();
		teamList.clear();
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
			out.writeObject(riderList);
			out.writeObject(raceList);
			out.writeObject(stageList);
			out.writeObject(segmentList);
			out.writeObject(resultList);
			out.writeObject(teamList);
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
			riderList = (ArrayList<Rider>)in.readObject();
			raceList = (ArrayList<Race>)in.readObject();
			stageList = (ArrayList<Stage>)in.readObject();
			segmentList = (ArrayList<Segment>)in.readObject();
			resultList = (ArrayList<Result>)in.readObject();
			teamList = (ArrayList<Team>)in.readObject();
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
	public void removeRaceByName(String name) throws NameNotRecognisedException{
		
		//if race doesn't exist
		if (checkRaceName(name) == false) {
			//throw exception
			throw new NameNotRecognisedException();
		}

		//for every race
		for (int i = 0; i < raceList.size(); i++) {
			//if race exists
			if (raceList.get(i).getRaceName() == name) {
				//remove stages
				int raceToRemove = raceList.get(i).getRaceID();
				//for every stage
				for (int j = 0; j < stageList.size(); j++) {
					//if stage is part of race
					if (stageList.get(j).getRaceID() == raceToRemove) {
						try {
							removeStageById(stageList.get(j).getStageID());
						}
						catch (IDNotRecognisedException e) {
							System.out.println("ID not recognised");
						}
					}
				}
				//remove race
				raceList.remove(i);
			}
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
