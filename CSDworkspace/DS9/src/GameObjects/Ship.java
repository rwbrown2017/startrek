package GameObjects;

import java.util.HashMap;

public class Ship {
	
	private static int reservedEnergy = 100000;
	private boolean damaged = false;
	private boolean functioning = true;
	private boolean repaired = false;
	
	HashMap<String, Subsystem> subsystems;
	
	public Ship (){
		subsystems = new HashMap<String, Subsystem>();
		addSubsystems();
	}
	
	public void addSubsystems() {
		subsystems.put("shield", new Shield());
		subsystems.put("engine", new Engine());
	}
	
	public Shield getShield() {
		return (Shield) getSubsystem("shield");
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
	
	public int getReservedEnergy() {
		return reservedEnergy;
	}
	
	public int transferEnergy(int n) {
		reservedEnergy -= n;
		return n;
	}
	
	public void hit(int i) {
		damaged = true;
	}

	private Subsystem getSubsystem(String string) {
		return subsystems.get(string);
	}

	public Object getEngine() {
		return (Engine) getSubsystem("engine");
	}
	
}

