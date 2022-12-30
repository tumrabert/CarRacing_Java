package Application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Closegamepage extends GridPane {
	public Button exit;
	
	public Closegamepage() {
		super();
		setAlignment(Pos.BOTTOM_RIGHT);
		setPadding(new Insets(25, 25, 25, 25));
		DropShadow shadow = new DropShadow();
		
		exit = new Button("Exit");
		exit.setFont(new Font("Times New Roman",24));
		exit.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		exit.setPrefSize(120,40);
		exit.setVisible(false);
		
		exit.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  exit.setEffect(shadow);
		          }
		        });
		exit.addEventHandler(MouseEvent.MOUSE_EXITED,
	        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  exit.setEffect(null);
	          }
	        });
		
		add(exit, 0, 0);
	}
}
