package gameScene;

import java.util.ArrayList;
import field.ControlField;
import field.CornerField;
import field.Direction;
import field.Field;
import field.HLandField;
import field.VLandField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
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
	private static final int numOfField = 24;

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
		two = new HLandField(new Land("HOME", 200), Color.PINK, Direction.RIGHT);
		three = new HLandField(new Land("HOME", 300), Color.PINK, Direction.RIGHT);
		four = new HLandField(new Land("HOME", 400), Color.PINK, Direction.RIGHT);
		five = new HLandField(new Land("HOME", 500), Color.PINK, Direction.RIGHT);

		one2 = new VLandField(new Land("HOME2", 100), Color.AQUAMARINE, Direction.DOWN);
		two2 = new VLandField(new Land("HOME2", 200), Color.AQUAMARINE, Direction.DOWN);
		three2 = new VLandField(new Land("HOME2", 300), Color.AQUAMARINE, Direction.DOWN);
		four2 = new VLandField(new Land("HOME2", 400), Color.AQUAMARINE, Direction.DOWN);
		five2 = new VLandField(new Land("HOME2", 500), Color.AQUAMARINE, Direction.DOWN);

		one3 = new HLandField(new Land("HOME", 100), Color.BROWN, Direction.LEFT);
		two3 = new HLandField(new Land("HOME", 200), Color.BROWN, Direction.LEFT);
		three3 = new HLandField(new Land("HOME", 300), Color.BROWN, Direction.LEFT);
		four3 = new HLandField(new Land("HOME", 400), Color.BROWN, Direction.LEFT);
		five3 = new HLandField(new Land("HOME", 500), Color.BROWN, Direction.LEFT);

		one4 = new VLandField(new Land("HOME2", 100), Color.GREEN, Direction.UP);
		two4 = new VLandField(new Land("HOME2", 200), Color.GREEN, Direction.UP);
		three4 = new VLandField(new Land("HOME2", 300), Color.GREEN, Direction.UP);
		four4 = new VLandField(new Land("HOME2", 400), Color.GREEN, Direction.UP);
		five4 = new VLandField(new Land("HOME2", 500), Color.GREEN, Direction.UP);

		start = new CornerField(IRenderableHolder.start);
		registration = new CornerField(IRenderableHolder.registration);
		freeParking = new CornerField(IRenderableHolder.freeParking);
		manPoint = new CornerField(IRenderableHolder.manPoint);

		controlField = new ControlField();

		fields.add(start);

		fields.add(one2);
		fields.add(two2);
		fields.add(three2);
		fields.add(four2);
		fields.add(five2);

		fields.add(registration);

		fields.add(one3);
		fields.add(two3);
		fields.add(three3);
		fields.add(four3);
		fields.add(five3);

		fields.add(freeParking);

		fields.add(one4);
		fields.add(two4);
		fields.add(three4);
		fields.add(four4);
		fields.add(five4);

		fields.add(manPoint);

		fields.add(one);
		fields.add(two);
		fields.add(three);
		fields.add(four);
		fields.add(five);

		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		left = new VBox();
		left.getChildren().add(five);
		left.getChildren().add(four);
		left.getChildren().add(three);
		left.getChildren().add(two);
		left.getChildren().add(one);

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
		bottom.getChildren().add(five4);
		bottom.getChildren().add(four4);
		bottom.getChildren().add(three4);
		bottom.getChildren().add(two4);
		bottom.getChildren().add(one4);

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
		setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setPadding(new Insets(10));
	};

	public void update() {
		for (int i = 0; i < fields.size(); i++) {
//			fields.get(i).
		}
	}

	public ArrayList<Field> getFields() {
		return fields;
	}

	public static int getNumoffield() {
		return numOfField;
	}

}
