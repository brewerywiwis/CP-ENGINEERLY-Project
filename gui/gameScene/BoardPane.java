package gameScene;

import field.ControlField;
import field.CornerField;
import field.Direction;
import field.HLandField;
import field.VLandField;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Land;
import sharedObject.IRenderableHolder;

public class BoardPane extends GridPane {

//	private int startX = Game.borderX, startY = Game.borderY;
//	private boolean visible;
//	private final StateScene state = StateScene.GAMESCENE;
	private VBox left;
	private HBox top;
	private VBox right;
	private HBox bottom;

	public BoardPane() {
//		visible = true;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		left = new VBox();
		left.getChildren().add(new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT));
		left.getChildren().add(new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT));
		left.getChildren().add(new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT));
		left.getChildren().add(new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT));
		left.getChildren().add(new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT));

		top = new HBox();
		top.getChildren().add(new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN));
		top.getChildren().add(new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN));
		top.getChildren().add(new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN));
		top.getChildren().add(new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN));
		top.getChildren().add(new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN));

		right = new VBox();
		right.getChildren().add(new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT));
		right.getChildren().add(new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT));
		right.getChildren().add(new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT));
		right.getChildren().add(new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT));
		right.getChildren().add(new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT));

		bottom = new HBox();
		bottom.getChildren().add(new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP));
		bottom.getChildren().add(new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP));
		bottom.getChildren().add(new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP));
		bottom.getChildren().add(new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP));
		bottom.getChildren().add(new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP));

		add(new CornerField(IRenderableHolder.start), 0, 0);
		add(new CornerField(IRenderableHolder.registration), 2, 0);
		add(new CornerField(IRenderableHolder.manPoint), 0, 2);
		add(new CornerField(IRenderableHolder.freeParking), 2, 2);
		add(left, 0, 1);
		add(right, 2, 1);
		add(top, 1, 0);
		add(bottom, 1, 2);
		add(new ControlField(), 1, 1);

		setAlignment(Pos.CENTER);
	};

}
