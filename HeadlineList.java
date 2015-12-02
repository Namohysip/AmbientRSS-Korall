package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HeadlineList extends JPanel {

	private ArrayList<String> entries = null;
	private ArrayList<URL> links = null;
	private int feed = -1;

	public ArrayList<String> getEntries() {
		return entries;
	}

	public ArrayList<URL> getLinks() {
		return links;
	}

	public HeadlineList(int feed) {
		super();
		entries = Interpreter.getEntries(feed);
		links = Interpreter.getLinks(feed);
		this.feed = feed;
		this.setFont(new Font("Times New Roman", 1, 18));
	}

	/**
	 * Iterates through the list of circles to be drawn and calls drawCircle.
	 */
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("New stories: " + Integer.toString(entries.size()), 250, 20);
		for (int i = 0; i < entries.size(); i++) {
			String entry = Integer.toString(i+1) + ".   " + entries.get(i);
			if (entry.length() > 70) {
				entry = entry.substring(0, 67) + "...";
			}
		    if(i % 2 == 1){
		    	g.setColor(new Color(200,200,200));
		    	g.fillRect(0, 25 * i + 25, 1000, 25);
		    	g.setColor(Color.BLACK);
		    }
		    
			g.drawString(entry, 10, 25 * i + 40);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, entries.size() * 25 + 50);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
