package field;

import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
import logic.Actionable;
import logic.Asset;
import logic.ChanceCard;
import logic.CommunityChest;
import sharedObject.IRenderableHolder;

public class HLandField extends Field {

	private Actionable actionable;
	private final double width = 140;
	private final double height = 100;

	public HLandField(Actionable actionable, Color color, Direction dir) {
		super();
		this.actionable = actionable;
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		if (actionable instanceof Asset) {
			Asset asset = (Asset) actionable;
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

			setMinWidth(width);
			setCenter(inside);
			if (dir == Direction.RIGHT) {
				setRight(new Rectangle(30, height, color));
			} else if (dir == Direction.LEFT) {
				setLeft(new Rectangle(30, height, color));
			}
		} else if (actionable instanceof ChanceCard) {
			ImageView im = new ImageView(IRenderableHolder.chanceCardH);
			im.setRotate(180 * (dir == Direction.RIGHT ? 1 : 0));
			im.setFitHeight(height);
			im.setFitWidth(width);
			setCenter(im);
		} else if (actionable instanceof CommunityChest) {
			ImageView im = new ImageView(IRenderableHolder.communityChestH);
			im.setRotate(180 * (dir == Direction.RIGHT ? 1 : 0));
			im.setFitHeight(height);
			im.setFitWidth(width);
			setCenter(im);
		}
	}

	public Actionable getActionable() {
		return actionable;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		if (land.ge)
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
		actionable.doAction();
	}
}
