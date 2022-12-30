package Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import javafx.event.EventHandler;

import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;


public class Homepage extends GridPane {
	public Button start;
	public Button how;
	public Button exit;

	
	public Homepage() {
		super();
		setAlignment(Pos.CENTER);
		setPadding(new Insets(25, 25, 25, 25));
		setHgap(10);
		setVgap(10);
		
		DropShadow shadow = new DropShadow();
		Label topic = new Label("Car Racing");
		topic.setTextFill(Color.RED);
		topic.setFont(new Font("Times New Roman", 80));
		
		add(topic, 0, 0);
		
		start = new Button("Start");
		start.setFont(new Font("Times New Roman",24));
		start.setStyle("  -fx-background-color: green;-fx-text-fill: white;");
		start.setPrefSize(500,100);
		
		start.addEventHandler(MouseEvent.MOUSE_ENTERED,
			        new EventHandler<MouseEvent>() {
			          @Override
			          public void handle(MouseEvent e) {
			            start.setEffect(shadow);
			          }
			        });
		start.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		            start.setEffect(null);
		          }
		        });
		
		add(start, 0, 1);
		
		how = new Button("How 2 play");
		how.setFont(new Font("Times New Roman",24));
		how.setPrefSize(500,100);
		how.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");
		how.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  how.setEffect(shadow);
		          }
		        });
		how.addEventHandler(MouseEvent.MOUSE_EXITED,
	        new EventHandler<MouseEvent>() {
	          @Override
	          public void handle(MouseEvent e) {
	        	  how.setEffect(null);
	          }
	        });
		
		add(how, 0, 2); 
		
		exit = new Button("Exit");
		exit.setFont(new Font("Times New Roman",24));
		exit.setPrefSize(500,100);
		exit.setStyle("-fx-background-color: red; -fx-text-fill: white;");
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
		add(exit, 0, 3);
		
	}
}
