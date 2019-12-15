package field;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
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
import sharedObject.IRenderableHolder;

public class DiceField extends Field {

	public DiceField() {
		super();
//		setBorder(new Border(
//				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundImage(IRenderableHolder.boardBackground, BackgroundRepeat.NO_REPEAT,
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
				int point = Dice.roll();
				System.out.println(point);
				if (LogicGame.getChangeTurn()) {
					int n = Main.getGameScene().getLogDisplay().getSize();
					int m = LogicGame.getPlayers().indexOf(LogicGame.getNowPlayer());
					Main.getGameScene().getLogDisplay()
							.add(String.format("%d: Player %d has roll a dice and get %d point.", n + 1, m + 1, point));
					LogicGame.getPlayers().get(LogicGame.getTurnPlayer()).moveTo(point);
					LogicGame.setChangeTurn(false);
				}
			}

		});
		GridPane center = new GridPane();
		center.add(roll, 5, 5);
		setCenter(center);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eventAction() {
		// TODO Auto-generated method stub

	}
}
