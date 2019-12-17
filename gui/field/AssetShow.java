package field;

import java.io.FileInputStream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.Player;
import sharedObject.SharedObjectHolder;

public class AssetShow extends HBox {
	private Player player;
	private BorderPane imgPane;
	private ImageView profileImg;
	private GridPane description;
	private Label name;
	private Label money;
	public AssetShow(Player player) {
		this.player = player;

		profileImg = new ImageView(player.getImage());
		profileImg.setScaleX(1.2);
		profileImg.setScaleY(1.2);
		imgPane = new BorderPane();
		imgPane.setCenter(profileImg);
		getChildren().add(imgPane);
		
		ImageView nameShowBG = new ImageView(SharedObjectHolder.nameShowBG);
		ImageView moneyShowBG = new ImageView(SharedObjectHolder.moneyShowBG);
		name = new Label("Player Name: " + player.getName());
		money = new Label("         Money: " + String.valueOf(player.getMoney()));
		name.setFont(Font.font ("Verdana", 22));
		name.setTextFill(Color.OLIVE);
		money.setFont(Font.font ("Verdana", 22));
		money.setTextFill(Color.OLIVE);

		StackPane nameShow= new StackPane();
		nameShow.getChildren().addAll(nameShowBG, name);
		StackPane moneyShow= new StackPane();
		moneyShow.getChildren().addAll(moneyShowBG, money);
		
		
		description = new GridPane();
		description.setVgap(0);		
		description.setAlignment(Pos.CENTER);
		description.add(nameShow, 0, 0);
		description.add(moneyShow, 0, 1);

		getChildren().add(description);
		setPadding(new Insets(30));
		setSpacing(20);
		

		setMargin(description, new Insets(0));
		setBackground(new Background(new BackgroundImage(SharedObjectHolder.assetShowBG,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
	}

	public void update() {
		// TODO Auto-generated method stub
		money.setText("         Money: " + String.valueOf(player.getMoney()));
	}
}
