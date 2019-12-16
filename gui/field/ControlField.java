package field;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControlField extends VBox {
	private Label condition;
	private Label description;
	private BorderPane img;
	private GridPane chooseSection;

	public ControlField() {
		condition = new Label("CONDITION");
		description = new Label("DESCRIPTION");
		img = new BorderPane();
		chooseSection = new GridPane();
		getChildren().addAll(condition, description, img, chooseSection);
//		setBorder(new Border(
//				new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
	}
}
