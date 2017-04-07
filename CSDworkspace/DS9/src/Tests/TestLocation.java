package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import GameObjects.*;

public class TestLocation {
	private Location curLoc = new Location(4,5);
	
	@Test
	public void testGetQuadrant() {
		int quadrant = curLoc.getQuadrant();
		assertEquals(quadrant,4);
	}
	
	@Test
	public void testGetSector() {
		int sector = curLoc.getSector();
		assertEquals(sector,5);
	}

}
