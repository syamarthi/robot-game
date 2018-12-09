package com.myarcade.robotgame;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.myarcade.robotgame.gamesetup.InitRobot;
import com.myarcade.robotgame.gamesetup.Location;
import com.myarcade.robotgame.gamesetup.RobotState;
import com.myarcade.robotgame.instructions.ExecuteInstructions;
import com.myarcade.robotgame.instructions.ReadInstructions;
import com.myarcade.robotgame.interfaces.IRobot;
import com.myarcade.robotgame.operation.OperationReport;

public class RobotMain {

	/**Define board edges */
	private static final Location BOARDEDGES = new Location(4,4); 
	
	public static void main(String[] args) {
		 
		/**Initialize logging */
		initializeLogging();
		
		/** Initialize robot, set game board edges and set initial location(x,y) and direction */
		IRobot robot = initializeRobot();
		
		/** Lets play game */
		playGame(args, robot);	           		  
		 
	}

	private static void playGame(String[] args, IRobot robot) {
		new ReadInstructions().apply(args)
							.map(new ExecuteInstructions())
							.map(robot)
							.filter(robotstate -> robotstate.operation() instanceof OperationReport)							
							.map(RobotState::newpos)
							.forEach(robotposition -> System.out.println((robotposition != null) ? robotposition: "Not yet placed"));
		
	}

	private static IRobot initializeRobot() {		
		return new InitRobot()
				.defineBoardEdges(BOARDEDGES)
				.Initialise();
	}

	private static void initializeLogging() {
		Logger mainLog = Logger.getLogger("");
		mainLog.setLevel(Level.FINE);
		mainLog.getHandlers()[0].setLevel(Level.FINE);
		
	}

}
