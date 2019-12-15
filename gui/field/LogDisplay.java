package field;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LogDisplay extends VBox {
	private ListView<String> logPane;
	private BorderPane titlePane;

	public LogDisplay() {
		Text title = new Text("What Happen!");
		title.setFont(new Font(30));
		title.setFill(Color.BLACK);
		titlePane = new BorderPane();
		titlePane.setCenter(title);
		setMargin(title, new Insets(15));

		logPane = new ListView<String>();
		logPane.getItems().addAll("WTF", "THIS", "IS", "LOG", "DISPLAY");
		logPane.getItems().addAll("WTF", "THIS", "IS", "LOG", "DISPLAY");
		logPane.getItems().addAll("WTF", "THIS", "IS", "LOG", "DISPLAY");
		logPane.getItems().addAll("WTF", "THIS", "IS", "LOG", "DISPLAY");
		getChildren().addAll(title, logPane);
		
		setBackground(new Background(new BackgroundFill(Color.LINEN, CornerRadii.EMPTY, null)));
		setAlignment(Pos.TOP_CENTER);
	}
}
