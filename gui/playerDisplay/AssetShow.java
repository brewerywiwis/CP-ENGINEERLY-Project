package playerDisplay;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Player;

public class AssetShow extends HBox {
	private ImageView profileImg;
	private GridPane description;

	public AssetShow(Player player) {
		profileImg = new ImageView(player.getImage());
		getChildren().add(profileImg);

		Label name = new Label("Player Name: " + player.getName());
		Label money = new Label("Money: " + String.valueOf(player.getMoney()));
		name.setFont(new Font(22));
		money.setFont(new Font(22));
		
		description = new GridPane();
		description.setVgap(15);;
		description.setAlignment(Pos.CENTER);
		description.add(name, 0, 0);
		description.add(money, 0, 1);

		getChildren().add(description);
		setPadding(new Insets(20));
		setSpacing(20);
		setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, null)));
		setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}
}
