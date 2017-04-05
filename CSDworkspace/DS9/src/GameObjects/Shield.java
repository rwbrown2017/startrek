package GameObjects;

public class Shield {

	private boolean down = true;
	
	public boolean isDown() {
		return down;
	}

	public void raise() {
		down = false;
	}

}
