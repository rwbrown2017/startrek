package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import GameObjects.*;

public class TestLocation {
	
	private Location curLoc = new Location(new Quadrant(), new Sector());

	@Test
	public void testGetQuadrant() {
		Quadrant quadrant = curLoc.getQuadrant();
		assertEquals(quadrant,4);
	}

	@Test
	public void testGetSector() {
		Sector sector = curLoc.getSector();
		assertEquals(sector,5);
	}

}
