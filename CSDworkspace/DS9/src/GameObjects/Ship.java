package GameObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ship {
	
	private static int reservedEnergy = 100000;
	private boolean damaged = false;
	private boolean functioning = true;
	private boolean repaired = false;
	
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
		subsystems.put("shield", new Shield());
		subsystems.put("engine", new Engine());
	}
	
	private Subsystem getSubsystem(String string) {
		return subsystems.get(string);
	}
	
	private Subsystem getSubsystemByIndex(int index) {
		int count = 0;
		for (Map.Entry<String, Subsystem> entry : subsystems.entrySet()) {
		    String key = entry.getKey();
		    Subsystem value = entry.getValue();
		    if (count == index) {
		    	return value;
		    }
		    count++;
		}
		return null;
	}

	public Object getEngine() {
		return (Engine) getSubsystem("engine");
	}
	
	public Shield getShield() {
		return (Shield) getSubsystem("shield");
	}
	
	public boolean isDamaged() {
		for (Map.Entry<String, Subsystem> entry : subsystems.entrySet()) {
		    String key = entry.getKey();
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
	
	public int transferEnergy(int n) {
		reservedEnergy -= n;
		getShield().addShieldEnergy(n);
		return n;
	}
	
	public void hit(int i) {
		Shield shield = getShield();
		if (shield.isDown() || shield.isBuckled()) {
			damageRandomSubsystem();
		} else {
			shield.hit(i);
		}
	}

	private void damageRandomSubsystem() {
		Subsystem subsystem = getRandomSubsystem();
		subsystem.setDamaged(true);
	}

	public Subsystem getRandomSubsystem() {
		int subsystemNumber = randomEngine.getRandomNumber(subsystems.size());
		return getSubsystemByIndex(subsystemNumber - 1);
	}
	
}

