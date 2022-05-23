/*
 * Class: CMSC 201
 * Project 5
 * Noah Cil
 * 5/17/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: Program that simulates a car racing, animated inside of a window
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project5;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/** This class simulates a car racing inside of a JavaFX stage
 *  @author Noah Cil
 *  @version 1.0
 */
public class Project5 extends Application {

	/** Data field: speed of animation in milliseconds */
	private static int speed = 5000;
	
	/** 
	 * Makes car, sets stage, creates animation for car, 
	 * and implements events for a button and key presses 
	 */
	@Override
	public void start(Stage primaryStage) {
		//sets up main parents and the button
		Pane root = new Pane();
		Group car = new Group();
		Button pausePlayButton = new Button("Pause");
		//this number is the width of the button when it has the text "Pause"
		//I set it as preferred width so that button doesn't change sizes when text is changed
		pausePlayButton.setPrefWidth(46.984375); 
		Pane buttonPane = new Pane(pausePlayButton);
		//this moves button so it's on the very right edge of the window
		buttonPane.setLayoutX(253);
		root.getChildren().addAll(car, buttonPane);
		
		//making different parts of the car and putting them all into the car group
		Polygon carTop = new Polygon(20, 120, 30, 120, 40, 130, 10, 130);
		carTop.setFill(Color.DEEPSKYBLUE);
		Rectangle carBody = new Rectangle(0, 130, 50, 10);
		carBody.setFill(Color.DARKTURQUOISE);
		Circle wheel1 = new Circle(15, 145, 5, Color.BLACK);
		Circle wheel2 = new Circle(35, 145, 5, Color.BLACK);
		Polygon carLabelBackground = new Polygon(46, 132, 46, 138, 3, 138, 7, 135, 3, 132);
		carLabelBackground.setFill(Color.CRIMSON);
		Text carLabel = new Text(7, 137, "HOTWHEELS");
		carLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 6));
		carLabel.setFill(Color.GOLD);
		car.getChildren().addAll(carTop, carBody, wheel1, wheel2, carLabelBackground, carLabel);
		
		//setting up the car animation
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(speed));
		//line along the bottom of the window, starts and ends before half of the car's width
		Line path = new Line(25, 135, 275, 135);
		pt.setPath(path);
		pt.setNode(car);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		//pause play button event handler that detects button 
		//presses to pause/play the animation
		pausePlayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (pausePlayButton.getText().equals("Pause")) {
					pausePlayButton.setText("Play");
					pt.pause();
				}
				else {
					pausePlayButton.setText("Pause");
					pt.play();
				}
				
			}
		});
		
		//speed label that goes above the speed bar
		Text speedLabel = new Text("SPEED");
		Pane speedLabelPane = new StackPane(speedLabel);
		speedLabel.setFont(Font.font("System", FontWeight.BOLD, null, 20));
		speedLabel.setTranslateX(150-(speedLabel.getBoundsInLocal().getWidth()/2));
		root.getChildren().add(speedLabelPane);
		
		//speed bar which graphically displays speed of car
		Rectangle[] speedBars = new Rectangle[9];
		speedBars[0] = new Rectangle(20, 30, 20, 40);
		speedBars[0].setFill(Color.RED);
		root.getChildren().add(speedBars[0]);
		for (int i = 1; i < 9; i++) {
			speedBars[i] = new Rectangle(speedBars[i-1].getX()+30, 30, 20, 40);
			
			if (i < 3)
				speedBars[i].setFill(Color.RED);
			else if (i < 6) {
				speedBars[i].setFill(Color.YELLOW);
				if (i == 5)
					speedBars[i].setFill(Color.GREY);
			}
			else
				speedBars[i].setFill(Color.GREY);
			
			root.getChildren().add(speedBars[i]);
		}
		
		//detects key presses and speeds up or slows down the car if key pressed
		//was up or down arrow. also adjusts speed bar graphic accordingly
		System.out.println("speed is " + speed);
		pausePlayButton.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN: speed = (speed < 9000) ? speed+1000 : 9000;
						   pt.setDuration(Duration.millis(speed));
						   //greying out correct bar
						   speedBars[9-(speed/1000)+1].setFill(Color.GREY);
						   System.out.println("Slowing down! " + speed);
						   //stops animation to play it at the new speed
						   pt.stop();
						   //if else to prevent animation from automatically playing if 
						   //it has been paused by the user
						   if (pausePlayButton.getText().equals("Pause"))
							   pt.play();
						   else
							   pt.pause();
						   break;
				case UP:   speed = (speed > 1000) ? speed-1000 : 1000;
						   pt.setDuration(Duration.millis(speed));
						   //colors correct bar with appropriate color
						   speedBars[9-(speed/1000)].setFill((9-(speed/1000)+1 < 4 ? Color.RED : 
							   (9-(speed/1000)+1 < 7 ? Color.YELLOW : Color.GREEN.brighter())));
						   System.out.println("Speeding up! " + speed);
						   //stops animation to play it at the new speed
						   pt.stop();
						   //if else to prevent animation from automatically playing if 
						   //it has been paused by the user
						   if (pausePlayButton.getText().equals("Pause"))
							   pt.play();
						   else
							   pt.pause();
						   break;
				default:   System.out.println("invalid key press");
			}
		});
		
		//sets scene and displays stage
		Scene scene = new Scene(root, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("FORZA HORIZON 0.5");
		primaryStage.show();
		
		
	}

	/** launches a standalone application */
	public static void main(String[] args) {
		launch(args);
	}
}