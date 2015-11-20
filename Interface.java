package main;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

public class Interface {

	/**
	 * DrawingBoard Class for adding and displaying circles.
	 *
	 */
	class DrawingBoard extends JPanel {

		/*
		 * The height and width of the window, currently set at 300, 300. May be
		 * resized in the future.
		 */
		private static final int WIDTH = 150;
		private static final int HEIGHT = 150;
		private int radius = 10;

		public int getWindowWidth() {
			return WIDTH;
		}

		public int getWindowHeight() {
			return HEIGHT;
		}

		// Holds the circles to redraw
		private List<MyCircle> circles;

		/**
		 * Adds Circles to the List for drawing Needs a way to resize radius and
		 * change color, getters & setters?
		 */
		public void addCircles() {

			circles.add(new MyCircle(100, 100, radius, new Color(0,1,0,0.1f),0));
			circles.add(new MyCircle(15, 15, radius, new Color(0,0,1,0.1f),1));
			circles.add(new MyCircle(100, 15, radius, new Color(1,1,0,0.1f),2));
			circles.add(new MyCircle(15, 100, radius, new Color(1,0,0,0.1f),3));
			// circles.add(new MyCircle(90, 90, radius, Color.ORANGE));
		}

		/*
		 * DrawingBoard constructor, creates the list and calls addCircles when
		 * created.
		 */
		public DrawingBoard() {
			super();
			circles = new ArrayList<MyCircle>();
			addCircles();
			setOpaque(true);
		}

		/**
		 * Sets the height and width of the window. Tentatively set at 300, 300
		 */
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}

		/**
		 * Iterates through the list of circles to be drawn and calls
		 * drawCircle.
		 */
		protected void paintComponent(Graphics g) {
			// super.paintComponent(g);
			//circles.get(0).updateCircles();
			for (MyCircle circle : circles) {
				circle.updateCircles();
				circle.drawCircle(g);
			}
		}
		
		public void setRadius(int circle, int r){
			circles.get(circle).setRadius(r);
		}
	}

	class MyCircle {

		private int trueX;
		private int trueY;
		private int x;
		private int y;
		private Color backgroundColour;
		private int radius;
		private int feed;
		private String[] titles = {"HNN","NPR","BBC","CNN"};

		public void updateCircles() {
			radius = Interpreter.HowManyEntries(feed);
			x = trueX - radius / 4;
			y = trueY - radius / 4;
			if(radius < 1){
				radius = 1;
			}
		}

		public void setRadius(int i) {
			radius = i;
			x = trueX - radius / 2;
			y = trueY - radius / 2;
		}

		public MyCircle(int x, int y, int radius, Color backgroundColour, int feed) {
			this.trueX = x;
			this.trueY = y;
			this.radius = radius;

			this.x = trueX - radius / 2;
			this.y = trueY - radius / 2;
			this.backgroundColour = backgroundColour;
			this.feed = feed;
		}

		/**
		 * drawCircle, draws a circle with the given x, y position, radius, and
		 * color.
		 * 
		 */
		public void drawCircle(Graphics g) {
			g.setColor(backgroundColour);
			g.fillOval(x, y, radius, radius);
			g.setColor(new Color(0,0,0,0.1f));
			g.drawString(titles[feed], x+radius/4, (int) (y+radius/1.5));
		}

	}

	private static final int GAP = 1;
	private static Interface i = new Interface();
	private static DrawingBoard drawingBoard = i.new DrawingBoard();

	public static DrawingBoard getDrawingBoard() {
		return drawingBoard;
	}

	private static void displayGUI() {
		JFrame frame = new JFrame("AmbientRSS - Korall");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
		JPanel contentPane = new JPanel();
		drawingBoard.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
		contentPane.add(drawingBoard);
		contentPane.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
		frame.setContentPane(drawingBoard);
		frame.pack();
		frame.addMouseListener(new MouseManager());
		frame.setAlwaysOnTop(true);
		frame.setTitle("Multi-News-Network");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(0, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		ArrayList<URL> list = new ArrayList<URL>();
		try {
			list.add(new URL(
					"http://www.hawaiinewsnow.com/Global/category.asp?C=3497&clienttype=rss"));

			Interpreter.newFeed();
			list.add(new URL( "http://www.npr.org/rss/rss.php?id=1001"));
			Interpreter.newFeed();
			list.add(new URL( "http://feeds.bbci.co.uk/news/rss.xml"));
			Interpreter.newFeed();
			list.add(new URL( "http://rss.cnn.com/rss/cnn_topstories.rss"));
			Interpreter.newFeed();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gatherer.setURLs(list);
		refresher(0);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Interface.displayGUI();
			}
		};
		EventQueue.invokeLater(runnable);
		while (true) {
			refresher(1 * 1000);
			//drawingBoard.repaint();
			drawingBoard.setVisible(false);
			drawingBoard.setVisible(true);
		}

	}

	public static void refresher(long cycle) {
		long lastCheck = System.currentTimeMillis();
		while (lastCheck + cycle > System.currentTimeMillis()) {

		}
		Interpreter.setInfo();
	}

}
