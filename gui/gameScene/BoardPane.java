package gameScene;

import java.util.ArrayList;

import field.ControlField;
import field.CornerField;
import field.Direction;
import field.Field;
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
	private ArrayList<Field> fields;

	private HLandField one;
	private HLandField two;
	private HLandField three;
	private HLandField four;
	private HLandField five;

	private VLandField one2;
	private VLandField two2;
	private VLandField three2;
	private VLandField four2;
	private VLandField five2;

	private HLandField one3;
	private HLandField two3;
	private HLandField three3;
	private HLandField four3;
	private HLandField five3;

	private VLandField one4;
	private VLandField two4;
	private VLandField three4;
	private VLandField four4;
	private VLandField five4;

	private CornerField start;
	private CornerField registration;
	private CornerField manPoint;
	private CornerField freeParking;

	private ControlField controlField;

	public BoardPane() {
//		visible = true;
		fields = new ArrayList<Field>();
		one = new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT);
		two = new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT);
		three = new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT);
		four = new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT);
		five = new HLandField(new Land("HOME", 100), Color.PINK, Direction.RIGHT);

		one2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);
		two2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);
		three2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);
		four2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);
		five2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);

		one3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);
		two3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);
		three3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);
		four3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);
		five3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);

		one4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);
		two4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);
		three4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);
		four4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);
		five4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);

		start = new CornerField(IRenderableHolder.start);
		registration = new CornerField(IRenderableHolder.registration);
		manPoint = new CornerField(IRenderableHolder.manPoint);
		freeParking = new CornerField(IRenderableHolder.freeParking);

		controlField = new ControlField();

		fields.add(start);

		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);

		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);

		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);

		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);
		fields.add(start);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		left = new VBox();
		left.getChildren().add(one);
		left.getChildren().add(two);
		left.getChildren().add(three);
		left.getChildren().add(four);
		left.getChildren().add(five);

		top = new HBox();
		top.getChildren().add(one2);
		top.getChildren().add(two2);
		top.getChildren().add(three2);
		top.getChildren().add(four2);
		top.getChildren().add(five2);

		right = new VBox();
		right.getChildren().add(one3);
		right.getChildren().add(two3);
		right.getChildren().add(three3);
		right.getChildren().add(four3);
		right.getChildren().add(five3);

		bottom = new HBox();
		bottom.getChildren().add(one4);
		bottom.getChildren().add(two4);
		bottom.getChildren().add(three4);
		bottom.getChildren().add(four4);
		bottom.getChildren().add(five4);

		add(start, 0, 0);
		add(registration, 2, 0);
		add(manPoint, 0, 2);
		add(freeParking, 2, 2);
		add(left, 0, 1);
		add(right, 2, 1);
		add(top, 1, 0);
		add(bottom, 1, 2);
		add(controlField, 1, 1);

		setAlignment(Pos.CENTER);
	};

}
