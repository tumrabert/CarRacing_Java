package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;




public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	public static Image myCar;
	public static Image othercar1,othercar2,othercar3,othercar4;
	public static Image coin_item;
	public static Image background;
	public static Image home;
	public static AudioClip crashSound;
	public static AudioClip coinSound;
	public static AudioClip bgSound;


	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		myCar = new Image(ClassLoader.getSystemResource("myCar.png").toString());
		
		othercar1 = new Image(ClassLoader.getSystemResource("othercar1.png").toString());
		othercar2 = new Image(ClassLoader.getSystemResource("othercar2.png").toString());
		othercar3 = new Image(ClassLoader.getSystemResource("othercar3.png").toString());
		othercar4 = new Image(ClassLoader.getSystemResource("othercar4.png").toString());
		coin_item = new Image(ClassLoader.getSystemResource("coin.png").toString());
		background = new Image(ClassLoader.getSystemResource("Background.png").toString());
		home = new Image(ClassLoader.getSystemResource("Home.png").toString());
		crashSound = new AudioClip(ClassLoader.getSystemResource("crash.wav").toString());
		coinSound = new AudioClip(ClassLoader.getSystemResource("coin.wav").toString());
		bgSound = new AudioClip(ClassLoader.getSystemResource("bgsound.wav").toString());
		
	}

	public void add(IRenderable entity) {
		entities.add(entity);

	}

	
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
	

}
