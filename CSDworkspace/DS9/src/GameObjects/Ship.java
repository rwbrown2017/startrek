package GameObjects;

public class Ship {

	private boolean damaged = false;
	private boolean functioning = true;
	private boolean repaired = false;
	private Shield shield;
	
	public Ship() {
		shield = new Shield();
	}
	
	public boolean isDamaged() {
		return damaged;
	}
	
	public boolean isFunctioning() {
		return functioning;
	}
	
	public boolean isRepaired() {
		return repaired;
	}

	public Shield getShield() {
		return shield;
	}

	public void hit(int i) {
		damaged = true;
	}
}
