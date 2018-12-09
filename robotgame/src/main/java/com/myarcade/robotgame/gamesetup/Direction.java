package com.myarcade.robotgame.gamesetup;

public enum Direction {

	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	public Direction clockwise() {
		switch(this) {
			case NORTH:
				return EAST;
			case EAST:
				return SOUTH;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
			default:
				throw new IllegalStateException("Please make sure Robot has direction cloclwise or anticlockwise" + this);
		}		
	}
	
	public Direction anticlockwise() {
		switch(this) {
		case NORTH:
			return WEST;
		case WEST:
			return SOUTH;
		case SOUTH:
			return EAST;
		case EAST:
			return NORTH;
		default:
			throw new IllegalStateException("Please make sure Robot has direction cloclwise or anticlockwise" + this);
		}
	}
}