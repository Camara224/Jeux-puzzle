package jeuDePuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final int length= 3;
	private static final int width = 3;
	
	private static final int CELL_SIZE = 80;//Pixels
	//private Font _biggerFont;
	private static final long serialVersionUID = 1L;
	
	
	public void paintComponent(Graphics g) {
	//x1, y1, whidth, height		
		
		super.paintComponent(g);
		for (int r=0; r<length; r++) {
			for (int c=0; c<width; c++){
				int x = c * CELL_SIZE;
				int y = r * CELL_SIZE;
			g.drawRect(x+2, y+2, CELL_SIZE-2, CELL_SIZE-2);
			//g.setFont(_biggerFont);
				
				}
			}
		
		}
	
}
