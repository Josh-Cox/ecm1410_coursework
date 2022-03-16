package cycling;

import java.io.IOException;
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
	

	@Override
	public int[] getRaceIds() {
		
		int [] raceIDList = new int[Race.raceList.size()];
		if (Race.raceList.size() > 0 ) {
			for(int i = 0;i < Race.raceList.size(); i++) {
				raceIDList[i]= Race.raceList.get(i).getRaceID();
			}
			assert raceIDList[0]== Race.raceList.get(0).getRaceID();
		}
		
		return raceIDList;
	}

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
			return Race.raceList.get(Race.raceList.size() - 1).getRaceID();
		}
	
	}

	@Override
	public String viewRaceDetails(int raceId) throws IDNotRecognisedException {
		
		int correctRace = 0;
		boolean validID = false;
		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				correctRace = i;
				validID = true;
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
		}
		else {
			return Race.raceList.get(correctRace).toString();
		}
		
	}

	@Override
	public void removeRaceById(int raceId) throws IDNotRecognisedException {

		boolean validID = false;

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				validID = true;
				Race.raceList.remove(i);
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
		}

	}

	@Override
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
		
		boolean validID = false;
		int numStages = 0;

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				validID = true;
				numStages = Race.raceList.get(i).getNumOfStages();
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
		}
		return numStages;
	}

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime,
			StageType type)
			throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		
		boolean raceExists = false, legalStageName = true, validStageName = true, validStageLength = true;

		for (int i = 0; i < Race.raceList.size(); i++) {
			if (Race.raceList.get(i).getRaceID() == raceId) {
				raceExists = true;
				Race.raceList.get(i).getRaceStage().add(new Stage(stageName, description, length, startTime, type));
			}
		}

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

		if (raceExists == true) {
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

		return Stage.stageList.get(Stage.stageList.size() - 1).getStageID();
	}

	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		
		boolean validID = false;
		double stageLength = 0;

		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageID() == stageId) {
				validID = true;
				stageLength = Stage.stageList.get(i).getStageLength();
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
		}

		return stageLength;
	}

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {

		boolean validID = false;

		for (int i = 0; i < Stage.stageList.size(); i++) {
			if (Stage.stageList.get(i).getStageID() == stageId) {
				validID = true;
				Stage.stageList.remove(i);
			}
		}

		if (validID == false) {
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
		
		boolean validID = false;

		for (int i = 0; i < Team.teamList.size(); i++) {
			if (Team.teamList.get(i).getTeamID() == teamId) {
				validID = true;
				Team.teamList.remove(i);
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
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
		
		
		boolean found = true, validName = true, validYOB = true;

		for(int i = 0;i < Team.teamList.size(); i++) {
			if (Team.teamList.get(i).getTeamID() == teamID) {
			}
            else {
				found = false;
            }
        }
		
		if(name == null) {
			validName = false;
		}

		if(yearOfBirth < 1900) {
			validYOB = false;
		}

		if(found == false) {
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
		
		boolean validID = false;

		for (int i = 0; i < Rider.riderList.size(); i++) {
			if (Rider.riderList.get(i).getRiderID() == riderId) {
				validID = true;
				Rider.riderList.remove(i);
			}
		}

		if (validID == false) {
			throw new IDNotRecognisedException();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

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
