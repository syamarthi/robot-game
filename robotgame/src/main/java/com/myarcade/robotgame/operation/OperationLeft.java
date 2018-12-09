package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;

public class OperationLeft extends AOperation{

	@Override
	protected RobotPosition applyInternal(RobotPosition robotposition) {
		
		return new RobotPosition(robotposition.getLocation(), robotposition.getDirection().anticlockwise());
	}	

}