package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.Ship;

public class TestShip {
	

	Ship ship = new Ship();


	@Test
	public void shipDamaged() {
		assertFalse(ship.isDamaged());
	}

	@Test
	public void shipFunctioning() {
		assertTrue(ship.isFunctioning());
	}

	@Test
	public void shipRepaired() {
		assertFalse(ship.isRepaired());
	}

}
