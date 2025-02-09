package field;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import logic.Player;
import sharedObject.SharedObjectHolder;

public class AssetShow extends StackPane {
	private Player player;
	private BorderPane imgPane;
	private ImageView profileImg;
	private GridPane description;
	private Label name;
	private Label money;

	public AssetShow(Player player) {
		this.player = player;

		HBox hRoot = new HBox();
		profileImg = new ImageView(player.getImage());
		profileImg.setScaleX(1.2);
		profileImg.setScaleY(1.2);
		imgPane = new BorderPane();
		imgPane.setCenter(profileImg);
		hRoot.getChildren().add(imgPane);

		ImageView nameShowBG = new ImageView(SharedObjectHolder.nameShowBG);
		ImageView moneyShowBG = new ImageView(SharedObjectHolder.moneyShowBG);
		name = new Label("Player: " + player.getName());
		money = new Label("      " + String.valueOf(player.getMoney()));
		name.setFont(Font.font("Verdana", 18));
		name.setTextFill(Color.DARKOLIVEGREEN);
		money.setFont(Font.font("Verdana", 18));
		money.setTextFill(Color.DARKOLIVEGREEN);

		StackPane nameShow = new StackPane();
		nameShow.getChildren().addAll(nameShowBG, name);
		StackPane moneyShow = new StackPane();
		moneyShow.getChildren().addAll(moneyShowBG, money);

		description = new GridPane();
		description.setVgap(0);
		description.setAlignment(Pos.CENTER);
		description.add(nameShow, 0, 0);
		description.add(moneyShow, 0, 1);

		hRoot.getChildren().add(description);
		hRoot.setPadding(new Insets(25, 20, 30, 20));
		hRoot.setSpacing(10);
		hRoot.setBackground(new Background(new BackgroundImage(SharedObjectHolder.assetShowBG,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
		getChildren().add(hRoot);
	}

	public void update() {
		// TODO Auto-generated method stub
		money.setText("      " + String.valueOf(player.getMoney()));
	}

	public void setUpBankruptPlayer() {
		Rectangle film = new Rectangle(getWidth() - 3, getHeight() - 15, Color.LIGHTGRAY);
		film.setOpacity(0.6);
		getChildren().add(film);
		money.setText("         Money: " + String.valueOf(player.getMoney()));
	}

	public Player getPlayer() {
		return player;
	}
}
