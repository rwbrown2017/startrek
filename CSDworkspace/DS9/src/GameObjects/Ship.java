package GameObjects;

public class Ship {
	private static int reservedEnergy = 100000;
	
	public int getReservedEnergy(){
		return reservedEnergy;
	}
	
	
	public int transferEnergy(int n){
		reservedEnergy -=n ;
		return n;
	}
}
