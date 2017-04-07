package GameObjects;


public class Location {
	private Quadrant quadrant ;
	private Sector sector;
	public Location(Quadrant q, Sector s){
		this.quadrant = q;
		this.sector = s ;
	}
	public Quadrant getQuadrant(){
		return this.quadrant;
	}

	public Sector getSector(){
		return this.sector;
	}

	public void setQuadrant(Quadrant q){
		this.quadrant = q;
	}

	public void setSector(Sector s){
		this.sector = s;
	}
}
