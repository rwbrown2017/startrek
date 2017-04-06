package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.Shield;
import GameObjects.Ship;

public class TestShields {
	
	Shield shield;
	
	@Before
	public void init() {
		shield = new Shield();
	}
	
	@Test
	public void shieldsStartOutLowered() {		
		assertTrue(shield.isDown());
	}
	
	@Test
	public void shieldsGoesUp() {
		shield.raise();
		assertFalse(shield.isDown());
	}

	@Test
	public void shieldsCanToggle() {
		shield.raise();
		assertFalse(shield.isDown());
		shield.lower();
		assertTrue(shield.isDown());
	}
	
	@Test
	public void shieldsStartingAmount() {
		assertEquals(10000, shield.getShieldEnergy());
	}

	@Test
	public void addShieldEnergy(){
		shield.removeShieldEnergy(1000);
		shield.addShieldEnergy(500);
		assertEquals(9500, shield.getShieldEnergy());
	}

	@Test
	public void removeShieldEnergy() {
		shield.removeShieldEnergy(1);
		assertEquals(9999, shield.getShieldEnergy());

	@Test
	public void underchargeShields() {
		shield.removeShieldEnergy(10001);
		assertEquals(0, shield.getShieldEnergy());
	}
	
	@Test
	public void overchargedShields(){
		shield.addShieldEnergy(1);
		assertEquals(10000, shield.getShieldEnergy());
	}
	
	@Test
	public void shieldStartsNotBuckled() {
		assertFalse(shield.isBuckled());
	}
	
	@Test
	public void shieldBuckled() {
		shield.raise();
		shield.hit(10001);
		assertTrue(shield.isBuckled());
	}

}
