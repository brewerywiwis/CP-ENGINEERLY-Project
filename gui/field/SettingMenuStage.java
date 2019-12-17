package field;

import application.Main;
import application.StateScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class SettingMenuStage extends Stage {

	private final int widthButton = 200;
	private final int heightButton = 40;

	public SettingMenuStage() {
		initModality(Modality.APPLICATION_MODAL);
		initStyle(StageStyle.UTILITY);
		setTitle("PAUSE");

		VBox root = new VBox();

		Button resume = new Button("Resume");
		resume.setFont(new Font(20));
		resume.setMinSize(widthButton, heightButton);
		resume.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		resume.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				close();
				Main.startGame();
			}
		});

		Button restart = new Button("Restart");
		restart.setFont(new Font(20));
		restart.setMinSize(widthButton, heightButton);
		restart.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		restart.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				Main.setState(StateScene.SWAPGAMESCENE);
				close();
				Main.startGame();
			}
		});

		Button exitToDesktop = new Button("Exit to desktop");
		exitToDesktop.setFont(new Font(20));
		exitToDesktop.setMinSize(widthButton, heightButton);
		exitToDesktop.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		exitToDesktop.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				System.exit(0);
			}
		});

		Button exitToMainMenu = new Button("Exit to Main Menu");
		exitToMainMenu.setFont(new Font(20));
		exitToMainMenu.setMinSize(widthButton, heightButton);
		exitToMainMenu.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		exitToMainMenu.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				Main.setState(StateScene.SWAPSTARTSCENE);
				close();
			}
		});

		root.getChildren().addAll(resume, restart, exitToDesktop, exitToMainMenu);
		root.setSpacing(30);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(30));
		Scene scene = new Scene(root);

		setScene(scene);
	}
}
