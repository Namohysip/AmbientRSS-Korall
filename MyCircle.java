package main;

import java.awt.Color;
import java.awt.Graphics;

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
			radius = Interpreter.HowManyEntries(feed) * 3;
			if(radius < 10){
				if (radius != 0){
					radius = 10;
				}
			}
			x = trueX - radius / 4;
			y = trueY - radius / 4;
			backgroundColour = new Color(backgroundColour.getRed() / 255f, backgroundColour.getGreen() / 255f, backgroundColour.getBlue() / 255f, (float) radius / 200f);
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
		    if(radius > 0){
		    	g.drawString(titles[feed], x+radius/4, (int) (y+radius/1.5));
		    }
		}

	}
