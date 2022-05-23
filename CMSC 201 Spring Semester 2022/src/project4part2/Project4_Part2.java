/*
 * Class: CMSC 201
 * Project 4 Part 2
 * Noah Cil
 * 5/16/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: Program that opens a window which displays the sine and cosine graphs roughly within the interval [-3π, 3π]
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */
//for figuring out how to pass a trig function as an argument, I used Polygnome's answer on stack overflow:
//https://stackoverflow.com/questions/63097309/passing-mathematical-function-as-function-argument

package project4part2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.function.DoubleUnaryOperator; //thing for passing trig functions as arguments

public class Project4_Part2 extends Application {
	
	//Function with code that was provided in project instructions. I made this a function so 
	//I wouldn't have to write out the code twice
	private static Polyline makeGraph(DoubleUnaryOperator trigFunc, Color stroke) {
		Polyline polyline = new Polyline();
		polyline.setStroke(stroke);
		
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 50;
		for (int x = -170; x <= 170; x++) {
			list.add(x + 200.0);
			list.add(100 - scaleFactor * trigFunc.applyAsDouble((x / 100.0) * 2 * Math.PI));
		}
		
		return polyline;
	}
	
	@Override
	public void start(Stage primaryStage) {
		//Making two panes was necessary because otherwise the sine and cosine graphs or 
		//the axes would not center properly
		Pane graphs = new StackPane();
		Pane axes = new Pane();
		graphs.getChildren().addAll(axes);
		
		//this makes the axes, arrows, and labels for the axes
		Line xAxis = new Line(20, 150, 480, 150);
		Line xArrowLeft = new Line(450, 140, 480, 150);
		Line xArrowRight = new Line(450, 160, 480, 150);
		Text xLabel = new Text(465, 130, "X");
		Line yAxis = new Line(250, 250, 250, 50);
		Line yArrowLeft = new Line(240, 80, 250, 50);
		Line yArrowRight = new Line(260, 80, 250, 50);
		Text yLabel = new Text(265, 65, "Y");
		axes.getChildren().addAll(xAxis, xArrowLeft, xArrowRight, xLabel, yAxis, yArrowLeft, yArrowRight, yLabel);
		
		//This makes and places the number labels along the X axis. I realized the graph was 
		//going up to 3 PI on each side so that's why there are 7 labels instead of 5
		axes.getChildren().addAll(new Text(90, 160, "-3\u03c0"), new Text(135, 160, "-2\u03c0"), 
				new Text(190, 160, "-\u03c0"), new Text(250, 160, "0"), new Text(295, 160, "\u03c0"), 
				new Text(340, 160, "2\u03c0"), new Text(390, 160, "3\u03c0"));
		
		//adding the sine and cosine graphs to the graphs stackpane
		graphs.getChildren().addAll(makeGraph(Math::sin, Color.RED), makeGraph(Math::cos, Color.BLUE));
		Scene scene = new Scene(graphs, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Noah Cil Project 4");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
