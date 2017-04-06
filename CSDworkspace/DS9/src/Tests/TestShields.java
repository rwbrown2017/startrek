package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import GameObjects.Shield;
import GameObjects.Ship;

public class TestShields {

	@Test
	public void shieldsStartOutLowered() {
		Shield shield = new Shield();
		assertTrue(shield.isDown());
	}
	
	@Test
	public void shieldsGoesUp() {
		Shield shield = new Shield();
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
	
	
}
