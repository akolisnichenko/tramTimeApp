package com.kain.tram.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

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