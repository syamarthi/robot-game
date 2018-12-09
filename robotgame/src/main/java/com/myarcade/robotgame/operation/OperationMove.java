package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;

public class OperationMove extends AOperation {

	@Override
	public RobotPosition applyInternal(RobotPosition robotposition) {
		switch(robotposition.getDirection()) {
			case NORTH:
				return new RobotPosition(robotposition.getLocation().getXvalue(), robotposition.getLocation().getYvalue()+1, robotposition.getDirection());
			case EAST:
				return new RobotPosition(robotposition.getLocation().getXvalue()+1, robotposition.getLocation().getYvalue(), robotposition.getDirection());
			case SOUTH:
				return new RobotPosition(robotposition.getLocation().getXvalue(), robotposition.getLocation().getYvalue()-1, robotposition.getDirection());
			case WEST:
				return new RobotPosition(robotposition.getLocation().getXvalue()-1, robotposition.getLocation().getYvalue(), robotposition.getDirection());
			default:
				return robotposition;
		}
	}	 

}
