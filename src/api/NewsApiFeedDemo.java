package api;

import java.io.File;
import java.util.Scanner;

/*
 * Used tutorials:
 * https://newsapi.org/docs/get-started
 * https://www.baeldung.com/java-http-request API
 */

/**
 * 
 * @author drewes
 *
 */
public class NewsApiFeedDemo extends AbstractNewsApiFeed {

	public static final String SRC = "demo-data/top-headlines.json";

	@Override
	public String getUrl() {
		return "Demodata";
	}
	
	@Override
	public String request() {
		String json = "";
		try {
			Scanner scanner = new Scanner(new File("demo-data/top-headlines.json"));
			while (scanner.hasNext()) {
				json += scanner.nextLine();
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Error while reading file: " + e.getMessage());
		}
		return json;
	}
}
