package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import GameObjects.Shield;

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
}
