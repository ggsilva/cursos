package br.com.treinaweb.designPatterns.behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Service {
	
	public static String getCotacao() throws IOException{
		
		URL url = new URL(getUrl());
		URLConnection connection = url.openConnection();
		
		String responseString = "";
		String outputString = "";
		
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		while ((responseString = in.readLine()) != null) {
			outputString = outputString + responseString;
		}
		
		return outputString;
	}

	private static String getUrl() {
		return "http://datafeed.bolsafinanceira.com/cgi-bin/quote.cgi?token=" + getToken() + "&symbol=PETR4";
	}

	private static String getToken() {
		return "9eaf44320e35ad126343b2a957bb0a17";
	}
}
