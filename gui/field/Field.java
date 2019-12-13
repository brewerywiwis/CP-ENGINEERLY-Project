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

	public void recievePlayer(Player player) {
		players.add(player);
	};

	public void removePlayer(Player player) {
		players.remove(player);
	}

}
