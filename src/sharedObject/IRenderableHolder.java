package sharedObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import application.Main;
import application.StateScene;
import javafx.scene.image.Image;

public class IRenderableHolder {

	private static StateScene state;
	private static IRenderableHolder instance;
	private static Comparator<IRenderable> comparator;
	private ArrayList<IRenderable> entities;
	public static Image boardBackground;
	public static Image freeParking;
	public static Image manPoint;
	public static Image start;
	public static Image registration;
	public static Image blackPawn;
	public static Image whitePawn;
	public static Image woodenBg;

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
			woodenBg = new Image(new FileInputStream("./res/woodenBg.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static IRenderableHolder getInstance() {
		return instance;
	}

	public static void update() {
		state = Main.getState();
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
