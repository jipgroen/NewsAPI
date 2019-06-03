package api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * More info:
 * https://newsapi.org/docs/get-started
 * https://www.baeldung.com/java-http-request API
 */

/**
 * 
 * @author drewes
 *
 */
public abstract class AbstractNewsApiFeed {

	public static final String SRC = "https://newsapi.org/v2/top-headlines";
	public static String APIKEY = "";

	protected Map<String, String> parameters;
	protected URL url;

	
	/**
	 * Default no-args constructor.
	 */
	public AbstractNewsApiFeed() {
		parameters = new HashMap<>();
		if (!APIKEY.isEmpty()) {
			setParameter("apiKey", APIKEY);
		}
	}

	/**
	 * Setter for the url. Generates a url with the SRC, API key and set
	 * paramters.
	 */
	public void setUrl() {
		try {
			url = new URL(SRC + "?" + ParameterStringBuilder.getParamsString(parameters));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error while creating parameters: " + e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println("Error while creating url: " + e.getMessage());
		}
	}

	/**
	 * Returns the url with paramaeters as a string.
	 * @return url.
	 */
	public String getUrl() {
		return url.toString();
	}

	/**
	 * Request the api.
	 * @return the json response.
	 */
	public String request() {
		String json = "";

		// Set url
		setUrl();

		// Request URL
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);

			if (con.getResponseCode() != 200)
				throw new RuntimeException("HttpResponseCode: " + con.getResponseCode());
			else {

				Scanner scanner = new Scanner(url.openStream());
				while (scanner.hasNext()) {
					json += scanner.nextLine();
				}
				scanner.close();
				con.disconnect();

			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error while creating parameters: " + e.getMessage());
		} catch (MalformedURLException e) {
			System.out.println("Error while creating url: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error while reading url: " + e.getMessage());
		}

		return json;

	}

	/**
	 * Add get parameters to a collection
	 * 
	 * @param key
	 * @param value
	 */
	public void setParameter(String key, String value) {
		parameters.put(key, value);
	}
}
