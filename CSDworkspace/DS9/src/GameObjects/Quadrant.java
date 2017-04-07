package GameObjects;

public class Quadrant {

	private static final int MAXROWS = 10;
	private static final int MAXCOLUMNS = 10;
	
	Sector[][] sector = new Sector[MAXROWS][MAXCOLUMNS];
	
	public Quadrant() {
		initializeSectors();
	}
	
	public Sector getSector(int row, int column) {
		
		try
		{
			return sector[row][column];
		} catch(ArrayIndexOutOfBoundsException e) { 
			//TODO: what is a better resolution?
			return null;
		}
	}
	
	private void initializeSectors() {
		for (int r=0;r<MAXROWS;r++) {
			for (int c=0;c<MAXCOLUMNS;c++) {
				sector[r][c] = new Sector();
			}
		}
			
	}

}
