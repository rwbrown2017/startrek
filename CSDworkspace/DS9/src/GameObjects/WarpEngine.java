package GameObjects;

public class WarpEngine extends Engine{
	private Location currentLoc;
	
	public WarpEngine(int q, int s){
		this.currentLoc.setQuadrant(q);
		this.currentLoc.setSector(s);
	}
	public Location getLocation(){
		return this.currentLoc;
	}
}
