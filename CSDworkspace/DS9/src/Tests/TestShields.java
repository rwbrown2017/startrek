package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import GameObjects.Shield;

public class TestShields {
	
	Shield shield;
	
	@Before
	public void init() {
		shield = new Shield();
	}
	
	@Test
	public void minShieldEnergy() {
		assertEquals(0, Shield.MIN_SHIELD_ENERGY);
	}
	
	@Test
	public void maxShieldEnergy() {
		assertEquals(10000, Shield.MAX_SHIELD_ENERGY);
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
		assertEquals(Shield.MAX_SHIELD_ENERGY, shield.getShieldEnergy());
	}

	@Test
	public void addShieldEnergy(){
		shield.removeShieldEnergy(1000);
		shield.addShieldEnergy(500);
		assertEquals(Shield.MAX_SHIELD_ENERGY-500, shield.getShieldEnergy());
	}

	@Test
	public void removeShieldEnergy() {
		shield.removeShieldEnergy(1);
		assertEquals(Shield.MAX_SHIELD_ENERGY-1, shield.getShieldEnergy());
	}
	
	@Test
	public void underchargeShields() {
		shield.removeShieldEnergy(Shield.MAX_SHIELD_ENERGY+1);
		assertEquals(Shield.MIN_SHIELD_ENERGY, shield.getShieldEnergy());
	}
	
	@Test
	public void overchargedShields(){
		shield.addShieldEnergy(1);
		assertEquals(Shield.MAX_SHIELD_ENERGY, shield.getShieldEnergy());
	}
	
	@Test
	public void shieldStartsNotBuckled() {
		assertFalse(shield.isBuckled());
	}
	
	@Test
	public void shieldBuckled() {
		shield.raise();
		shield.hit(Shield.MAX_SHIELD_ENERGY+1);
		assertTrue(shield.isBuckled());
	}

}
