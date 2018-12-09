package com.myarcade.robotgame.interfaces;

import java.util.function.UnaryOperator;

import com.myarcade.robotgame.gamesetup.RobotPosition;

public interface IOperation extends UnaryOperator<RobotPosition> {

	@Override
	RobotPosition apply(RobotPosition robotposition);
	

}
