package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Island extends Asset {

	private static HashMap<Integer, ArrayList<Island>> PlayerToIslands;

	static {
		PlayerToIslands = new HashMap<Integer, ArrayList<Island>>();
	}

	public Island(String name, int price) {
		super(name, price);
	}

	@Override
	public boolean buyFrom(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean payFrom(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

}
