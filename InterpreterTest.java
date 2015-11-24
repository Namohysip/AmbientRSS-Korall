package main;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class InterpreterTest {

	@Test
	public void testsetInfo() {
		ArrayList<URL> list = new ArrayList<URL>();
		try {
			list.add(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gatherer.setURLs(list);
		Interpreter.newFeed();
	}
	
	@Test
	public void testsetDate() {
		ArrayList<URL> list = new ArrayList<URL>();
		try {
			list.add(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gatherer.setURLs(list);
		Interpreter.newFeed();
		Interpreter.setDate(new Date(), 0);
		assertEquals(new Date(),Interpreter.getDate(0));
		
	}
	
	@Test
	public void testgetInfo() {
		ArrayList<URL> list = new ArrayList<URL>();
		try {
			list.add(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gatherer.setURLs(list);
		Interpreter.newFeed();
		assertEquals(Interpreter.getInfo().size(), 1);
	}
	
	@Test
	public void testgetLink() {
		ArrayList<URL> list = new ArrayList<URL>();
		try {
			list.add(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gatherer.setURLs(list);
		Interpreter.newFeed();
		assertEquals(Interpreter.getLinks(0),Interpreter.getEntries(0));
	}

}
