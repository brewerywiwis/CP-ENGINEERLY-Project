package sharedObject;

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
			boardBackground = new Image(ClassLoader.getSystemResource("Graphics/gearBackground3.png").toString());
			registration = new Image(ClassLoader.getSystemResource("Graphics/registrationRoom.png").toString());
			freeParking = new Image(ClassLoader.getSystemResource("Graphics/freeParking.png").toString());
			manPoint = new Image(ClassLoader.getSystemResource("Graphics/manPoint.png").toString());
			start = new Image(ClassLoader.getSystemResource("Graphics/start.png").toString());
			blackPawn = new Image(ClassLoader.getSystemResource("Graphics/blackPawn.png").toString());
			yellowPawn = new Image(ClassLoader.getSystemResource("Graphics/yellowPawn.png").toString());
			pinkPawn = new Image(ClassLoader.getSystemResource("Graphics/pinkPawn.png").toString());
			bluePawn = new Image(ClassLoader.getSystemResource("Graphics/bluePawn.png").toString());
			whitePawn = new Image(ClassLoader.getSystemResource("Graphics/whitePawn.png").toString());
			startSceneBackground = new Image(
					ClassLoader.getSystemResource("Graphics/startSceneBackground.png").toString());
			startButton = new Image(ClassLoader.getSystemResource("Graphics/startButton.png").toString());
			clickedStartButton = new Image(ClassLoader.getSystemResource("Graphics/clickedStartButton.png").toString());
			onePlayerButton = new Image(ClassLoader.getSystemResource("Graphics/onePlayerButton.png").toString());
			twoPlayerButton = new Image(ClassLoader.getSystemResource("Graphics/twoPlayerButton.png").toString());
			threePlayerButton = new Image(ClassLoader.getSystemResource("Graphics/threePlayerButton.png").toString());
			fourPlayerButton = new Image(ClassLoader.getSystemResource("Graphics/fourPlayerButton.png").toString());
			clickedOnePlayer = new Image(ClassLoader.getSystemResource("Graphics/clickedOnePlayer.png").toString());
			clickedTwoPlayer = new Image(ClassLoader.getSystemResource("Graphics/clickedTwoPlayer.png").toString());
			clickedThreePlayer = new Image(ClassLoader.getSystemResource("Graphics/clickedThreePlayer.png").toString());
			clickedFourPlayer = new Image(ClassLoader.getSystemResource("Graphics/clickedFourPlayer.png").toString());
			woodenBg = new Image(ClassLoader.getSystemResource("Graphics/woodenBg.jpg").toString());
			chanceCardV = new Image(ClassLoader.getSystemResource("Graphics/chanceCardV.jpg").toString());
			communityChestV = new Image(ClassLoader.getSystemResource("Graphics/communityChestV.jpg").toString());
			chanceCardH = new Image(ClassLoader.getSystemResource("Graphics/chanceCardH.jpg").toString());
			communityChestH = new Image(ClassLoader.getSystemResource("Graphics/communityChestH.jpg").toString());
			trophy = new Image(ClassLoader.getSystemResource("Graphics/trophy.png").toString());
			settingButton = new Image(ClassLoader.getSystemResource("Graphics/setting.png").toString());
			soundSettingButton = new Image(ClassLoader.getSystemResource("Graphics/soundSetting.png").toString());
			transparentSettingButton = new Image(
					ClassLoader.getSystemResource("Graphics/transparentSetting.png").toString());
			transparentSoundSettingButton = new Image(
					ClassLoader.getSystemResource("Graphics/transparentSoundSetting.png").toString());
			playerOneWins = new Image(ClassLoader.getSystemResource("Graphics/playerOneWins.png").toString());
			playerTwoWins = new Image(ClassLoader.getSystemResource("Graphics/playerTwoWins.png").toString());
			playerThreeWins = new Image(ClassLoader.getSystemResource("Graphics/playerThreeWins.png").toString());
			playerFourWins = new Image(ClassLoader.getSystemResource("Graphics/playerFourWins.png").toString());
			playAgain = new Image(ClassLoader.getSystemResource("Graphics/PlayAgain.png").toString());
			clickedPlayAgain = new Image(ClassLoader.getSystemResource("Graphics/clickedPlayAgain.png").toString());
			assetShowBG = new Image(ClassLoader.getSystemResource("Graphics/assetShowBG.png").toString());
			moneyShowBG = new Image(ClassLoader.getSystemResource("Graphics/moneyShowBG.png").toString());
			nameShowBG = new Image(ClassLoader.getSystemResource("Graphics/nameShowBG.png").toString());
			pullRoll = new Image(ClassLoader.getSystemResource("Graphics/pullRoll.png").toString());
			pushRoll = new Image(ClassLoader.getSystemResource("Graphics/pushRoll.png").toString());
			chance0 = new Image(ClassLoader.getSystemResource("Graphics/chance0.png").toString());
			chance1 = new Image(ClassLoader.getSystemResource("Graphics/chance1.png").toString());
			chance2 = new Image(ClassLoader.getSystemResource("Graphics/chance2.png").toString());
			chance3 = new Image(ClassLoader.getSystemResource("Graphics/chance3.png").toString());
			chance4 = new Image(ClassLoader.getSystemResource("Graphics/chance4.png").toString());
			chance5 = new Image(ClassLoader.getSystemResource("Graphics/chance5.png").toString());
			chance6 = new Image(ClassLoader.getSystemResource("Graphics/chance6.png").toString());
			chance7 = new Image(ClassLoader.getSystemResource("Graphics/chance7.png").toString());
			chance8 = new Image(ClassLoader.getSystemResource("Graphics/chance8.png").toString());
			chance9 = new Image(ClassLoader.getSystemResource("Graphics/chance9.png").toString());
			diceOne = new Image(ClassLoader.getSystemResource("Graphics/diceOne.png").toString());
			diceTwo = new Image(ClassLoader.getSystemResource("Graphics/diceTwo.png").toString());
			diceThree = new Image(ClassLoader.getSystemResource("Graphics/diceThree.png").toString());
			diceFour = new Image(ClassLoader.getSystemResource("Graphics/diceFour.png").toString());
			diceFive = new Image(ClassLoader.getSystemResource("Graphics/diceFive.png").toString());
			diceSix = new Image(ClassLoader.getSystemResource("Graphics/diceSix.png").toString());
			chest0 = new Image(ClassLoader.getSystemResource("Graphics/chest0.png").toString());
			chest1 = new Image(ClassLoader.getSystemResource("Graphics/chest1.png").toString());
			chest2 = new Image(ClassLoader.getSystemResource("Graphics/chest2.png").toString());
			chest3 = new Image(ClassLoader.getSystemResource("Graphics/chest3.png").toString());
			chest4 = new Image(ClassLoader.getSystemResource("Graphics/chest4.png").toString());
			chest5 = new Image(ClassLoader.getSystemResource("Graphics/chest5.png").toString());
			chest6 = new Image(ClassLoader.getSystemResource("Graphics/chest6.png").toString());
			chest7 = new Image(ClassLoader.getSystemResource("Graphics/chest7.png").toString());
			chest8 = new Image(ClassLoader.getSystemResource("Graphics/chest8.png").toString());
			chest9 = new Image(ClassLoader.getSystemResource("Graphics/chest9.png").toString());
			footstepSound = new AudioClip(ClassLoader.getSystemResource("Sounds/footstep.mp3").toExternalForm());
			buttonSound = new AudioClip(ClassLoader.getSystemResource("Sounds/button-11.wav").toExternalForm());
			alertSound = new AudioClip(ClassLoader.getSystemResource("Sounds/alert.mp3").toExternalForm());
			manPointLOLSound = new AudioClip(ClassLoader.getSystemResource("Sounds/manPointLOL.mp3").toExternalForm());
			epicWinSound = new AudioClip(ClassLoader.getSystemResource("Sounds/epicWin.mp3").toExternalForm());
			buttonLight = new AudioClip(ClassLoader.getSystemResource("Sounds/buttonLight.mp3").toExternalForm());
			fairySound = new AudioClip(ClassLoader.getSystemResource("Sounds/fairySound.mp3").toExternalForm());
			treasureSound = new AudioClip(ClassLoader.getSystemResource("Sounds/treasureSound.mp3").toExternalForm());
			babyCrySound = new AudioClip(ClassLoader.getSystemResource("Sounds/babyCry.mp3").toExternalForm());
			bankruptSound = new AudioClip(ClassLoader.getSystemResource("Sounds/bankRuptSound.mp3").toExternalForm());
			BGGameMusic = new MediaPlayer(
					new Media(ClassLoader.getSystemResource("Sounds/BGGameSceneMusic.mp3").toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
