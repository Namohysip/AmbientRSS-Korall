package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
	 * DrawingBoard Class for adding and displaying circles.
	 *
	 */
	class DrawingBoard extends JPanel {

		/*
		 * The height and width of the window, currently set at 300, 300. May be
		 * resized in the future.
		 */
		private static final int WIDTH = 100;
		private static final int HEIGHT = 500;
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

			circles.add(new MyCircle(15, 15, radius, new Color(0,1,0,0.1f),0));
			circles.add(new MyCircle(15, 115, radius, new Color(0,0,1,0.1f),1));
			circles.add(new MyCircle(15, 215, radius, new Color(1,1,0,0.1f),2));
			circles.add(new MyCircle(15, 315, radius, new Color(1,0,0,0.1f),3));
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
			revalidate();
			setVisible(false);
			setVisible(true);
		}
	}
