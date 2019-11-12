package gameScene;

import Field.ControlField;
import Field.CornerField;
import Field.Direction;
import Field.HLandField;
import Field.VLandField;
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

//	@Override
//	public int getZ() {
//		// TODO Auto-generated method stub
//		return 998;
//	}
//
//	@Override
//	public boolean isVisible() {
//		// TODO Auto-generated method stub
//		return visible;
//	}
//
//	@Override
//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		visible = b;
//	}
//
//	@Override
//	public StateScene getState() {
//		return state;
//	}
//
//	@Override
//	public void draw(GraphicsContext gc) {
//		// TODO Auto-generated method stub
//		int distanceY = Game.displayY - 2 * startY;
//		int distanceX = Game.displayX - 2 * startX;
//		for (int i = 0; i < 2; i++) {
//			gc.fillRect(startX, startY + i * distanceY / 7, distanceX + 2, 2);
//			gc.fillRect(startX + i * distanceX / 7, startY, 2, distanceY + 2);
//		}
//		for (int i = 1; i < 6; i++) {
//			gc.fillRect(startX, startY + i * distanceY / 7, distanceX / 7, 2);
//			gc.fillRect(Game.displayX - startX - distanceX / 7, startY + i * distanceY / 7, distanceX / 7, 2);
//		}
//		for (int i = 1; i < 6; i++) {
//			gc.fillRect(startX + i * distanceX / 7, startY, 2, distanceY / 7);
//			gc.fillRect(startX + i * distanceX / 7, Game.displayY - startY - distanceY / 7, 2, distanceY / 7);
//		}
//		for (int i = 0; i < 2; i++) {
//			gc.fillRect(startX, Game.displayY - startY - i * distanceY / 7, distanceX + 2, 2);
//			gc.fillRect(Game.displayX - startX - i * distanceX / 7, startY, 2, distanceY + 2);
//		}
//	}

}
