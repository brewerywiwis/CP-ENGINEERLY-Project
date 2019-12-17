package field;

import java.util.ArrayList;

import application.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Dice;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class DiceField extends VBox {

	private StackPane diceFacePane;
	private ArrayList<Image> diceFaces;
	private ImageView diceFace;
	private final double width = 140;
	private final double height = 140;

	public DiceField() {
		super();
		diceFaces = new ArrayList<Image>();
		diceFaces.add(SharedObjectHolder.diceOne);
		diceFaces.add(SharedObjectHolder.diceTwo);
		diceFaces.add(SharedObjectHolder.diceThree);
		diceFaces.add(SharedObjectHolder.diceFour);
		diceFaces.add(SharedObjectHolder.diceFive);
		diceFaces.add(SharedObjectHolder.diceSix);

		diceFacePane = new StackPane();
		diceFacePane.setMaxWidth(width);
		diceFacePane.setMaxHeight(height);
		diceFacePane.setMinWidth(width);
		diceFacePane.setMinHeight(height);
		diceFacePane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
		diceFacePane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		diceFace = new ImageView();
		diceFace.setFitHeight(140);
		diceFace.setFitWidth(140);
		diceFacePane.getChildren().add(diceFace);

		Button roll = new Button();
		roll.setStyle("-fx-background-color: transparent");
		roll.setGraphic(new ImageView(SharedObjectHolder.pullRoll));

		roll.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("MOUSE PRESSED ROLL BUTTON");
				roll.setGraphic(new ImageView(SharedObjectHolder.pushRoll));
			}

		});

		roll.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("MOUSE RELEASED ROLL BUTTON");
				roll.setGraphic(new ImageView(SharedObjectHolder.pullRoll));
				if (!Main.isGameStop()) {
					int point = Dice.roll();
					if (LogicGame.getChangeTurn()) {
						int n = Main.getGameScene().getLogDisplay().getSize();
						diceFace.setImage(diceFaces.get(point - 1));
						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s has roll a dice and get %d point.", n + 1,
										LogicGame.getNowPlayer().getName(), point));
						LogicGame.getPlayers().get(LogicGame.getTurnPlayer()).moveTo(1);
						LogicGame.setChangeTurn(false);
					}
				}
			}

		});

		getChildren().addAll(diceFacePane, roll);
		setBackground(new Background(new BackgroundImage(SharedObjectHolder.boardBackground, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
		setAlignment(Pos.CENTER);
		setSpacing(100);
	}

}
