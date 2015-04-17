package mypackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class TransportSiteParser {
	private static final String DEFAULT_URL = "http://rozklad.monp.org.ua";
	public static void main(String[] args){
		
		String url = args.length > 0 ? args[0] : DEFAULT_URL;
		try {
			List<String> routeURLs = RouteListParser.parse(url);
			for (String route : routeURLs){
				String newURL = DEFAULT_URL + route;
				List<Station> stations = RouteParser.parseStationURLs(newURL);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}

class RouteListParser {
	public static List<String> parse(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		List<String> routeURLs = new ArrayList<String>();
		Element ulElement = doc.getElementsByClass("bodyNav").get(0);
		for (Node liElement : ulElement.childNodes()){
			if (liElement.childNodeSize() == 0){
				continue;
			}
			Node urlElement = liElement.childNode(0);
			String routeURL = urlElement.attr("href");
			routeURLs.add(routeURL);
			String routeName = urlElement.childNode(0).outerHtml();
			
		}
		return routeURLs;
	}
}

class RouteParser{
	public static List<Station> parseStationURLs(String stationURL) throws IOException{
		List<Station> stationsURLs = new ArrayList<Station>();
		Document doc = Jsoup.connect(stationURL).get();
		Element tbodyElement = doc.getElementsByClass("station").get(0).child(0);
		for (Node trElement : tbodyElement.childNodes()){
			int index = 0;
			for (Node child : trElement.childNodes()){
				if (child instanceof TextNode){
					continue;
				}else{
					index++;
				}
				if (index != 3){
					continue;
				}
				Node urlElement = child.childNode(1);
				Station station = new Station();
				station.url = urlElement.attr("href");
				station.name = urlElement.childNode(0).outerHtml();
				System.out.println(station.name);
				stationsURLs.add(station);
			}
		}
		return stationsURLs;
	}
}

class Station{
	String name;
	String url;
}
class StationTime{
	int[][] workingTime = new int[24][60];
	int[][] weekendTime = new int[24][60];
	
}