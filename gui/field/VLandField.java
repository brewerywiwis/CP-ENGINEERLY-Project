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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Actionable;
import logic.Asset;
import logic.ChanceCard;
import logic.CommunityChest;
import sharedObject.SharedObjectHolder;

public class VLandField extends Field {

	private HBox hStore;
	private final double width = 100;
	private final double height = 140;

	public VLandField(Actionable actionable, Direction dir) {
		super();
		this.actionable = actionable;
//		setBorder(new Border(
//				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		if (actionable instanceof Asset) {
			Asset asset = (Asset) actionable;
			Label lPrice = new Label(String.format("฿%d", asset.getPrice()));
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
			setMinHeight(height);
			setCenter(inside);

			hStore = new HBox();
			///////////////////////////
			hStore.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
			hStore.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			//////////////////////////
			hStore.setMinWidth(width);
			hStore.setMinHeight(40);

			if (dir == Direction.DOWN) {
				setBottom(hStore);
			} else if (dir == Direction.UP) {
				setTop(hStore);
			}
		} else if (actionable instanceof ChanceCard) {
			setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
			ImageView im = new ImageView(SharedObjectHolder.chanceCardV);
			im.setFitHeight(height);
			im.setFitWidth(width);
			setCenter(im);
			setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		} else if (actionable instanceof CommunityChest) {
			setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
			ImageView im = new ImageView(SharedObjectHolder.communityChestV);
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
			hStore.setBackground(
					new Background(new BackgroundFill(asset.getOwner().getColor(), CornerRadii.EMPTY, null)));
		}
	}
}
