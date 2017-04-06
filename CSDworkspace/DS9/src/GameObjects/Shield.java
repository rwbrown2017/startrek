package GameObjects;

public class Shield extends Subsystem {

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

	public void lower() {
		down = true;
	}
	
	public void addShieldEnergy(int energy){		
		   shieldEnergy += energy;
		   shieldEnergy = Integer.min(shieldEnergy, 10000);
	}

	public void removeShieldEnergy(int energy){		
		   shieldEnergy -= energy;
		   shieldEnergy = Integer.max(shieldEnergy, 0);
	}
	
	public int getShieldEnergy() {
		return shieldEnergy;
	}


	public boolean isBuckled() {
		return shieldEnergy <= 0;
	}

	public void hit(int i) {
		if (isDown() || isBuckled()) {
			setDamaged(true);
		} else {
			shieldEnergy = removeShieldEnergy(i);
		}
	}

}
