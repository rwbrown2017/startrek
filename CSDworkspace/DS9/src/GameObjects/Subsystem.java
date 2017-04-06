package GameObjects;

public class Subsystem {

	private boolean damaged;

	public Subsystem() {
		damaged = false;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public boolean isDamaged() {
		return damaged;
	}
}
