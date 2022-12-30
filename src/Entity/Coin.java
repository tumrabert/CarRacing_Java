package Entity;

import java.util.Random;

import EntityBase.Entity;
import EntityBase.IncreaseCoin;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Coin extends Entity implements IncreaseCoin{

	public Coin() {
		// TODO Auto-generated constructor stub
		
		int[] items = new int[] {60,180,290,410,520};
		int rnd = new Random().nextInt(items.length);

		this.setX1(items[rnd]);
		this.setY1(0);
		this.setX2(x1+75);
		this.setY2(y1+75);
	}
	
	public void movement() {
		this.y1 += 1.5;
		this.y2 += 1.5;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.coin_item, x1, y1);
	}

	@Override
	public void addcoin(PlayerCar player) {
		// TODO Auto-generated method stub
		GameLogic.addCoincount(1);
		RenderableHolder.coinSound.play();
		setDestroyed(true);
	}
	


}
