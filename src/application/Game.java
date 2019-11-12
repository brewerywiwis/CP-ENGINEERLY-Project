package application;

import java.util.Random;

import gameScene.BoardUI;
import javafx.scene.canvas.GraphicsContext;
import logic.Board;

public class Game {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	private GraphicsContext gc;
	private Board board;

	public Game(GraphicsContext gc) {
		board = new Board(gc);
	}
//	@Override
//	public void init() {
//		state = StateScene.STARTSCENE;
//		roll = new Button("ROLL");
//		roll.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent arg0) {
//				Random random = new Random();
//				int randomInt = random.nextInt(6) + 1;
//				System.out.println(randomInt);
//			}
//		});
//	}

}
