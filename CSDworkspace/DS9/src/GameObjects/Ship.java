package GameObjects;

public class Ship {
	private static int reservedEnergy = 100000;
	private boolean damaged = false;
	private boolean functioning = true;
	private boolean repaired = false;
	
	private Shield shield;
	
	public Shield getShield() {
		return shield;
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
	
	public int getReservedEnergy(){
		return reservedEnergy;
	}
	
	public int transferEnergy(int n){
		reservedEnergy -=n ;
		return n;
	}
	
	public void hit(int i) {
		damaged = true;
	}
}

