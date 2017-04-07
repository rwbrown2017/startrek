package GameObjects;

public class Galaxy {

	private static final int MAXROWS = 8;
	private static final int MAXCOLUMNS = 8;
	
	Quadrant[][] quadrant = new Quadrant[MAXROWS][MAXCOLUMNS];
	
	public Galaxy() {
		initializeQuadrants();
	}
	
	public Quadrant getQuadrant(int row, int column) {
		
		try
		{
			return quadrant[row][column];
		} catch(ArrayIndexOutOfBoundsException e) { 
			//TODO: what is a better resolution?
			return null;
		}
	}
	
	private void initializeQuadrants() {
		for (int r=0;r<MAXROWS;r++) {
			for (int c=0;c<MAXCOLUMNS;c++) {
				quadrant[r][c] = new Quadrant();
			}
		}
			
	}
	
}
