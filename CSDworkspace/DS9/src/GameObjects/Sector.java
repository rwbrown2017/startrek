package GameObjects;

public class Sector {

	private boolean hasShip;
	
	public boolean hasShip() {
		return this.hasShip;
	}
	
	public void shipArrived() {
		this.hasShip = true;
	}

	public void shipDeparted() {
		this.hasShip = false;
	}
}
