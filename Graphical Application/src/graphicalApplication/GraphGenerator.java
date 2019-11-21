package graphicalApplication;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphGenerator extends JFrame{
	
	public static void drawSpiral(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		/*
		Line2D line1 = new Line2D.Float(100, 100, 300, 100);
		Line2D line2 = new Line2D.Float(300, 100, 300, 300);
		Line2D line3 = new Line2D.Float(300, 300, 100, 300);
		Line2D line4 = new Line2D.Float(100, 300, 100, 110);
		Line2D line5 = new Line2D.Float(100, 110, 290, 110);
		Line2D line6 = new Line2D.Float(290, 110, 290, 290);
		Line2D line7 = new Line2D.Float(290, 290, 110, 290);
		Line2D line8 = new Line2D.Float(110, 290, 110, 120);
		Line2D line9 = new Line2D.Float(110, 120, 280, 120);
		Line2D line10 = new Line2D.Float(280, 120, 280, 280);
		Line2D line11 = new Line2D.Float(280, 280, 120, 280);
		Line2D line12 = new Line2D.Float(120, 280, 120, 130);
		Line2D line13 = new Line2D.Float(120, 130, 270, 130);
		g2.draw(line1);
		g2.draw(line2);
		g2.draw(line3);
		g2.draw(line4);
		g2.draw(line5);
		g2.draw(line6);
		g2.draw(line7);
		g2.draw(line8);
		g2.draw(line9); 
		g2.draw(line10);
		g2.draw(line11);
		g2.draw(line12);
		g2.draw(line13);*/
		
		int startY = 100;
		int endX = 300; 
		int newY = 100; 
		int count = 0;
		
		for (int i = 2; i > 0; i--) {
			
			Line2D line1 = new Line2D.Float(newY, startY, endX, startY);
			Line2D line2 = new Line2D.Float(endX, startY, endX, endX);
			Line2D line3 = new Line2D.Float(endX, endX, startY, endX);
			Line2D line4 = new Line2D.Float(newY, endX, newY, startY);
			
			g2.draw(line1);
			count++;
			System.out.println("line " + count + " is (" + newY + ", " + startY + ", " + endX + ", " + startY + ")");
			g2.draw(line2);
			count++;
			System.out.println("line " + count + " is (" + endX + ", " + startY + ", " + endX + ", " + endX + ")");
			g2.draw(line3);
			count++;
			System.out.println("line " + count + " is (" + endX + ", " + endX + ", " + startY + ", " + endX + ")");
			newY = startY;
			startY += 10;
			g2.draw(line4);
			count++;
			System.out.println("line " + count + " is (" + newY + ", " + endX + ", " + newY + ", " + startY + ")");
			endX -= 10;
		} 
		
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		final int width = 400;
		final int height = 400;
		window.setSize(width, height);
		window.setTitle("Spiral Generator Viewer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent Graph = new JComponent() {
			
			public void paintComponent(Graphics graph) {
		
				drawSpiral(graph);
				
			}
			
		};
		
		window.add(Graph);
		window.setVisible(true);
		
	}
	
}