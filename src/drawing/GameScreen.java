package drawing;


import java.util.ConcurrentModificationException;

import logic.GameLogic;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import javafx.scene.input.KeyEvent;

public class GameScreen extends Canvas {

	public GameScreen(double width, double height) {
		super(width, height);
		addListener();
	}

	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
		this.setOnKeyReleased((KeyEvent event) -> {
			
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.clearRect(0, 0,640, 960);
		gc.setFill(Color.RED);
		gc.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 40));
		gc.fillText("Coin : " + GameLogic.getCoincount(), 40, 40);
		try {
			for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
				if (entity.isVisible() && !entity.isDestroyed()) {
					entity.draw(gc);
				}
			}
		} catch(ConcurrentModificationException e) {}
	}

}
