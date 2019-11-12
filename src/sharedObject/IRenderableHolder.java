package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import application.Main;
import application.StateScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IRenderableHolder {

	private static StateScene state;
	private static IRenderableHolder instance;
	private static Comparator<IRenderable> comparator;
	private ArrayList<IRenderable> entities;
	public static ImageView board;

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
		board = new ImageView(new Image("./resource/Monopoly Board.jpg"));
	}

	public static IRenderableHolder getInstance() {
		return instance;
	}

	public static void update() {
		state = Main.getState();
		for (int i = 0; i < instance.entities.size(); i++) {
			if (!instance.entities.get(i).isVisible() || instance.entities.get(i).getState() != state) {
				instance.entities.remove(instance.entities.get(i));
			}
		}
	}

	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
}
