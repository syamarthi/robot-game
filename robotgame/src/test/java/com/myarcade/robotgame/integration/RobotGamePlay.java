package com.myarcade.robotgame.integration;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.myarcade.robotgame.gamesetup.InitRobot;
import com.myarcade.robotgame.gamesetup.Location;
import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.gamesetup.RobotState;
import com.myarcade.robotgame.instructions.ExecuteInstructions;
import com.myarcade.robotgame.interfaces.IRobot;
import com.myarcade.robotgame.operation.OperationReport;

public class RobotGamePlay {

	private IRobot irobot;
	
	@Before
	public void setUp() throws Exception {
		this.irobot = new InitRobot().defineBoardEdges(new Location(4,4)).Initialise();		
	}
	
	/** Testing all scenarios from requirements Example A, Example B, Example C */
	
	/**  Example A - Instructions
	 * 	PLACE 0,0,NORTH
	 *	MOVE
	 *	REPORT
	 */
	@Test
	public void testInstructionsExampleA() throws Exception {
		assertEquals("RobotPosition [Location, Direction]: [0, 1, NORTH]", PlayGame("PLACE 0,0,NORTH", "MOVE", "REPORT"));
	}
	
	/**  Example B - Instructions
	 * 	PLACE 0,0,NORTH
	 *	LEFT
	 *	REPORT
	 */
	
	@Test
	public void testInstructionsExampleB() throws Exception {
		assertEquals("RobotPosition [Location, Direction]: [0, 0, WEST]", PlayGame("PLACE 0,0,NORTH", "LEFT", "REPORT"));
	}
	
	/**  Example C - Instructions
	 * 	PLACE 1,2,EAST
	 *	MOVE
	 *	MOVE
	 *	LEFT
	 *	MOVE
	 *	REPORT
	 */
	
	@Test
	public void testInstructionsExampleC() throws Exception {
		assertEquals("RobotPosition [Location, Direction]: [3, 3, NORTH]", PlayGame("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT"));
	}

	private String PlayGame(String... operations) {
		List<String> output = Stream.of(operations)
								.map(new ExecuteInstructions())
								.map(this.irobot)
								.filter(robotstate -> robotstate.operation() instanceof OperationReport)							
								.map(RobotState::newpos)
								.map(RobotPosition::toString)
								.collect(Collectors.toList());
		assertEquals(1, output.size());
		return output.get(0);
	}

	

}
