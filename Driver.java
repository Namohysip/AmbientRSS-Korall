package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		ArrayList<URL> list = new ArrayList<URL>();
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter RSS url:");
			String result = scan.nextLine();
			list.add(new URL(result));
			Gatherer.setURLs(list);
			Interpreter.newFeed();
			System.out.println("Gathering info...");
			Interpreter.setInfo();

			System.out.println("Entries found: "
					+ Interpreter.getInfo().get(0).size());
			for(int i = 0; i < Interpreter.getInfo().get(0).size(); i++){
				scan.nextLine();
				System.out.println(Interpreter.getInfo().get(0).get(i));
				System.out.println(Interpreter.getLinks(0).get(i));
			}
			scan.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bad url!");
		}

	}
}
