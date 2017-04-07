package GameObjects;

public class WarpEngine extends Engine{
	private Location currentLoc;

	public WarpEngine(Quadrant q, Sector s){
		this.currentLoc.setQuadrant(q);
		this.currentLoc.setSector(s);
	}

	public Location getLocation(){
		return this.currentLoc;
	}


}
