package field;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.SpecialAsset;

public class CornerField extends Field {

	private final double width = 140;
	private final double height = 140;

	public CornerField(SpecialAsset asset, Image img) {
		super();
		this.actionable = asset;
		ImageView im = new ImageView(img);
		im.setPreserveRatio(true);
		im.setFitWidth(120);
		setCenter(im);
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
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
