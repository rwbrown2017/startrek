package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.*
;
public class TestSector {

	Sector sector;
	
	@Before
	public void init() {
		sector = new Sector();
	}
	
	@Test
	public void canCreateSector() {
		assertNotNull(sector);
	}

	@Test
	public void shipVisitsSector() {
		assertFalse(sector.hasShip());
		sector.shipArrived();
		assertTrue(sector.hasShip());
		sector.shipDeparted();
		assertFalse(sector.hasShip());
	}
}
