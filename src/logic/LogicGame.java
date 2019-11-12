package logic;

import java.util.ArrayList;

import sharedObject.IRenderableHolder;

public class LogicGame {

	private static int turnPlayer = 1;
	private ArrayList<Player> players;
	
	public LogicGame() {
		
	}
	public static void update() {
		for (int i = 0; i < IRenderableHolder.getInstance().getEntities().size(); i++) {
			IRenderableHolder.getInstance().getEntities().get(i).draw(gc);
		}
		switch (turnPlayer) {
		case 1: {
			
		}
		}
		
	}
}
