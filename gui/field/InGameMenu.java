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
	private ImageView settingButton;
	private ImageView transparentSettingButton;
	private ImageView soundSettingButton;
	private ImageView transparentSoundSettingButton;

	public InGameMenu() {
		soundMenuStage = new SoundMenuStage();
		settingMenuStage = new SettingMenuStage();

		settingButton = new ImageView(SharedObjectHolder.settingButton);
		settingButton.setScaleX(1.5);
		settingButton.setScaleY(1.5);
		transparentSettingButton = new ImageView(SharedObjectHolder.transparentSettingButton);
		transparentSettingButton.setScaleX(1.5);
		transparentSettingButton.setScaleY(1.5);
		soundSettingButton = new ImageView(SharedObjectHolder.soundSettingButton);
		soundSettingButton.setScaleX(1.5);
		soundSettingButton.setScaleY(1.5);
		transparentSoundSettingButton = new ImageView(SharedObjectHolder.transparentSoundSettingButton);
		transparentSoundSettingButton.setScaleX(1.5);
		transparentSoundSettingButton.setScaleY(1.5);

		menu = new Button();
		menu.setGraphic(settingButton);
		menu.setStyle("-fx-background-color: transparent");
		menu.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				menu.setGraphic(transparentSettingButton);
			}
		});
		menu.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				menu.setGraphic(settingButton);
				settingMenuStage.setX(Main.getCenterXPosition() - getWidth() / 2d);
				settingMenuStage.setY(Main.getCenterYPosition() - 2 * Main.getCenterYPosition() / 3);

				Main.stopGame();
				settingMenuStage.showAndWait();
				Main.startGame();
			}
		});

		sound = new Button();
		sound.setStyle("-fx-background-color: transparent");
		sound.setGraphic(soundSettingButton);

		sound.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sound.setGraphic(transparentSoundSettingButton);
			}
		});
		sound.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sound.setGraphic(soundSettingButton);
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
