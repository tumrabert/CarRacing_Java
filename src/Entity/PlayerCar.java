package Entity;

import EntityBase.Entity;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class PlayerCar extends Entity {
	private static int speed = 5;
	
	
	public PlayerCar(double x, double y) {
		this.setX1(x);
		this.setY1(y);
		this.setX2(x+65);
		this.setY2(y+135);
	}
	
	private void move(int angle) {
		if(x1 < 80 ) {
			x1= 80 ;
		} else if(x1 > 550) {
			x1 = 550 ;
		} else if(y1 < 50) {
			y1 = 50 ;
		} else if(y1 > 900) {
			y1 = 900 ;
		}
			this.x1 += Math.cos(Math.toRadians(angle)) * speed;
			this.y1 += Math.sin(Math.toRadians(angle)) * speed*1.5;
			this.x2 += Math.cos(Math.toRadians(angle)) * speed;
			this.y2 += Math.sin(Math.toRadians(angle)) * speed*1.5;
	}
	
	public void update() {

		if (InputUtility.getKeyPressed(KeyCode.W)) {
			move(270);
		}
		if (InputUtility.getKeyPressed(KeyCode.A)) {
			move(180);
		}
		if (InputUtility.getKeyPressed(KeyCode.S)) {
			move(90);
		}if (InputUtility.getKeyPressed(KeyCode.D)) {
			move(0);
		}
	}

	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.myCar, x1, y1);
	}

}
