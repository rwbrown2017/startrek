package GameObjects;

public class RandomizationEngine {
	
	public int getRandomNumber(int max) {
		int min = 1;
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
}
