package GameObjects;

public class Shield {

	private boolean down = true;
	private int shieldEnergy; 
	public boolean isDown() {
		return down;
	}

	public void raise() {
		down = false;
	}
	
	public void addShieldEnergy(int energy){		
		   shieldEnergy +=energy;
		   shieldEnergy = Integer.min(shieldEnergy, 10000);
	}
	
	public int getShieldEnergy(){
		return shieldEnergy;
	}
}
