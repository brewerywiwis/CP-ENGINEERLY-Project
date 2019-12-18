package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class SharedObjectHolder {
	public static ArrayList<Color> characterColors;
	public static Image boardBackground;
	public static Image freeParking;
	public static Image manPoint;
	public static Image start;
	public static Image registration;
	public static Image chanceCardV;
	public static Image communityChestV;
	public static Image chanceCardH;
	public static Image communityChestH;
	public static Image blackPawn;
	public static Image yellowPawn;
	public static Image pinkPawn;
	public static Image bluePawn;
	public static Image whitePawn;
	public static Image startSceneBackground;
	public static Image startButton;
	public static Image clickedStartButton;
	public static Image onePlayerButton;
	public static Image twoPlayerButton;
	public static Image threePlayerButton;
	public static Image fourPlayerButton;
	public static Image clickedOnePlayer;
	public static Image clickedTwoPlayer;
	public static Image clickedThreePlayer;
	public static Image clickedFourPlayer;
	public static Image woodenBg;
	public static Image trophy;
	public static Image settingButton;
	public static Image soundSettingButton;
	public static Image transparentSettingButton;
	public static Image transparentSoundSettingButton;
	public static Image playerOneWins;
	public static Image playerTwoWins;
	public static Image playerThreeWins;
	public static Image playerFourWins;
	public static Image playAgain;
	public static Image clickedPlayAgain;
	public static Image assetShowBG;
	public static Image moneyShowBG;
	public static Image nameShowBG;
	public static Image pullRoll;
	public static Image pushRoll;
	public static Image chance0;
	public static Image chance1;
	public static Image chance2;
	public static Image chance3;
	public static Image chance4;
	public static Image chance5;
	public static Image chance6;
	public static Image chance7;
	public static Image chance8;
	public static Image chance9;
	public static Image chest0;
	public static Image chest1;
	public static Image chest2;
	public static Image chest3;
	public static Image chest4;
	public static Image chest5;
	public static Image chest6;
	public static Image chest7;
	public static Image chest8;
	public static Image chest9;
	public static Image diceOne;
	public static Image diceTwo;
	public static Image diceThree;
	public static Image diceFour;
	public static Image diceFive;
	public static Image diceSix;
	public static AudioClip footstepSound;
	public static AudioClip buttonSound;
	public static AudioClip alertSound;
	public static AudioClip manPointLOLSound;
	public static AudioClip epicWinSound;
	public static AudioClip buttonLight;
	public static AudioClip babyCrySound;
	public static AudioClip fairySound;
	public static AudioClip treasureSound;
	public static AudioClip bankruptSound;
	public static MediaPlayer BGGameMusic;

	static {
		loadResource();
	}

	public SharedObjectHolder() {
	}

	private static void loadResource() {

		try {
			characterColors = new ArrayList<Color>();
			characterColors.add(Color.BLACK);
			characterColors.add(Color.YELLOW);
			// below is light pink color
			characterColors.add(Color.rgb(255, 155, 204));
			// below is light blue color
			characterColors.add(Color.rgb(12, 155, 204));
			boardBackground = new Image(new FileInputStream("./res/Graphics/gearBackground3.png"));
			registration = new Image(new FileInputStream("./res/Graphics/registrationRoom.png"));
			freeParking = new Image(new FileInputStream("./res/Graphics/freeParking.png"));
			manPoint = new Image(new FileInputStream("./res/Graphics/manPoint.png"));
			start = new Image(new FileInputStream("./res/Graphics/start.png"));
			blackPawn = new Image(new FileInputStream("./res/Graphics/blackPawn.png"));
			yellowPawn = new Image(new FileInputStream("./res/Graphics/yellowPawn.png"));
			pinkPawn = new Image(new FileInputStream("./res/Graphics/pinkPawn.png"));
			bluePawn = new Image(new FileInputStream("./res/Graphics/bluePawn.png"));
			whitePawn = new Image(new FileInputStream("./res/Graphics/whitePawn.png"));
			startSceneBackground = new Image(new FileInputStream("./res/Graphics/startSceneBackground.png"));
			startButton = new Image(new FileInputStream("./res/Graphics/startButton.png"));
			clickedStartButton = new Image(new FileInputStream("./res/Graphics/clickedStartButton.png"));
			onePlayerButton = new Image(new FileInputStream("./res/Graphics/onePlayerButton.png"));
			twoPlayerButton = new Image(new FileInputStream("./res/Graphics/twoPlayerButton.png"));
			threePlayerButton = new Image(new FileInputStream("./res/Graphics/threePlayerButton.png"));
			fourPlayerButton = new Image(new FileInputStream("./res/Graphics/fourPlayerButton.png"));
			clickedOnePlayer = new Image(new FileInputStream("./res/Graphics/clickedOnePlayer.png"));
			clickedTwoPlayer = new Image(new FileInputStream("./res/Graphics/clickedTwoPlayer.png"));
			clickedThreePlayer = new Image(new FileInputStream("./res/Graphics/clickedThreePlayer.png"));
			clickedFourPlayer = new Image(new FileInputStream("./res/Graphics/clickedFourPlayer.png"));
			woodenBg = new Image(new FileInputStream("./res/Graphics/woodenBg.jpg"));
			chanceCardV = new Image(new FileInputStream("./res/Graphics/chanceCardV.jpg"));
			communityChestV = new Image(new FileInputStream("./res/Graphics/communityChestV.jpg"));
			chanceCardH = new Image(new FileInputStream("./res/Graphics/chanceCardH.jpg"));
			communityChestH = new Image(new FileInputStream("./res/Graphics/communityChestH.jpg"));
			trophy = new Image(new FileInputStream("./res/Graphics/trophy.png"));
			settingButton = new Image(new FileInputStream("./res/Graphics/setting.png"));
			soundSettingButton = new Image(new FileInputStream("./res/Graphics/soundSetting.png"));
			transparentSettingButton = new Image(new FileInputStream("./res/Graphics/transparentSetting.png"));
			transparentSoundSettingButton = new Image(
					new FileInputStream("./res/Graphics/transparentSoundSetting.png"));
			playerOneWins = new Image(new FileInputStream("./res/Graphics/playerOneWins.png"));
			playerTwoWins = new Image(new FileInputStream("./res/Graphics/playerTwoWins.png"));
			playerThreeWins = new Image(new FileInputStream("./res/Graphics/playerThreeWins.png"));
			playerFourWins = new Image(new FileInputStream("./res/Graphics/playerFourWins.png"));
			playAgain = new Image(new FileInputStream("./res/Graphics/playAgain.png"));
			clickedPlayAgain = new Image(new FileInputStream("./res/Graphics/ClickedPlayAgain.png"));
			assetShowBG = new Image(new FileInputStream("./res/Graphics/assetShowBG.png"));
			moneyShowBG = new Image(new FileInputStream("./res/Graphics/moneyShowBG.png"));
			nameShowBG = new Image(new FileInputStream("./res/Graphics/nameShowBG.png"));
			pullRoll = new Image(new FileInputStream("./res/Graphics/pullRoll.png"));
			pushRoll = new Image(new FileInputStream("./res/Graphics/pushRoll.png"));
			chance0 = new Image(new FileInputStream("./res/Graphics/chance0.png"));
			chance1 = new Image(new FileInputStream("./res/Graphics/chance1.png"));
			chance2 = new Image(new FileInputStream("./res/Graphics/chance2.png"));
			chance3 = new Image(new FileInputStream("./res/Graphics/chance3.png"));
			chance4 = new Image(new FileInputStream("./res/Graphics/chance4.png"));
			chance5 = new Image(new FileInputStream("./res/Graphics/chance5.png"));
			chance6 = new Image(new FileInputStream("./res/Graphics/chance6.png"));
			chance7 = new Image(new FileInputStream("./res/Graphics/chance7.png"));
			chance8 = new Image(new FileInputStream("./res/Graphics/chance8.png"));
			chance9 = new Image(new FileInputStream("./res/Graphics/chance9.png"));
			chest0 = new Image(new FileInputStream("./res/Graphics/chest0.png"));
			chest1 = new Image(new FileInputStream("./res/Graphics/chest1.png"));
			chest2 = new Image(new FileInputStream("./res/Graphics/chest2.png"));
			chest3 = new Image(new FileInputStream("./res/Graphics/chest3.png"));
			chest4 = new Image(new FileInputStream("./res/Graphics/chest4.png"));
			chest5 = new Image(new FileInputStream("./res/Graphics/chest5.png"));
			chest6 = new Image(new FileInputStream("./res/Graphics/chest6.png"));
			chest7 = new Image(new FileInputStream("./res/Graphics/chest7.png"));
			chest8 = new Image(new FileInputStream("./res/Graphics/chest8.png"));
			chest9 = new Image(new FileInputStream("./res/Graphics/chest9.png"));
			diceOne = new Image(new FileInputStream("./res/Graphics/diceOne.png"));
			diceTwo = new Image(new FileInputStream("./res/Graphics/diceTwo.png"));
			diceThree = new Image(new FileInputStream("./res/Graphics/diceThree.png"));
			diceFour = new Image(new FileInputStream("./res/Graphics/diceFour.png"));
			diceFive = new Image(new FileInputStream("./res/Graphics/diceFive.png"));
			diceSix = new Image(new FileInputStream("./res/Graphics/diceSix.png"));
			footstepSound = new AudioClip(ClassLoader.getSystemResource("Sounds/footstep.mp3").toExternalForm());
			buttonSound = new AudioClip(ClassLoader.getSystemResource("Sounds/button-11.wav").toExternalForm());
			alertSound = new AudioClip(ClassLoader.getSystemResource("Sounds/alert.mp3").toExternalForm());
			manPointLOLSound = new AudioClip(ClassLoader.getSystemResource("Sounds/manPointLOL.mp3").toExternalForm());
			epicWinSound = new AudioClip(ClassLoader.getSystemResource("Sounds/epicWin.mp3").toExternalForm());
			buttonLight = new AudioClip(ClassLoader.getSystemResource("Sounds/buttonLight.mp3").toExternalForm());
			fairySound = new AudioClip(ClassLoader.getSystemResource("Sounds/fairySound.mp3").toExternalForm());
			treasureSound = new AudioClip(ClassLoader.getSystemResource("Sounds/treasureSound.mp3").toExternalForm());
			BGGameMusic = new MediaPlayer(
					new Media(ClassLoader.getSystemResource("Sounds/BGGameSceneMusic.mp3").toExternalForm()));
			babyCrySound = new AudioClip(ClassLoader.getSystemResource("Sounds/babyCry.mp3").toExternalForm());
			bankruptSound = new AudioClip(ClassLoader.getSystemResource("Sounds/bankruptSound.mp3").toExternalForm());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
