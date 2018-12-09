package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;

public class OperationReport extends AOperation{

	@Override
	protected RobotPosition applyInternal(RobotPosition robotposition) {		
		return robotposition;
	}
	
}