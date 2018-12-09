package com.myarcade.robotgame.gamesetup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myarcade.robotgame.interfaces.IRobot;
import com.myarcade.robotgame.operation.OperationMove;
import com.myarcade.robotgame.operation.OperationPlace;

public class PlaceRobotTest {
	private IRobot irobot;
	
	@Before
	public void setUp() throws Exception {
		this.irobot = new InitRobot()
							.defineBoardEdges(new Location(2,2))
							.Initialise();
	}
	
	@Test
	public void testBoardEdges() throws Exception {
        this.irobot.apply(new OperationPlace(0, 0, Direction.NORTH));
        this.irobot.apply(new OperationMove());
        RobotState robotstate = this.irobot.apply(new OperationMove());
        assertEquals(new RobotPosition(0, 1, Direction.NORTH), robotstate.newpos());
    }

	@Test
	  public void testMoveToInstructionB() throws Exception {
        this.irobot.apply(new OperationPlace(0, 0, Direction.NORTH));
        RobotState robotstate = this.irobot.apply(new OperationMove());
        assertEquals(this.irobot.robotposition(), robotstate.newpos());
    }

}
