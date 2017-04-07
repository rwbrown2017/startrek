package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import GameObjects.RandomizationEngine;
import GameObjects.Shield;
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
	
	@Test
	public void moveEnergyToShields() {
		ship.getShield().raise();
		ship.hit(2000);
		ship.transferEnergy(1000);
		assertEquals(99000, ship.getReservedEnergy());
		assertEquals(9000, ship.getShield().getShieldEnergy());
	}
	
	@Test
	public void setRandomizer() {
		RandomizationEngine engine = new RandomizationEngineForTestingOnly(7);
		ship.setRandomizationEngine(engine);
		assertEquals(7, ship.getRandomizationEngine().getRandomNumber(10));
	}
	
	public void getRandomSubsystem() {
		RandomizationEngine engine = new RandomizationEngineForTestingOnly(2);
		ship.setRandomizationEngine(engine);
		assertEquals(ship.getEngine(), ship.getRandomSubsystem());
	}
	
	@Test
	public void shipHitShieldBuckledSubsystemDamaged() {
		RandomizationEngine engine = new RandomizationEngineForTestingOnly(2);
		ship.setRandomizationEngine(engine);
		ship.getShield().raise();
		ship.hit(10001);
		ship.hit(1);
		assertTrue(ship.isDamaged());
	}
	
	@Test
	public void shieldWontRaiseIfDamaged() {
		RandomizationEngine engine = new RandomizationEngineForTestingOnly(1);
		ship.setRandomizationEngine(engine);
		Shield shield = ship.getShield();
		shield.raise();
		ship.hit(10001);
		ship.hit(1);
		shield.raise();
		assertTrue(shield.isDown());
	}
	
}
