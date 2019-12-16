package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;

public class IRenderableHolder {

	private static IRenderableHolder instance;
	private static Comparator<IRenderable> comparator;
	private ArrayList<IRenderable> entities;
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
			boardBackground = new Image(new FileInputStream("./res/gearBackground3.png"));
			registration = new Image(new FileInputStream("./res/registrationRoom.png"));
			freeParking = new Image(new FileInputStream("./res/freeParking.png"));
			manPoint = new Image(new FileInputStream("./res/manPoint.png"));
			start = new Image(new FileInputStream("./res/start.png"));
			blackPawn = new Image(new FileInputStream("./res/blackPawn.png"));
			whitePawn = new Image(new FileInputStream("./res/whitePawn.png"));

			startSceneBackground = new Image(new FileInputStream("./res/startSceneBackground.png"));
			startButton = new Image(new FileInputStream("./res/startButton.png"));
			clickedStartButton = new Image(new FileInputStream("./res/clickedStartButton.png"));
			onePlayerButton = new Image(new FileInputStream("./res/onePlayerButton.png"));
			twoPlayerButton = new Image(new FileInputStream("./res/twoPlayerButton.png"));
			threePlayerButton = new Image(new FileInputStream("./res/threePlayerButton.png"));
			fourPlayerButton = new Image(new FileInputStream("./res/fourPlayerButton.png"));
			clickedOnePlayer = new Image(new FileInputStream("./res/clickedOnePlayer.png"));
			clickedTwoPlayer = new Image(new FileInputStream("./res/clickedTwoPlayer.png"));
			clickedThreePlayer = new Image(new FileInputStream("./res/clickedThreePlayer.png"));
			clickedFourPlayer = new Image(new FileInputStream("./res/clickedFourPlayer.png"));

			woodenBg = new Image(new FileInputStream("./res/woodenBg.jpg"));
			chanceCardV = new Image(new FileInputStream("./res/chanceCardV.jpg"));
			communityChestV = new Image(new FileInputStream("./res/communityChestV.jpg"));
			chanceCardH = new Image(new FileInputStream("./res/chanceCardH.jpg"));
			communityChestH = new Image(new FileInputStream("./res/communityChestH.jpg"));
			trophy = new Image(new FileInputStream("./res/trophy.png"));

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
