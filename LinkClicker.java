package main;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LinkClicker implements MouseListener {

	HeadlineList list = null;
	public LinkClicker(HeadlineList list){
		super();
		this.list = list;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getY() < ((list.getLinks().size() + 1) * 25) + 40 && e.getY() > 60){
			launchLink(((e.getY() - 40) / 25) - 1);
		}

	}

	private void launchLink(int i){
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop()
				: null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(list.getLinks().get(i).toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
