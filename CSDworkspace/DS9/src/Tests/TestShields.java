package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import GameObjects.Shield;
import GameObjects.Ship;

public class TestShields {
	
	Shield shield;
	Ship ship;
	
	@Before
	public void init() {
		shield = new Shield();
		ship = new Ship();
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
	public void shieldStartsNotBuckled() {
		assertFalse(shield.isBuckled());
	}
	
	@Test
	public void shieldBuckled() {
		shield.buckle();
		assertTrue(shield.isBuckled());
	}
	
	public void shipDamagedAfterBuckledShieldHit() {
		shield.buckle();
		shield.hit(1);
		assertTrue(ship.isDamaged());
	}
}
