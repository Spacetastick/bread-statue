package miscellaneous;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameWindows extends JComponent{
	
	public void paintComponent (Graphics g) {
		//recover Graphics 2D
		Graphics2D g2 = (Graphics2D) g;
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		box.translate(15, 25);
		g2.draw(box);
		}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Frame");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
