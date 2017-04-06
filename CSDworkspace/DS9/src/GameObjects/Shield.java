package GameObjects;

public class Shield {

	private boolean down = true;
	private static int reservedEnergy = 10000;
	private Ship ship;
	
	public Shield(Ship ship) {
		this.reservedEnergy = 10000;
		this.ship = ship;
	}

	public boolean isDown() {
		return down;
	}

	public void raise() {
		down = false;
	}

	public boolean isBuckled() {
		return reservedEnergy <= 0;
	}

	public void buckle() {
		reservedEnergy = 0;
	}

	public void hit(int i) {
		if (!isDown())
		reservedEnergy -= i;
	}

}
