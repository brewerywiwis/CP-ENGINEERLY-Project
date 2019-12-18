package field;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
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
import javafx.scene.text.Text;

public class LogDisplay extends VBox {
	private ListView<String> logPane;
	private BorderPane titlePane;
	private int mSize;

	public LogDisplay() {
		mSize = 0;

		Text title = new Text("What Happen!");
		title.setFont(new Font(30));
		title.setFill(Color.BLACK);

		titlePane = new BorderPane();
		titlePane.setCenter(title);
		titlePane.setPadding(new Insets(20));
		titlePane.setBackground(new Background(new BackgroundFill(Color.LINEN, CornerRadii.EMPTY, null)));
		titlePane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		logPane = new ListView<String>();

		getChildren().addAll(titlePane, logPane);
		setAlignment(Pos.TOP_CENTER);
	}

	public void add(String msg) {
		logPane.getItems().add(msg);
		logPane.scrollTo(mSize++);
	}

	public int getSize() {
		return mSize;
	}
}
