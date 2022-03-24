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
 * @author Josh Cox
 * @author Dora Napier
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

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceID) {
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

		for (int i = 0; i < Rider.riderList.size(); i++) {
			if (Rider.riderList.get(i).getRiderID() == riderID) {
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

		for (int i = 0; i < Team.teamList.size(); i++) {
			if (Team.teamList.get(i).getTeamID() == teamID) {
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

		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageID() == stageID) {
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

		for (int i = 0; i < Segment.segmentList.size(); i++) {
			if (Segment.segmentList.get(i).getSegmentID() == segmentID) {
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

		for(int i = 0;i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceName() == name) {
				legalRaceName = false;
			}
		}
		if((name == null) || (name == "") || (name.length() > 30) || (name.contains(" "))) {
			validRaceName = false;
		}

		if(validRaceName == false) {
			throw new InvalidNameException();
		}
		else if(legalRaceName == false) {
			throw new IllegalNameException();
		}
		else {
			Race.raceList.add(new Race(name, description));
			assert Race.raceList.get(Race.raceList.size() - 1).getRaceName() == name;

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

		if (checkRaceID(raceId) == false) {
			throw new IDNotRecognisedException();
		}
		else {

			int correctRace = 0;
			for (int i = 0; i < Race.raceList.size(); i++) {
				if (Race.raceList.get(i).getRaceID() == raceId) {
					correctRace = i;
					break;
				}
			}
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


		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				Race.raceList.remove(i);
			}
		}

		if (checkRaceID(raceId) == false) {
			throw new IDNotRecognisedException();
		}

	}

	@Override
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
		
		int numStages = 0;

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				numStages = Race.raceList.get(i).getNumOfStages();
			}
		}

		if (checkRaceID(raceId) == false) {
			throw new IDNotRecognisedException();
		}
		return numStages;
	}

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime,
			StageType type)
			throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		
		boolean legalStageName = true, validStageName = true, validStageLength = true;
		

		for(int i = 0;i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageName() == stageName) {
				legalStageName = false;
			}
		}

		if((stageName == null) || (stageName == "") || (stageName.length() > 30) || (stageName.contains(" "))) {
			validStageName = false;
		}

		if (length < 5) {
			validStageLength = false;
		}

		if (checkRaceID(raceId) == false) {
			throw new IDNotRecognisedException();
		}
		else if (legalStageName == false) {
			throw new IllegalNameException();
		}
		else if (validStageName == false) {
			throw new InvalidNameException();
		}
		else if (validStageLength == false) {
			throw new InvalidLengthException();
		}
		else {
			int correctRace = 0;
			for (int i = 0; i < Race.raceList.size(); i++) {
				if (Race.raceList.get(i).getRaceID() == raceId) {
					correctRace = i;
				}
			}
			//add new stage to stageList and raceStageList
			Stage.stageList.add(new Stage(raceId, stageName, description, length, startTime, type));
			Race.raceList.get(correctRace).getRaceStage().add(
				Stage.stageList.get(Stage.stageList.size() - 1));
		}

		return Stage.stageList.get(Stage.stageList.size() - 1).getStageID();
	}

	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {

		if (checkRaceID(raceId) == false){
			throw new IDNotRecognisedException();
		}
		
		int counter = 0;
		int arraySize = 0;

		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getRaceID() == raceId) {
				arraySize ++;
			}
		}

		int [] raceStageIDList = new int[arraySize];

		if (Stage.stageList.size() > 0 ) {
			for(int i = 0;i < Stage.stageList.size(); i++) {
				if (Stage.stageList.get(i).getRaceID() == raceId) {
					raceStageIDList[counter] = Stage.stageList.get(i).getStageID();
					counter ++;
				}
			}
			
		}
		
		return raceStageIDList;
	
	}

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		
		double stageLength = 0;

		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageID() == stageId) {
				stageLength = Stage.stageList.get(i).getStageLength();
			}
		}

		if (checkStageID(stageId) == false) {
			throw new IDNotRecognisedException();
		}

		return stageLength;
	}

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {


		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageID() == stageId) {
				Stage.stageList.remove(i);
			}
		}

		if (checkStageID(stageId) == false) {
			throw new IDNotRecognisedException();
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

	@Override
	public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
		
		boolean validTeamName = true, legalTeamName = true;

		for(int i = 0;i < Team.teamList.size(); i++) {
			if (Team.teamList.get(i).getTeamName() == name) {
				legalTeamName = false;
			}
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
