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
			System.out.println("How many seconds between updates?");
			boolean invalid = true;
			int cycleTime = 0;
			while (invalid) {
				try {
					cycleTime = scan.nextInt();
					scan.nextLine();
					invalid = false;
				} catch (Exception e) {
					scan.nextLine();
				}
			}
			list.add(new URL(result));
			Gatherer.setURLs(list);
			Interpreter.newFeed();

			while (true) {
				System.out.println("Gathering info...");
				refresher(cycleTime * 1000);

				System.out.println("New entries found: "
						+ Interpreter.HowManyEntries(0));
				/*
				 * for (int i = 0; i < Interpreter.getInfo().get(0).size(); i++)
				 * { scan.nextLine();
				 * System.out.println(Interpreter.getInfo().get(0).get(i));
				 * System.out.println(Interpreter.getLinks(0).get(i)); }
				 */
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bad url!");
		}
		scan.close();
	}

	public static void refresher(long cycle) {
		long lastCheck = System.currentTimeMillis();
		while (lastCheck + cycle > System.currentTimeMillis()) {

		}
		Interpreter.setInfo();
		Interpreter.setDate(new Date(), 0);
	}
}
