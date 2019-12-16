package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class IRenderableHolder {
	private static IRenderableHolder instance;
	private static Comparator<IRenderable> comparator;
	private ArrayList<IRenderable> entities;
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
	public static AudioClip footstepSound;
	public static AudioClip buttonSound;
	public static AudioClip alertSound;
	public static AudioClip manPointLOLSound;
	public static AudioClip epicWinSound;
	public static AudioClip buttonLight;
	public static AudioClip babyCrySound;
	public static AudioClip fairySound;
	public static AudioClip treasureSound;
	public static AudioClip BGGameMusic;
	static {
		comparator = new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if (o1.getZ() < o2.getZ()) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		loadResource();
	}

	public IRenderableHolder() {
		entities = new ArrayList<IRenderable>();
	}

	public void add(IRenderable i) {
		entities.add(i);
		Collections.sort(entities, comparator);
	}

	private static void loadResource() {
		instance = new IRenderableHolder();
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
			footstepSound = new AudioClip(ClassLoader.getSystemResource("Sounds/footstep.mp3").toExternalForm());
			footstepSound.setVolume(0.5);
			buttonSound = new AudioClip(ClassLoader.getSystemResource("Sounds/button-11.wav").toExternalForm());
			buttonSound.setVolume(0.5);
			alertSound = new AudioClip(ClassLoader.getSystemResource("Sounds/alert.mp3").toExternalForm());
			alertSound.setVolume(0.7);
			manPointLOLSound = new AudioClip(ClassLoader.getSystemResource("Sounds/manPointLOL.mp3").toExternalForm());
			epicWinSound = new AudioClip(ClassLoader.getSystemResource("Sounds/epicWin.mp3").toExternalForm());
			buttonLight = new AudioClip(ClassLoader.getSystemResource("Sounds/buttonLight.mp3").toExternalForm());
			buttonLight.setVolume(0.7);
			fairySound = new AudioClip(ClassLoader.getSystemResource("Sounds/fairySound.mp3").toExternalForm());
			fairySound.setVolume(0.7);
//			babyCrySound = new AudioClip(ClassLoader.getSystemResource("Sounds/babycry.mp3").toExternalForm());
			treasureSound = new AudioClip(ClassLoader.getSystemResource("Sounds/treasureSound.mp3").toExternalForm());
			treasureSound.setVolume(0.7);
			BGGameMusic = new AudioClip(ClassLoader.getSystemResource("Sounds/BGGameSceneMusic.mp3").toExternalForm());
			BGGameMusic.setVolume(0.7);
			babyCrySound = new AudioClip(ClassLoader.getSystemResource("Sounds/babyCry.mp3").toExternalForm());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static IRenderableHolder getInstance() {
		return instance;
	}

	public static void update() {
		for (int i = 0; i < instance.entities.size(); i++) {
			if (!instance.entities.get(i).isVisible()) {
				instance.entities.remove(instance.entities.get(i));
			}
		}
	}

	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
}
