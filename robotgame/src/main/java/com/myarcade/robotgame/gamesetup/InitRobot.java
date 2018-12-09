package com.myarcade.robotgame.gamesetup;

import com.myarcade.robotgame.interfaces.IRobot;

public class InitRobot {
	
	private Location location;
	private RobotPosition robotposition;
	
	public InitRobot defineBoardEdges(Location location) {
		this.location=location;
		return this;
	}
	
	public IRobot Initialise() {
		if(this.location == null) {
			throw new IllegalStateException("Please set the boundaries for the board");
		}
		return new PlaceRobot(this.robotposition, this.location);
	}
}
