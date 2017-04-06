package GameObjects;

public class Shield {

	private boolean down = true;
	private boolean buckled = false;
	
	public boolean isDown() {
		return down;
	}

	public void raise() {
		down = false;
	}

	public boolean isBuckled() {
		return buckled;
	}

	public void buckle() {
		buckled = true;
	}

	public void hit(int i) {
		// TODO Auto-generated method stub
		
	}

}
