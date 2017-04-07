package GameObjects;

import java.util.LinkedHashMap;
import java.util.Map;

import Errors.InsufficientEnergyException;
import Errors.SubsystemDamagedException;
import Util.RandomizationEngine;

public class Ship extends Entity {
	
	public static final int MIN_SHIP_ENERGY = 0;
	public static final int MAX_SHIP_ENERGY = 100000;
	private static int reservedEnergy = MAX_SHIP_ENERGY;
	private boolean functioning = true;
	private boolean repaired = false;
	
	private Location currentLoc;
	
	LinkedHashMap<String, Subsystem> subsystems;
	RandomizationEngine randomEngine;
	
	public Ship() {
		subsystems = new LinkedHashMap<String, Subsystem>();
		addSubsystems();
		randomEngine = new RandomizationEngine();
	}
	
	public RandomizationEngine getRandomizationEngine() {
		return randomEngine;
	}

	public void setRandomizationEngine(RandomizationEngine randomEngine) {
		this.randomEngine = randomEngine;
	}

	public void addSubsystems() {
		subsystems.put("shield", new Shield()); // Index: 0
		subsystems.put("engine", new Engine()); // Index: 1
	}
	
	private Subsystem getSubsystem(String string) {
		return subsystems.get(string);
	}
	
	private Subsystem getSubsystemByIndex(int index) {
		int count = 0;
		for (Map.Entry<String, Subsystem> entry : subsystems.entrySet()) {
		    //String key = entry.getKey();
		    Subsystem value = entry.getValue();
		    if (count == index) {
		    	return value;
		    }
		    count++;
		}
		return null;
	}

	public Engine getEngine() {
		return (Engine) getSubsystem("engine");
	}
	
	public Shield getShield() {
		return (Shield) getSubsystem("shield");
	}
	
	public boolean isDamaged() {
		for (Map.Entry<String, Subsystem> entry : subsystems.entrySet()) {
		    //String key = entry.getKey();
		    Subsystem value = entry.getValue();
		    if (value.isDamaged()) {
		    	return true;
		    }
		}
		return false;
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
	
	public int transferEnergy(int n) throws SubsystemDamagedException, InsufficientEnergyException {
		Shield shield = getShield();
		if (shield.isDamaged()) {
			throw new SubsystemDamagedException();
		}
		if (reservedEnergy < n) {
			throw new InsufficientEnergyException();
		}
		reservedEnergy -= n;
		reservedEnergy = Integer.max(reservedEnergy, MIN_SHIP_ENERGY);
		shield.addShieldEnergy(n);
		return n;
	}
	
	public void hit(int i) {
		Shield shield = getShield();
		if (shield.isDown() || shield.isBuckled()) {
			damageRandomSubsystem();
		} else {
			if (shield.hit(i) < 0) {
				damageRandomSubsystem();
			}
		}
	}

	private void damageRandomSubsystem() {
		Subsystem subsystem = getRandomSubsystem();
		subsystem.setDamaged(true);
	}

	public Subsystem getRandomSubsystem() {
		int subsystemNumber = randomEngine.getRandomNumber(subsystems.size());
		Subsystem subsystem = getSubsystemByIndex(subsystemNumber - 1);
		return subsystem;
	}
	
	public Location getLocation(){
		return this.currentLoc;
	}
	
}

