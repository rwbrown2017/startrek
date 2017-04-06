package Tests;

import GameObjects.RandomizationEngine;

public class RandomizationEngineForTestingOnly extends RandomizationEngine {

	private int number;
	
	public RandomizationEngineForTestingOnly(int number) {
		this.number = number;
	}
	
	@Override
	public int getRandomNumber(int max) {
		return number;
	}
	
}
