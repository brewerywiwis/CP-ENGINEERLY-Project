package logic;

import gameScene.BoardUI;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderableHolder;

public class Board {

	private GraphicsContext gc;

	public final static int[][] instance = new int[][] { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, };

	// 0 is .....
	// 1 is .....
	// ...
	// for each integer is representing to some building

	public Board(GraphicsContext gc) {
		this.gc = gc;
		IRenderableHolder.getInstance().getEntities().add(new BoardUI());
	}

	public void resetBoard() {
	}
}
