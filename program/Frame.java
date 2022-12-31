package program;

import javax.swing.JFrame;
import java.awt.*;

public class Frame extends JFrame {
	
	Panel panel = new Panel();
	
	public Frame() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel);
		this.pack();
		
		panel.updateWindow();
	}
}
