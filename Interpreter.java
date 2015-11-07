package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sun.syndication.feed.synd.SyndFeed;

public class Interpreter {

	static ArrayList<ArrayList<String>> information = new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<URL>> links = new ArrayList<ArrayList<URL>>();
	static ArrayList<Date> lastRead = new ArrayList<Date>();
	static ArrayList<Integer> lastReadEntry = new ArrayList<Integer>();
	
	public static void setInfo(){
		Gatherer.update(); //updates Gatherer for latest information
		ArrayList<SyndFeed> info = Gatherer.getFeeds(); //gets latest info
		for(ArrayList<String> i: information){ //clears out each feed's information from last update
			i.clear();
		}
		for(int i = 0; i < info.size(); i++){ //for each feed
			ArrayList<String> feed = new ArrayList<String>();
			List<SyndFeed> entries = info.get(i).getEntries(); //get all entries for the feed
			for (SyndFeed f : entries){ //for each entry
				if (f.getPublishedDate().after(lastRead.get(i))){ //if it was published after the last check by the user
					
				    try {
						links.get(i).add(new URL(f.getLink())); //add the link first, so if it's a bad link, information isn't added without a link
						information.get(i).add(f.getDescription()); //add the description of the link
					} catch (MalformedURLException e) {
						//do nothing and skip to the next entry if bad url
					}
				}
			}
			
			information.add(feed);
		}
	}
	
	public static void setDate(Date d, int feed){
		lastRead.set(feed, d);
	}
	
	public static Date getDate(int i){
		return lastRead.get(i);
	}
	
	public static ArrayList<ArrayList<String>> getInfo(){
		return information;
	}
	
	public static ArrayList<String> getEntries(int feed){
		return information.get(feed);
	}
	
	public static ArrayList<URL> getLinks(int feed){
		return links.get(feed);
	}
}
