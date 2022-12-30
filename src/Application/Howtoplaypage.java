package Application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Howtoplaypage extends GridPane{
	public Button close;
	
	public Howtoplaypage() {
		super();
		setAlignment(Pos.CENTER);
		DropShadow shadow = new DropShadow();
		Label topic = new Label("How 2 Play");
		topic.setFont(new Font("Times New Roman", 50));
		topic.setTextFill(Color.CHOCOLATE);
		add(topic, 0, 0);
		
		Label description1 = new Label(" Control movement with WASD button.\n"
				+ " Avoid from crashing with other car\n and try to collecting the coin");
		description1.setFont(new Font(" Times New Roman", 20));
		description1.setTextFill(Color.BLACK);
		add(description1, 0, 1);
		
		
		Label description3 = new Label(" Collecting the coin as much as you can!!!!");
		description3.setFont(new Font("Times New Roman", 20));
		description3.setTextFill(Color.RED);
		add(description3, 0, 3);
		
		close = new Button("Close");
		close.setFont(new Font("Times New Roman",24));
		close.setPrefSize(120,40);
		
		
		close.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		close.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  close.setEffect(shadow);
		          }
		        });
		close.addEventHandler(MouseEvent.MOUSE_EXITED,
	        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  close.setEffect(null);
	          }
	        });
		
		HBox hbtn = new HBox();
		hbtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbtn.getChildren().add(close);
		
		
		
		add(hbtn, 5, 6);
	}
}
