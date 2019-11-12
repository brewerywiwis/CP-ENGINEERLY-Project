package field;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import logic.Land;

public class HLandField extends BorderPane {

	private Land land;

	public HLandField(Land land, Color color, Direction dir) {
		super();
		this.land = land;
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Label lPrice = new Label(String.format("$%d", land.getPrice()));
		Label lName = new Label(land.getName());
		lPrice.setFont(new Font(18));
		lName.setFont(new Font(20));

		BorderPane inside = new BorderPane();
		BorderPane.setAlignment(lName, Pos.CENTER);
		BorderPane.setAlignment(lPrice, Pos.CENTER);
		inside.setTop(lName);
		inside.setBottom(lPrice);
		inside.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		setMinWidth(120);
		setCenter(inside);
		if (dir == Direction.RIGHT) {
			setRight(new Rectangle(30, 80, color));
		} else if (dir == Direction.LEFT) {
			setLeft(new Rectangle(30, 80, color));
		}
	}

	public Land getLand() {
		return land;
	}

}
