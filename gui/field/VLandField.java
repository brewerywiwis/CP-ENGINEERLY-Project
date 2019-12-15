package field;

import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
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
import logic.Asset;

public class VLandField extends Field {

	private Asset asset;
	private final double width = 80;
	private final double height = 120;

	public VLandField(Asset asset, Color color, Direction dir) {
		super();
		this.asset = asset;
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Label lPrice = new Label(String.format("$%d", asset.getPrice()));
		Label lName = new Label(asset.getName());
		lPrice.setFont(new Font(18));
		lName.setFont(new Font(20));

		BorderPane inside = new BorderPane();
		BorderPane.setAlignment(lName, Pos.CENTER);
		BorderPane.setAlignment(lPrice, Pos.CENTER);
		inside.setTop(lName);
		inside.setBottom(lPrice);
		inside.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		setMinHeight(height);
		setCenter(inside);
		if (dir == Direction.DOWN) {
			setBottom(new Rectangle(width, 30, color));
		} else if (dir == Direction.UP) {
			setTop(new Rectangle(width, 30, color));
		}
	}

	public Asset getAsset() {
		return asset;
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

	public double getHeightField() {
		return height;
	}

	public double getWidthField() {
		return width;
	}

	@Override
	public void eventAction() {
		// TODO Auto-generated method stub

	}
}
