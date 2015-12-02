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
import java.net.ConnectException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		System.out.println("Mouse clicked!");
		if (!active) {
			int circle = (e.getY() - 16) / 100;
			if (circle < 0) {
				circle = 0;
			}
			else if(circle > 3){
				circle = 3;
			}
			Interpreter.setDate(new Date(), circle);
			displayList(circle);
			try {
				Interface.refresher(0);
			} catch (Exception ex) {
				//do nothing
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
		frame.setAlwaysOnTop(false);
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
		Interface.getDrawingBoard().setRadius(feed, 1);
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
