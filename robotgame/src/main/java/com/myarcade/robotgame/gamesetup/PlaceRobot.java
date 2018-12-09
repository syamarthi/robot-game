package com.myarcade.robotgame.gamesetup;

import com.myarcade.robotgame.interfaces.IOperation;
import com.myarcade.robotgame.interfaces.IRobot;

public class PlaceRobot implements IRobot{
	
	private final Location boardedges;

	private RobotPosition robotposition;
	
	public PlaceRobot(RobotPosition robotposition, Location boardedges) {
		this.boardedges = boardedges;
		this.robotposition = robotposition;
	}

	public RobotState apply(IOperation operation) {
	
		RobotPosition currentpos = this.robotposition;
		RobotPosition newpos = operation.apply(this.robotposition);
		
		if (isValidRobotPosition(newpos)) {
			this.robotposition = newpos;
			return new RobotState(currentpos, operation, newpos);
		}else {
			return new RobotState(currentpos, operation, currentpos);
		}
	}

	public RobotPosition robotposition() {
	
		return robotposition;
	}

	public Location boardedges() {
	
		return boardedges;
	}

	private boolean isValidRobotPosition(RobotPosition robotposition) {
		
		if(robotposition == null) {
			return true;
		}
		Location location = robotposition.getLocation();
		return location.getXvalue() >=0 && location.getYvalue() >=0 && location.getXvalue() < boardedges.getXvalue() && location.getYvalue() < boardedges.getYvalue();
	}

	@Override
	public String toString() {
		return "Robot Position: " + (robotposition !=null ? robotposition.toString() : "Robot was not placed");
	}
	
}
