package Field;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
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

public class VLandField extends BorderPane {

	private Land land;

	public VLandField(Land land, Color color) {
		super();
		this.land = land;
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Label lPrice = new Label(String.format("$%d", land.getPrice()));
		Label lName = new Label(land.getName());
		lPrice.setFont(new Font(18));
		lName.setFont(new Font(20));

		BorderPane inside = new BorderPane();
		inside.setMinHeight(100);
		BorderPane.setAlignment(lName, Pos.CENTER);
		BorderPane.setAlignment(lPrice, Pos.CENTER);
		inside.setTop(lName);
		inside.setBottom(lPrice);

		setMinHeight(120);
		setCenter(inside);
		setBottom(new Rectangle(80, 30, color));
	}

	public Land getLand() {
		return land;
	}

}
