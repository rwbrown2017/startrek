package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjects.*
;
public class TestGalaxy {

	Galaxy galaxy = new Galaxy();
	
	//@Before
	//public void init() {
		//galaxy = new Galaxy();
	//}
	
	@Test
	public void canCreateGalaxy() {
		assertNotNull(galaxy);
	}

	@Test
	public void canGetQuadrant() {
		Quadrant quadrant = galaxy.getQuadrant(1,1);
		assertNotNull(quadrant);
	}
	
	@Test
	public void cantGetBadQuadrant() {
		Quadrant quadrant = galaxy.getQuadrant(9,9);
		assertNull(quadrant);
	}

}
