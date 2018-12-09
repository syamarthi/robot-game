package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.interfaces.IOperation;

public class OperationNoMove implements IOperation{

	@Override
	public RobotPosition apply(RobotPosition robotposition) {
		
		return robotposition;
	}	

}