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
	public void chargeShields(){
		Shield shield = new Shield();
		shield.addShieldEnergy(10000);
		assertTrue(shield.getShieldEnergy() == 10000);
	}
	
	@Test
	public void overchargedShields(){
		Shield shield = new Shield();
		shield.addShieldEnergy(20000);
		assertTrue(shield.getShieldEnergy() == 10000);
		
	}
	

	public void shieldStartsNotBuckled() {
		assertFalse(shield.isBuckled());
	}
	
	@Test
	public void shieldBuckled() {
		shield.buckle();
		assertTrue(shield.isBuckled());
	}

}
