package xml;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("Welcome to Bars store");
		System.out.println("Pick an option");
		System.out.println("1 for Show the name of all bars");
		System.out.println("2 for Sort bars  based on highest protein content.");
		System.out.println("3 for Sort bars  based on highest fatt content.");
		BarsLogic bl = new BarsLogic();
		Scanner s = new Scanner(System.in);
		List<Bars> bars = bl.barslist();
		while (true) {

			String userinput = s.nextLine();
			// Switch case for user to select option.
			switch (userinput) {
			case "1":
				// view method to view the bars List.
				bl.viewAllbars(bars);
				break;

			case "2":
				bl.sortByHighestProteinContent(bars);
				break;
			case "3":
				bl.sortByHighestFatContent(bars);
				break;
			case "4":

				break;
			case "5":
				// exit method to save

				return;
			default:
				System.out.println("you should enter the number between 1 to 5");
				System.out.println("Pick an option");
				System.out.println("1 for Show the name of all bars");
				System.out.println("2 for Sort bars  based on highest protein content.");
				System.out.println("3 for Sort bars  based on highest fatt content.");

			}
		}
	}
}
