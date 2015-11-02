package main;

import java.util.ArrayList;
import java.util.Date;

public class Interpreter {

	static ArrayList<ArrayList<String>> information = new ArrayList<ArrayList<String>>();
	static Date lastRead = null;
	
	public static void setInfo(){
		Gatherer.update();
		ArrayList<String> info = Gatherer.getFeeds();
		information.clear();
		for(int i = 0; i < info.size(); i++){
			ArrayList<String> feed = new ArrayList<String>();
			//TODO: read through the lines of s for important info, add to feed
			//TODO: only add dates that were published AFTER 'read' date
			information.add(feed);
		}
	}
	
	public static void setDate(Date d){
		lastRead = d;
	}
	
	public static Date getDate(){
		return lastRead;
	}
	
	public static ArrayList<ArrayList<String>> getInfo(){
		return information;
	}
}
