package com.kain.tram.util;

import java.io.IOException;
import java.util.List;

public class TramTimeParserUtil {
	private static final String DEFAULT_URL = "http://rozklad.monp.org.ua";
	public static void main(String[] args){
		
		String url = args.length > 0 ? args[0] : DEFAULT_URL;
		try {
			List<String> routeURLs = RouteListParser.parse(url);
			for (String route : routeURLs){
				String newURL = DEFAULT_URL + route;
				List<Station> stations = RouteParser.parseStationURLs(newURL);
				for (Station station : stations){
					StationTime time = TimeParser.parseTimeSchedule(station.url);
					station.timeArrays = time;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
