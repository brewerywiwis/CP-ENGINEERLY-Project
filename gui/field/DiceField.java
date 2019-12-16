package field;

import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import logic.Dice;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class DiceField extends Field {

	public DiceField() {
		super();
//		setBorder(new Border(
//				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundImage(SharedObjectHolder.boardBackground, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));

		Button roll = new Button("ROLL!");
		roll.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("MOUSE PRESSED ROLL BUTTON");
			}

		});
		roll.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("MOUSE RELEASED ROLL BUTTON");
				if (!Main.isGameStop()) {
					int point = Dice.roll();
					if (LogicGame.getChangeTurn()) {
						int n = Main.getGameScene().getLogDisplay().getSize();
						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s has roll a dice and get %d point.", n + 1,
										LogicGame.getNowPlayer().getName(), point));
						LogicGame.getPlayers().get(LogicGame.getTurnPlayer()).moveTo(point);
						LogicGame.setChangeTurn(false);
					}
				}
			}

		});
		Button stop = new Button("STOP!");
		stop.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				if (Main.isGameStop()) {
					Main.startGame();
				} else {
					Main.stopGame();
				}
			}
		});
		GridPane center = new GridPane();
		center.add(roll, 5, 5);
		center.add(stop, 5, 6);
		setCenter(center);
	}

	@Override
	public void eventAction() {
		// TODO Auto-generated method stub

	}
}
