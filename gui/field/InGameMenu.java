package field;

import application.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sharedObject.SharedObjectHolder;

public class InGameMenu extends VBox {
	private Button menu;
	private Button sound;
	private SoundMenuStage soundMenuStage;
	private SettingMenuStage settingMenuStage;

	public InGameMenu() {
		soundMenuStage = new SoundMenuStage();
		settingMenuStage = new SettingMenuStage();

		menu = new Button();
		menu.setGraphic(new ImageView(SharedObjectHolder.settingButton));
		menu.setStyle("-fx-background-color: transparent");
		menu.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				menu.setGraphic(new ImageView(SharedObjectHolder.transparentSettingButton));
			}
		});
		menu.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				menu.setGraphic(new ImageView(SharedObjectHolder.settingButton));
				settingMenuStage.setX(Main.getCenterXPosition() - getWidth() / 2d);
				settingMenuStage.setY(Main.getCenterYPosition() - 2 * Main.getCenterYPosition() / 3);

				Main.stopGame();
				settingMenuStage.showAndWait();
				Main.startGame();
			}
		});

		sound = new Button();
		sound.setStyle("-fx-background-color: transparent");
		sound.setGraphic(new ImageView(SharedObjectHolder.soundSettingButton));

		sound.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sound.setGraphic(new ImageView(SharedObjectHolder.transparentSoundSettingButton));
			}
		});
		sound.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sound.setGraphic(new ImageView(SharedObjectHolder.soundSettingButton));
				soundMenuStage.setX(Main.getCenterXPosition() - getWidth() / 2d);
				soundMenuStage.setY(Main.getCenterYPosition() - 2 * Main.getCenterYPosition() / 3);
				soundMenuStage.showAndWait();
			}
		});

		getChildren().addAll(menu, sound);
		setSpacing(50);
		setAlignment(Pos.TOP_CENTER);
	}

}
