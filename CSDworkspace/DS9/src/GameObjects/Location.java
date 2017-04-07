package GameObjects;
 

public class Location {
	private int quadrant ;
	private int sector;
	public Location(int q, int s){
		this.quadrant = q;
		this.sector = s ;
	}
	public int getQuadrant(){
		return this.quadrant;
	}
	
	public int getSector(){
		return this.sector;
	}	
	
	public void setQuadrant(int q){
		this.quadrant = q;
	}
	
	public void setSector(int s){
		this.sector = s;
	}
}
