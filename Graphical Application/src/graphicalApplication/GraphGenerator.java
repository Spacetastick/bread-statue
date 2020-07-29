package graphicalApplication;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GraphGenerator extends JFrame{
	
	public static void drawSpiral(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		int B = 100;
		int C = 300; 
		int A = 100; 
		boolean initial = true;
		
		for (int i = 11; i > 0; i--) {
			Line2D line1 = new Line2D.Float(A, B, C, B);
			Line2D line2 = new Line2D.Float(C, B, C, C);
			Line2D line3 = new Line2D.Float(C, C, B, C);

			if (initial) {
				Line2D line4 = new Line2D.Float(A, C, A, B+10);

				g2.draw(line1);
				g2.draw(line2);
				g2.draw(line3);
				g2.draw(line4);
				B+=10;
				C -= 10;
				initial = false;
			} 
			else { 
				Line2D line4 = new Line2D.Float(A, C+10, A, B);
				
				g2.draw(line1);
				g2.draw(line2);
				g2.draw(line3);
				A = B;
				B += 10;
				g2.draw(line4);
				C -= 10;
			}
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