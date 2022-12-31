package program;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Panel extends JPanel {
	
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 700;
	
	public static int numberOfBalls = 10;
	
	Random r = new Random();
	
	Ball[] ball = new Ball[20];
	
	public Panel() {
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		for (int i = 0; i < numberOfBalls; i++) {
			ball[i] = new Ball(r.nextInt(0, WINDOW_WIDTH), r.nextInt(0, WINDOW_HEIGHT));
			
		}
		
		
		
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(100, 100, 100));;
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		g.setColor(new Color(100, 0, 0));
		for (int i = 0; i < ball.length; i++) {
			try {
				g.fillOval((int)ball[i].getX(), (int)ball[i].getY(), 50, 50);
			} catch (NullPointerException e) {
				;
			}
		}
	}
	
	public void updateWindow() {
		while (true) {
			for (int i = 0; i < ball.length; i++) {
				try {
					ball[i].ballGravity();
				} catch (NullPointerException e) {
					;
				}
			}
			
			for (int i = 0; i < ball.length; i++) {
				try {
					for (int j = 0; j < ball.length; j++) {
						if (i != j) {
							ball[i].checkBallCollision(ball[j]);
						}
					}
				} catch (NullPointerException e) {
					;
				}
			}
			
			repaint();
		}
	}
}
