package com.myarcade.robotgame.gamesetup;

import com.myarcade.robotgame.interfaces.IOperation;

public class RobotState {
	
	private final RobotPosition currentpos;
	private final RobotPosition newpos;
	private final IOperation operation;
	
	public RobotState(RobotPosition currentpos, IOperation operation, RobotPosition newpos) {
		
		this.currentpos = currentpos;
		this.operation = operation;
		this.newpos = newpos;
	}

	public RobotPosition currentpos() {
		return currentpos;
	}
	
	public IOperation operation() {
		return operation;
	}

	public RobotPosition newpos() {
		return newpos;
	}

	
	
}