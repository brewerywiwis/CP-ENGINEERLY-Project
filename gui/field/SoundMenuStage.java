package field;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.LogicGame;

public class SoundMenuStage extends Stage {

	private Slider mainSlider;
	private Slider bgSlider;
	private Slider sfxSlider;

	public SoundMenuStage() {
		mainSlider = new Slider(0, 100, 100);
		bgSlider = new Slider(0, 100, 100);
		sfxSlider = new Slider(0, 100, 100);

		initModality(Modality.APPLICATION_MODAL);
		initStyle(StageStyle.UTILITY);

		VBox root = new VBox();

		VBox titleHead = new VBox();
		Label title = new Label("Sound Settings");
		title.setFont(new Font(20));
		titleHead.setAlignment(Pos.CENTER);
		titleHead.getChildren().add(title);

		GridPane soundSetting = new GridPane();
		Text mainSound = new Text("Main Sound");
		mainSound.setFont(new Font(15));
		mainSlider.setShowTickLabels(true);
		mainSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasChanging,
					Boolean changing) {
				if (!changing) {
					LogicGame.setMainSound(mainSlider.getValue() / 100);
				}
			}
		});
		Text bgSound = new Text("BG Sound");
		bgSound.setFont(new Font(15));
		bgSlider.setShowTickLabels(true);
		bgSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasChanging,
					Boolean changing) {
				if (!changing) {
					LogicGame.setBGSound(bgSlider.getValue() / 100);
				}
			}
		});

		Text sfxSound = new Text("Effect Sound");
		sfxSound.setFont(new Font(15));
		sfxSlider.setShowTickLabels(true);
		sfxSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasChanging,
					Boolean changing) {
				if (!changing) {
					LogicGame.setEffectSound(sfxSlider.getValue() / 100);
				}
			}
		});

		soundSetting.add(mainSound, 0, 0);
		soundSetting.add(mainSlider, 1, 0);

		soundSetting.add(bgSound, 0, 1);
		soundSetting.add(bgSlider, 1, 1);

		soundSetting.add(sfxSound, 0, 2);
		soundSetting.add(sfxSlider, 1, 2);

		soundSetting.setHgap(10);
		soundSetting.setVgap(10);

		root.getChildren().addAll(titleHead, soundSetting);
		root.setSpacing(30);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(30));
		Scene scene = new Scene(root);

		setScene(scene);
	}
}
