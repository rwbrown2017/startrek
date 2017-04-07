package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Errors.InsufficientEnergyException;
import Errors.SubsystemDamagedException;
import GameObjects.Engine;
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
	public void moveEnergyToShields() throws SubsystemDamagedException, InsufficientEnergyException {
		ship.getShield().raise();
		ship.hit(2000);
		ship.transferEnergy(1000);
		assertEquals(99000, ship.getReservedEnergy());
		assertEquals(9000, ship.getShield().getShieldEnergy());
	}
	
	@Test
	public void moveEnergyWithShieldsDamaged() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		ship.hit(1);
		try {
			ship.transferEnergy(1);
		} catch (SubsystemDamagedException e) {
			return;
		} catch (InsufficientEnergyException e) {
			// not expected
		}
		fail();
	}
	
	@Test
	public void moveEnergyInsufficient() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		Shield shield = ship.getShield();
		shield.raise();
		try {
			// use all the reserved energy
			for (int i = 0; i < 10; i++) {
				ship.hit(Shield.MAX_SHIELD_ENERGY);
				ship.transferEnergy(Shield.MAX_SHIELD_ENERGY);
			}
			ship.hit(1);
			ship.transferEnergy(1);
		} catch (SubsystemDamagedException e) {
			// not expected
		} catch (InsufficientEnergyException e) {
			return;
		}
		fail();
	}
	
	@Test
	public void setRandomizer() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(7));
		assertEquals(7, ship.getRandomizationEngine().getRandomNumber(10));
	}
	
	@Test
	public void getRandomSubsystemEngine() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(2));
		assertEquals(ship.getEngine(), ship.getRandomSubsystem());
	}
	
	@Test
	public void getRandomSubsystemShield() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		assertEquals(ship.getShield(), ship.getRandomSubsystem());
	}
	
	@Test
	public void shipHitShieldBuckledSomeSubsystemDamaged() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(2));
		ship.getShield().raise();
		ship.hit(Shield.MAX_SHIELD_ENERGY+1);
		assertTrue(ship.isDamaged()); // It is Engine
	}
	
	@Test
	public void shipHitShieldBuckledShieldSubsystemDamaged() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		ship.getShield().raise();
		ship.hit(Shield.MAX_SHIELD_ENERGY+1);
		Shield shield = ship.getShield();
		assertTrue(shield.isDamaged());
	}
	
	@Test
	public void shipHitShieldBuckledEngineSubsystemDamaged() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(2));
		ship.getShield().raise();
		ship.hit(Shield.MAX_SHIELD_ENERGY+1);
		Engine engine = ship.getEngine();
		assertTrue(engine.isDamaged());
	}
	
	@Test
	public void shieldWontRaiseIfDamaged() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		Shield shield = ship.getShield();
		shield.raise();
		ship.hit(Shield.MAX_SHIELD_ENERGY+1);
		shield.raise();
		assertTrue(shield.isDown());
	}
	
	@Test
	public void repairDamagedSubsystem() {
		ship.setRandomizationEngine(new RandomizationEngineForTestingOnly(1));
		Shield shield = ship.getShield();
		shield.raise();
		ship.hit(Shield.MAX_SHIELD_ENERGY+1);
		shield.raise();
		assertTrue(shield.isDown());
		shield.repair();
		shield.raise();
		assertFalse(shield.isDown());
	}
	
}
