package jeuDePuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewM  extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JLabel label = new JLabel("JEU DE PUZZLE");
	JButton JB1 = new JButton("Droite");
	JButton JB2 = new JButton("Gouche");
	JButton JB3 = new JButton("Bas");
	JButton JB4 = new JButton("haut");
	
	public ViewM() {
		this.setTitle("JEU");
		this.setSize(350, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true); //On interdit la redimensionnement de la fenêtre
		
		
		this.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
	    jp1.setLayout(new FlowLayout());
	    jp1.add(label);
	    this.add(jp1,BorderLayout.NORTH);
	    JPanel jp2 = new JPanel();
	    jp2.setLayout(new FlowLayout());
	    jp2.add(JB1);jp2.add(JB2);jp2.add(JB3);jp2.add(JB4);
	  	this.add(jp2,BorderLayout.SOUTH);		
		
	  	Panel pan = new Panel();
	  	
	    this.add(pan, BorderLayout.CENTER);
	    
	    this.setVisible(true);
	}
	
}
