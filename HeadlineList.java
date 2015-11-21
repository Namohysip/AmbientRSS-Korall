package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HeadlineList extends JPanel {

	private ArrayList<String> entries = null;
	private ArrayList<URL> links = null;

	public HeadlineList(int feed) {
		super();
		entries = Interpreter.getEntries(feed);
		links = Interpreter.getLinks(feed);
	}

	/**
	 * Iterates through the list of circles to be drawn and calls drawCircle.
	 */
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString(entries.get(0), 50, 50);
		System.out.println(entries.get(0));
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
