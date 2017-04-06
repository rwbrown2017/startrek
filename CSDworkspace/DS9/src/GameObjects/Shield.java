package GameObjects;

public class Shield {

	private boolean down = true;
	private static int shieldEnergy = 10000;
	
	public Shield() {
		this.shieldEnergy = 10000;
	}

	public boolean isDown() {
		return down;
	}

	public void raise() {
		down = false;
	}

	public boolean isBuckled() {
		return shieldEnergy <= 0;
	}

	public void buckle() {
		shieldEnergy = 0;
	}

	public void hit(int i) {
		shieldEnergy = Integer.min(0, shieldEnergy - i);
	}

}
