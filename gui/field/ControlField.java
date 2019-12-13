package field;

import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import logic.Dice;
import sharedObject.IRenderableHolder;

public class ControlField extends Field {
	public ControlField() {
		// TODO Auto-generated constructor stub
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
				// TODO Auto-generated method stub
				System.out.println("MOUSE PRESSED ROLL BUTTON");
			}

		});
		roll.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("MOUSE RELEASED ROLL BUTTON");
				int r = Dice.roll();
				System.out.println(Dice.roll() + Dice.roll());
			}

		});
		GridPane center = new GridPane();
		center.add(roll, 5, 5);
		setCenter(center);
		ImageView im = new ImageView();
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
}
