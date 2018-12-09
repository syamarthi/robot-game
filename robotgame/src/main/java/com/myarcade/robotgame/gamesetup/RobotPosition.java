package com.myarcade.robotgame.gamesetup;

public class RobotPosition {
	
	private final Location location;
	private final Direction direction;
	
	public RobotPosition(Location location, Direction direction) {
		this.location = location;
		this.direction = direction;
	}

	public RobotPosition(int xvalue, int yvalue, Direction direction) {
		this.location = new Location(xvalue, yvalue);
		this.direction = direction;
	}
	
	public Location getLocation() {
		return this.location;
	}

	public Direction getDirection() {
		return this.direction;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RobotPosition other = (RobotPosition) obj;
		if (direction != other.direction)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotPosition [Location, Direction]: [" + location + ", " + direction + "]" ;
	}
	
	

}