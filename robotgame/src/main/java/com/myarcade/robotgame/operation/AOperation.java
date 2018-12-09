package com.myarcade.robotgame.operation;

import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.interfaces.IOperation;

public abstract class AOperation implements IOperation {

	@Override
	public RobotPosition apply(RobotPosition robotposition) {
		if (robotposition == null) {
			return null;
		}
		return this.applyInternal(robotposition);
	}
	

	protected abstract RobotPosition applyInternal(RobotPosition robotposition);	

}