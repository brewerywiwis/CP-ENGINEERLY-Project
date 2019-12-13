package field;

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import logic.Player;
import sharedObject.IRenderable;

public abstract class Field extends BorderPane implements IRenderable {
	private ArrayList<Player> players;

	public Field() {
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	};

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean hasPlayer() {
		return players.size() > 0 ? true : false;
	}

	public void update() {
		if (hasPlayer()) {
			for (int i = 0; i < players.size(); i++) {
				
			}
		}
	}
}
