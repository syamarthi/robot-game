package com.myarcade.robotgame.instructions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import com.myarcade.robotgame.gamesetup.Direction;
import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.interfaces.IOperation;
import com.myarcade.robotgame.operation.OperationLeft;
import com.myarcade.robotgame.operation.OperationMove;
import com.myarcade.robotgame.operation.OperationPlace;
import com.myarcade.robotgame.operation.OperationReport;
import com.myarcade.robotgame.operation.OperationRight;

public class ExecuteInstructionsTest {
	
	private ExecuteInstructions executeInstructions;
	private RobotPosition testRobotPosition;

	@Before
	public void setUp() throws Exception {
		this.executeInstructions = new ExecuteInstructions();
		this.testRobotPosition = new RobotPosition(0,0, Direction.NORTH);		
	}

	/** Testing invalid input test cases*/
	
	@Test
    public void testInvalidInstruction1() throws Exception {
		IOperation operation = executeInstructions.apply("PLACE4,2,EAST");
        RobotPosition  robotposition = operation.apply(this.testRobotPosition);
        assertEquals(this.testRobotPosition, robotposition);
    }

    @Test
    public void testInvalidInstruction2() throws Exception {
    	IOperation operation = executeInstructions.apply("PLACE 4, 2,EAST");
    	RobotPosition  robotposition = operation.apply(this.testRobotPosition);
    	assertEquals(this.testRobotPosition, robotposition);
    }

    @Test
    public void testInvalidInstruction3() throws Exception {
    	IOperation operation = executeInstructions.apply("PLACE 4,2,HUBWARD");
    	RobotPosition  robotposition = operation.apply(this.testRobotPosition);
    	assertEquals(this.testRobotPosition, robotposition);
    }
    
    /** Testing Valid input test cases*/
    
	@Test
	public void testOperationRight() throws Exception{
		IOperation operation = executeInstructions.apply("RIGHT");
		assertTrue(operation instanceof OperationRight);
	}
	
	 @Test
	    public void testValidInstruction1() throws Exception {
		 	IOperation operation = executeInstructions.apply("PLACE 0,0,NORTH");
		 	RobotPosition  robotposition = operation.apply(this.testRobotPosition);
	        assertEquals(new RobotPosition(0, 0, Direction.NORTH), robotposition);
	    }

	    @Test
	    public void testValidInstruction2() throws Exception {
	    	IOperation operation = executeInstructions.apply("PLACE 2,3,SOUTH");
	    	RobotPosition  robotposition = operation.apply(this.testRobotPosition);
	        assertEquals(new RobotPosition(2, 3, Direction.SOUTH), robotposition);
	    }

	    @Test
	    public void testValidInstruction3() throws Exception {
	    	IOperation operation = executeInstructions.apply("PLACE 4,2,EAST");
	    	RobotPosition  robotposition = operation.apply(this.testRobotPosition);
	        assertNotEquals(new RobotPosition(2, 4, Direction.WEST), robotposition);
	    }

	    @Test
	    public void testOperationLeft() throws Exception {
	    	IOperation operation = executeInstructions.apply("LEFT");
	        assertTrue(operation instanceof OperationLeft);
	    }

	    @Test
	    public void testOperationMove() throws Exception {
	    	IOperation operation = executeInstructions.apply("MOVE");
	        assertTrue(operation instanceof OperationMove);
	    }

	    @Test
	    public void testOperationPlace() throws Exception {
	    	IOperation operation = executeInstructions.apply("PLACE 0,0,NORTH");
	        assertTrue(operation instanceof OperationPlace);
	    }

	    @Test
	    public void testOperationReport() throws Exception {
	    	IOperation operation = executeInstructions.apply("REPORT");
	        assertTrue(operation instanceof OperationReport);
	    }

}
