package main;

import java.net.URL;
import java.util.ArrayList;

import com.sun.syndication.feed.synd.SyndFeed;

public class Gatherer {

	static ArrayList<URL> urls = null;
	static ArrayList<SyndFeed> feeds = null;
	/**
	 * Sets all of the urls in the list at once
	 * @param list
	 */
	public static void setURLs(URL[] list){
		//TODO: Error checking (valid RSS?)
	}
	
	/**
	 * Meat of the class.
	 * Gathers as individual Strings the current content of
	 * each RSS feed from each URL and updates the feeds array
	 * @return
	 */
	public static void update(){
		
	}
	
	/**
	 * Adds a url to the end of the array list. Size limitation?
	 * @param added
	 */
	public static void addURL(URL added){
		
	}
	
	/**
	 * Removes the url from the list at the specified index
	 * @param remove
	 * @return
	 */
	public static URL removeURL(int remove){
		
		return null;
	}
	
	/**
	 * Returns the url array
	 * @return
	 */
	public static ArrayList<URL> getURLs(){
		return urls;
	}
	
	/**
	 * Returns the url at the specified index of the array list
	 * @param get
	 * @return
	 */
	public static URL getURL(int get){
		//TODO: add error checking
		return urls.get(get);
	}
	
	public static ArrayList<SyndFeed> getFeeds(){
		return feeds;
	}
}
