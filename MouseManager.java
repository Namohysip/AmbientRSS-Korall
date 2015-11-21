/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Noah Higa
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener {

	private static boolean active = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int height = Interface.getDrawingBoard().getHeight();
		int width = Interface.getDrawingBoard().getWidth();
		System.out.println("Mouse clicked!");
		if (!active) {
			if (e.getX() < width / 2) {
				if (e.getY() < height / 2) {
					// do stuff with the blue circle
					System.out.println("Clicked on NPR!");
					Interpreter.setDate(new Date(), 1);

					displayList(1);
				} else {

					System.out.println("Clicked on CNN!");
					Interpreter.setDate(new Date(), 3);

					displayList(3);
				}
			} else {
				if (e.getY() < height / 2) {
					// do stuff with the magenta circle

					System.out.println("Clicked on BBC!");
					Interpreter.setDate(new Date(), 2);

					displayList(2);
				} else {
					// do stuff with the green circle
					Interpreter.setDate(new Date(), 0);
					System.out.println("Clicked on HNN!");
					displayList(0);

				}
			}
		}
		active = true;
	}

	private static void displayList(int feed) {
		JFrame frame = new JFrame(Integer.toString(feed));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		HeadlineList list = new HeadlineList(feed);
		JPanel contentPane = new JPanel();
		contentPane.add(list);
		frame.setContentPane(list);
		frame.pack();
		frame.addMouseListener(new MouseManager());
		frame.setAlwaysOnTop(true);
		frame.setTitle("New Stories");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
				/ 2 - frame.getSize().height / 2);
		LinkClicker clicker = new LinkClicker(list);
		System.out.println(list.getEntries().size());
		frame.addMouseListener(clicker);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				active = false;
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
