
public class Dot {
	private int yCord;
	private int xCord;
	private int ID;
	private static int numOfDots;
	
	public Dot(int x, int y){
		yCord = y;
		xCord = x;
		
		ID = numOfDots;
		numOfDots++;
	}
	
	public int getY(){
		return yCord;
	}
	
	public int getX(){
		return xCord;
	}
	
	public int getID(){
		return ID;
	}
	
	public static int getNumOfDots(){
		return numOfDots;
	}
}
