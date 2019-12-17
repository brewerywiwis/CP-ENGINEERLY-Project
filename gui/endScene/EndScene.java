package endScene;

import application.Main;
import application.StateScene;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class EndScene extends Scene {

	public static EndScene scene;
	private static BorderPane pane;
	static {
		pane = new BorderPane();
		scene = new EndScene(pane, Main.displayX, Main.displayY);
	}

	public EndScene(Parent p, double w, double h) {
		super(p, w, h);
		// TODO Auto-generated constructor stub
		VBox vBox = new VBox();
		ImageView img = new ImageView(SharedObjectHolder.trophy);
		Text txt = new Text("Player " + LogicGame.getWinnerName() + " is Winner!!!");
		txt.setFont(new Font(40));
		Button retryBt = new Button("RETRY");
		retryBt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Main.setState(StateScene.SWAPSTARTSCENE);
			}
		});
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(img, txt, retryBt);
		pane.setCenter(vBox);
		pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
	}

}
