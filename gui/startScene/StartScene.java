package startScene;

import application.Main;
import application.StateScene;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;;

public class StartScene extends Scene {

	public static StartScene scene;
	private static BorderPane pane;
	static {
		pane = new BorderPane();
		scene = new StartScene(pane, Main.displayX, Main.displayY);
	}

	public StartScene(Parent p, double w, double h) {
		super(p, w, h);
		Button start_button = new Button("START");
		start_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				ContextMenu context = new ContextMenu();
//				MenuItem onePlayer = new MenuItem("1 Player");
//				MenuItem twoPlayer = new MenuItem("2 Players");
//				MenuItem threePlayer = new MenuItem("3 Players");
//				MenuItem fourPlayer = new MenuItem("4 Players");
//				context.getItems().addAll(onePlayer, twoPlayer, threePlayer, fourPlayer);
//				start_button.setContextMenu(context);
//				context.show(start_button, Side.BOTTOM, 0, 0);
				Main.setState(StateScene.GAMESCENE);
				System.out.println("YEAH");
			}
		});
		pane.setCenter(start_button);
	}

}
