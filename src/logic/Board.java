package logic;

public class Board {

	int[][] instance;
	
	//0 is .....
	//1 is .....
	//...
	// for each integer is representing to some building
	
	public Board() {
		instance = new int[][] {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		};
	}
}
