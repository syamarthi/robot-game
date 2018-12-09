package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.Direction;
import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.interfaces.IOperation;

public class OperationPlace implements IOperation {
	
	private final RobotPosition robotposition;

	public OperationPlace(int xvalue, int yvalue, Direction direction) {
		this(new RobotPosition(xvalue, yvalue, direction));
	}
	
	public OperationPlace(RobotPosition robotposition) {
		this.robotposition = robotposition;
	}

	@Override
	public RobotPosition apply(RobotPosition robotposition) {
		// TODO Auto-generated method stub
		return this.robotposition;
	}	

}