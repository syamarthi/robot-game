package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;

public class OperationRight extends AOperation{

	@Override
	protected RobotPosition applyInternal(RobotPosition robotposition) {
		return new RobotPosition(robotposition.getLocation(), robotposition.getDirection().clockwise());
	}	

}
