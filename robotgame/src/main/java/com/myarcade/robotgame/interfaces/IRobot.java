package com.myarcade.robotgame.interfaces;

import java.util.function.Function;

import com.myarcade.robotgame.gamesetup.Location;
import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.gamesetup.RobotState;

public interface IRobot extends Function<IOperation, RobotState>{

	@Override
	RobotState apply(IOperation operation);

	RobotPosition robotposition();
	
	Location boardedges();
}