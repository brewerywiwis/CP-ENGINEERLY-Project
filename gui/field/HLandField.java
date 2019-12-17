package field;

import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Actionable;
import logic.Asset;
import logic.ChanceCard;
import logic.CommunityChest;
import sharedObject.SharedObjectHolder;

public class HLandField extends Field {

	private VBox vStore;
	private final double width = 140;
	private final double height = 100;

	public HLandField(Actionable actionable, Direction dir) {
		super();
		this.actionable = actionable;
//		setBorder(new Border(
//				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		if (actionable instanceof Asset) {
			Asset asset = (Asset) actionable;
			Label lPrice = new Label(String.format("THB%d", asset.getPrice()));
			Label lName = new Label(asset.getName());
			lPrice.setFont(new Font(18));
			lName.setFont(new Font(20));

			BorderPane inside = new BorderPane();
			BorderPane.setAlignment(lName, Pos.CENTER);
			BorderPane.setAlignment(lPrice, Pos.CENTER);
			inside.setTop(lName);
			inside.setBottom(lPrice);
			inside.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
			inside.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			setMinWidth(width);
			setCenter(inside);

			vStore = new VBox();
			///////////////////////////
			vStore.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
			vStore.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			//////////////////////////
			vStore.setMinWidth(40);
			vStore.setMinHeight(height);

			if (dir == Direction.RIGHT) {
				setRight(vStore);
			} else if (dir == Direction.LEFT) {
				setLeft(vStore);
			}
		} else if (actionable instanceof ChanceCard) {
			ImageView im = new ImageView(SharedObjectHolder.chanceCardH);
			im.setRotate(180 * (dir == Direction.RIGHT ? 1 : 0));
			im.setFitHeight(height);
			im.setFitWidth(width);
			setCenter(im);
			setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		} else if (actionable instanceof CommunityChest) {
			ImageView im = new ImageView(SharedObjectHolder.communityChestH);
			im.setRotate(180 * (dir == Direction.RIGHT ? 1 : 0));
			im.setFitHeight(height);
			im.setFitWidth(width);
			setCenter(im);
			setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		}
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

	public void setOwnerColor() {
		if (actionable instanceof Asset) {
			Asset asset = (Asset) actionable;
			vStore.setBackground(
					new Background(new BackgroundFill(asset.getOwner().getColor(), CornerRadii.EMPTY, null)));
		}
	}
}
