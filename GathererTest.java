package main;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class GathererTest {

	@Test
	public void testaddURL() {

		ArrayList<URL> list = new ArrayList<URL>();
		Gatherer.setURLs(list);
		try {
			Gatherer.addURL(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		assertEquals("http://rss.cnn.com/rss/cnn_topstories.rss",Gatherer.getURL(0).toString());
		
	}
	@Test
	public void testaddURLInvalid() {

		ArrayList<URL> list = new ArrayList<URL>();
		Gatherer.setURLs(list);
		try {
			Gatherer.addURL(new URL("http://www.google.com"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		assertTrue(Gatherer.getURLs().isEmpty());
		
	}
	
	@Test
	public void testremoveURL() {

		ArrayList<URL> list = new ArrayList<URL>();
		Gatherer.setURLs(list);
		try {
			Gatherer.addURL(new URL("http://rss.cnn.com/rss/cnn_topstories.rss"));
			Gatherer.addURL(new URL("http://www.hawaiinewsnow.com/Global/category.asp?C=3497&clienttype=rss"));
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		assertEquals("http://rss.cnn.com/rss/cnn_topstories.rss",Gatherer.getURL(0).toString());
		assertEquals("http://www.hawaiinewsnow.com/Global/category.asp?C=3497&clienttype=rss",Gatherer.getURL(1).toString());
		
		Gatherer.removeURL(1);
		
		assertEquals(Gatherer.getURLs().size(), 1);
		
	}

}
