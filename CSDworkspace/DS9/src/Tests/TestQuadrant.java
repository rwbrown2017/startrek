package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.*
;
public class TestQuadrant {

	Quadrant quadrant = new Quadrant();
	
	@Before
	public void init() {
		quadrant = new Quadrant();
	}
	
	@Test
	public void canCreateQuadrant() {
		assertNotNull(quadrant);
	}
	
	@Test
	public void canGetSector() {
		Sector sector = quadrant.getSector(1,1);
		assertNotNull(sector);
	}
	
	@Test
	public void cantGetBadSector() {
		Sector sector = quadrant.getSector(10,10);
		assertNull(sector);
	}


}
