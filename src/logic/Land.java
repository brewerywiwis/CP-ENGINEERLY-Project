package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Land extends Asset {

	private int houses;
	private int hotel;

	private static HashMap<Integer, ArrayList<Land>> PlayerToLands;

	static {
		PlayerToLands = new HashMap<Integer, ArrayList<Land>>();
	}

	public Land(String name, int price) {
		super(name, price);
		this.houses = 0;
		this.hotel = 0;
	}

	public int getHouses() {
		return houses;
	}

	public int getHotel() {
		return hotel;
	}

	@Override
	public boolean buyFrom(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}


}
