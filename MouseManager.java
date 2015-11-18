/**
 * 
 */
package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Noah Higa
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int height = Interface.getDrawingBoard().getHeight();
		int width = Interface.getDrawingBoard().getWidth();
		System.out.println("Mouse clicked!");
		if(e.getX() < width / 2){
			if ( e.getY() < height / 2){
				//do stuff with the blue circle
				System.out.println("Clicked on blue!");
			}
			else {

				System.out.println("Clicked on red!");
			}
		}
		else {
			if (e.getY() < height / 2){
				//do stuff with the magenta circle

				System.out.println("Clicked on magenta!");
			}
			else {
				//do stuff with the green circle

				System.out.println("Clicked on green!");
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
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
