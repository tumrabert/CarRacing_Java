package Entity;

import EntityBase.Entity;
import EntityBase.HitCar;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;
import java.util.Random;
import javafx.scene.image.Image;

public class OtherCar extends Entity implements HitCar{
	

	public OtherCar() {
		// TODO Auto-generated constructor stub
		int[] items = new int[] {60,180,290,410,520};
		int rnd = new Random().nextInt(items.length);
		
		this.setX1(items[rnd]);
		this.setY1(0);
		this.setX2(x1+60);
		this.setY2(y1+130);
		this.rndIndexCar= new Random().nextInt(4);
	}
	
	
	public void damage(PlayerCar player){
		RenderableHolder.crashSound.play();
		setDestroyed(true);
	}
	
	public void movement(double d) {
		this.y1 += 1*d;
		this.y2 += 1*d;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image[] items = new Image[] {RenderableHolder.othercar1,RenderableHolder.othercar2,RenderableHolder.othercar3,RenderableHolder.othercar4};
		gc.drawImage(items[rndIndexCar], x1, y1);
	}

}
