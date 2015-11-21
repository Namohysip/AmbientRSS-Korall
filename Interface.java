package main;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;

public class Interface {

	
	

	private static final int GAP = 1;
	private static Interface i = new Interface();
	private static DrawingBoard drawingBoard = new DrawingBoard();

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
