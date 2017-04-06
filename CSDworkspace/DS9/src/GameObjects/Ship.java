package GameObjects;

public class Ship {

	private boolean damaged = false;
	private boolean functioning = true;
	private boolean repaired = false;
	
	public boolean isDamaged() {
		return damaged;
	}
	
	public boolean isFunctioning() {
		return functioning;
	}
	
	public boolean isRepaired() {
		return repaired;
	}
}
