package com.myarcade.robotgame.instructions;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myarcade.robotgame.gamesetup.Direction;
import com.myarcade.robotgame.interfaces.IOperation;
import com.myarcade.robotgame.operation.OperationLeft;
import com.myarcade.robotgame.operation.OperationMove;
import com.myarcade.robotgame.operation.OperationNoMove;
import com.myarcade.robotgame.operation.OperationPlace;
import com.myarcade.robotgame.operation.OperationReport;
import com.myarcade.robotgame.operation.OperationRight;

public class ExecuteInstructions implements Function<String, IOperation>{

	private static final String LEFT = "LEFT";
	private static final String MOVE = "MOVE";
    private static final String INSTRUCTION_PREFIX = "PLACE";
    private static final Pattern INSTRUCTION_REGEX = Pattern.compile(INSTRUCTION_PREFIX + " (\\d+),(\\d+),(\\w+)");
    private static final String REPORT = "REPORT";
    private static final String RIGHT = "RIGHT";
    private static final String NORTH = "NORTH";
    private static final String EAST = "EAST";
    private static final String SOUTH = "SOUTH";
    private static final String WEST = "WEST";
    
	@Override
	public IOperation apply(String commandString) {		
		if (commandString == null || commandString.isEmpty()) {
           // LOGGER.warning("Empty command");
            return new OperationNoMove();
        } else if (commandString.equals(LEFT)) {
            return new OperationLeft();
        } else if (commandString.equals(MOVE)) {
            return new OperationMove();
        } else if (commandString.startsWith(INSTRUCTION_PREFIX)) {
            return this.parsePlaceCommand(commandString);
        } else if (commandString.equals(REPORT)) {
            return new OperationReport();
        } else if (commandString.equals(RIGHT)) {
            return new OperationRight();
        } else {
          //  LOGGER.warning("Unknown command: " + commandString + "; doing nothing.");
            return new OperationNoMove();
        }		

	}
	
	 private IOperation parsePlaceCommand(String commandString) {
	        Matcher matcher = INSTRUCTION_REGEX.matcher(commandString);
	        if (matcher.matches()) {
	            return producePlaceCommand(matcher);
	        } else {
	 //           LOGGER.warning("Unknown command: " + commandString + "; doing nothing.");
	            return new OperationNoMove();
	        }
	    }

	    private IOperation producePlaceCommand(Matcher matcher) {
	        try {
	            return new OperationPlace(
	                    Integer.parseInt(matcher.group(1)),
	                    Integer.parseInt(matcher.group(2)),
	                    this.parsePlaceCommandOrientation(matcher.group(3))
	            );
	        } catch (IllegalArgumentException e) {
	            //LOGGER.warning(e.getMessage());
	            return new OperationNoMove();
	        }
	    }

	    private Direction parsePlaceCommandOrientation(String orientationString) {
	        if (orientationString == null || orientationString.isEmpty()) {
	            throw new IllegalArgumentException("Empty orientation");
	        } else if (orientationString.equals(NORTH)) {
	            return Direction.NORTH;
	        } else if (orientationString.equals(EAST)) {
	            return Direction.EAST;
	        } else if (orientationString.equals(SOUTH)) {
	            return Direction.SOUTH;
	        } else if (orientationString.equals(WEST)) {
	            return Direction.WEST;
	        } else {
	            throw new IllegalArgumentException("Unknown orientation: " + orientationString);
	        }
	    }
    
    
}