package com.myarcade.robotgame.operation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.myarcade.robotgame.gamesetup.Direction;
import com.myarcade.robotgame.gamesetup.Location;
import com.myarcade.robotgame.gamesetup.RobotPosition;
import com.myarcade.robotgame.interfaces.IOperation;

public class OperationsTest {
	
	private IOperation operationleft;
    private IOperation operationmove;
    private IOperation operationplace;
    private IOperation operationreport;
    private IOperation operationright;
    private RobotPosition robotposition;
    private RobotPosition placeRobotposition;

	@Before
	public void setUp() throws Exception {		
        this.operationleft = new OperationLeft();
        this.operationmove = new OperationMove();        
        this.operationreport = new OperationReport();
        this.operationright = new OperationRight();
        this.robotposition = new RobotPosition(new Location(2, 2), Direction.NORTH);
        this.placeRobotposition = new RobotPosition(new Location(0, 0), Direction.SOUTH);
        this.operationplace = new OperationPlace(this.placeRobotposition);
	}

	 @Test
	    public void testOperationLeft() {
	        assertEquals(new RobotPosition(2, 2, Direction.WEST),
	                this.operationleft.apply(this.robotposition));
	    }

	    @Test
	    public void testOperationMove() {
	        assertEquals(new RobotPosition(2, 3, Direction.NORTH),
	                this.operationmove.apply(this.robotposition));
	    }

	    @Test
	    public void testOperationPlace() {
	        assertEquals(this.placeRobotposition,
	                this.operationplace.apply(this.robotposition));
	    }

	    @Test
	    public void testReportCommand() {
	        assertEquals(new RobotPosition(2, 2, Direction.NORTH),
	                this.operationreport.apply(this.robotposition));
	    }

	    @Test
	    public void testRightCommand() {
	        assertEquals(new RobotPosition(2, 2, Direction.EAST),
	                this.operationright.apply(this.robotposition));
	    }

}
