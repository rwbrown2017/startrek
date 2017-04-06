package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.Ship;

public class TestShip {
	
	Ship ship;
	
	@Before
	public void init() {
		ship = new Ship();
	}

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
	
	@Test
	public void shipHitShieldBuckledSubsystemDamaged() {
		ship.getShield().removeShieldEnergy(10001);
		ship.hit(1);
		assertTrue(ship.isDamaged());
	}

	@Test
	public void getInitialReservedEnergy() {
		assertEquals(100000, ship.getReservedEnergy());
	}
	
	@Test
	public void shieldSubsystemExists() {
		assertNotNull(ship.getShield());
	}
	
	@Test
	public void engineSubsystemExists() {
		assertNotNull(ship.getEngine());
	}
	
}
