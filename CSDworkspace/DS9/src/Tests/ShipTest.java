package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjects.*;

public class ShipTest {
	
	@Test
	public void getInitialReservedEnergy() {
		Ship aShip = new Ship();
		assertTrue(aShip.getReservedEnergy() == 10000);
	}

}
