package UI;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import application.Game;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;;

public class StartScene {

	private static int state = 0;
	public static StartScene scene;
	private Scene sc;

	static {
		scene = new StartScene();
	}

	public StartScene() {
		Button start_button = new Button("START");
		start_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				ContextMenu context = new ContextMenu();
				MenuItem onePlayer = new MenuItem("1 Player");
				MenuItem twoPlayer = new MenuItem("2 Players");
				MenuItem threePlayer = new MenuItem("3 Players");
				MenuItem fourPlayer = new MenuItem("4 Players");
				context.getItems().addAll(onePlayer, twoPlayer, threePlayer, fourPlayer);
				start_button.setContextMenu(context);
				context.show(start_button, Side.BOTTOM, 0, 0);
				System.out.println("YEAH");
			}
		});
		BorderPane firstPane = new BorderPane();
		firstPane.setCenter(start_button);
		sc = new Scene(firstPane, Game.displayX, Game.displayY);
	}

	public static void update() {
		switch (state) {

		}
	}

	public Scene getSc() {
		return sc;
	}

}
