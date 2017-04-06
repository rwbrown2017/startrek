package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.*;

public class ShipTest {
	Ship ship;
	Shield shield;
	
	@Before
	public void init() {
		ship = new Ship();
		shield = new Shield();
	}
	
	@Test
	public void getInitialReservedEnergy() {		
		assertTrue(ship.getReservedEnergy() == 100000);
	}

}
