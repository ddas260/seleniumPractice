package cre_groupMonkey;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.WebElement;

public class Connection {
	public static int getResponse(WebElement link) throws IOException {
		String linkUrl = link.getAttribute("href");
		URL url = new URL(linkUrl);
		URLConnection UrlCon = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) UrlCon;
		connection.setRequestMethod("HEAD");
		connection.connect();
		int response = connection.getResponseCode();
		return response;
	}

}
