package GameObjects;

public class Shield extends Subsystem {

	public static final int MIN_SHIELD_ENERGY = 0;
	public static final int MAX_SHIELD_ENERGY = 10000;

	private boolean down = true;
	
	private static int shieldEnergy = MAX_SHIELD_ENERGY;
	
	public Shield() {
		this.shieldEnergy = MAX_SHIELD_ENERGY;		
	}

	public boolean isDown() {
		return down;
	}

	public void raise() {
		if (!isDamaged()) {
			down = false;
		}
	}

	public void lower() {
		down = true;
	}
	
	public void addShieldEnergy(int energy){		
		   shieldEnergy += energy;
		   shieldEnergy = Integer.min(shieldEnergy, MAX_SHIELD_ENERGY);
	}

	public void removeShieldEnergy(int energy){		
		   shieldEnergy -= energy;
		   if (shieldEnergy <= 0) {
			   down = true;
		   }
		   shieldEnergy = Integer.max(shieldEnergy, MIN_SHIELD_ENERGY);
	}
	
	public int getShieldEnergy() {
		return shieldEnergy;
	}


	public boolean isBuckled() {
		return shieldEnergy <= MIN_SHIELD_ENERGY;
	}

	public void hit(int i) {
		removeShieldEnergy(i);
	}

}
