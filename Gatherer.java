package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Gatherer {

	static ArrayList<URL> urls = null;
	static ArrayList<SyndFeed> feeds = new ArrayList<SyndFeed>();
	static SyndFeed feed;
	/**
	 * Sets all of the urls in the list at once
	 * @param list
	 */
	
	public Gatherer(SyndFeed feed){
		
		Gatherer.feed = feed;
		
	}

	public static void setURLs(ArrayList<URL> list){
		//TODO: Error checking (valid RSS?)
		urls = list;
		
		/**checks to make sure the URL is valid RSS before adding
		 * removes it from the array if it isn't
		 */
			
	}
	
	/**
	 * Meat of the class.
	 * Gathers as individual Strings the current content of
	 * each RSS feed from each URL and updates the feeds array
	 * @return
	 */
	public static void update(){
		
		//loop through urls ArrayList and generate SyndFeeds to be stored in feeds array
		feeds.clear();
		for(int i = 0; i < urls.size(); i++){
			
			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = null;
			try {
				feed = input.build(new XmlReader(urls.get(i)));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			feeds.add(feed);
			
		}
		
	}
	
	/**
	 * Adds a url to the end of the array list. Size limitation?
	 * @param added
	 */
	public static void addURL(URL added){
		
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = null;
		
		//checks to make sure the URL is valid RSS before adding to the array
		
		try {
			feed = input.build(new XmlReader(added));
			
			if(!feed.getFeedType().contains("rss")){
				
				return;
				
			}
			
			else{
				
				urls.add(added);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Removes the url from the list at the specified index
	 * @param remove
	 * @return
	 */
	public static URL removeURL(int remove){
		
		urls.remove(remove);
		
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
