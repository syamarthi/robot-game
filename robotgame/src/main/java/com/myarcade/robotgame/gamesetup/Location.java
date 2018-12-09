package com.myarcade.robotgame.gamesetup;

public class Location {
	
	private final int xvalue;
	private final int yvalue;
	
	public Location(int xvalue, int yvalue) {
		//super();
		this.xvalue = xvalue;
		this.yvalue = yvalue;
	}

	public int getXvalue() {
		return this.xvalue;
	}

	public int getYvalue() {
		return this.yvalue;
	}

	@Override
	public String toString() {
		return xvalue + ", " + yvalue ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.xvalue;
		result = prime * result + this.yvalue;
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
		Location other = (Location) obj;
		return this.getXvalue() == other.getXvalue() && this.getYvalue() == other.getYvalue();
	}
	
}