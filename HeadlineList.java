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
	private int feed = -1;

	public ArrayList<String> getEntries(){
		return entries;
	}
	
	public ArrayList<URL> getLinks(){
		return links;
	}
	public HeadlineList(int feed) {
		super();
		entries = Interpreter.getEntries(feed);
		links = Interpreter.getLinks(feed);
		this.feed = feed;
	}

	/**
	 * Iterates through the list of circles to be drawn and calls drawCircle.
	 */
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		for(int i = 0; i < entries.size(); i++){
			String entry = entries.get(i);
			if (entry.length() > 70){
				entry = entry.substring(0, 67) + "...";
			}
			g.drawString(entry, 10, 20*i + 40);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
