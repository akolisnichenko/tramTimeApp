package com.kain.tram.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

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
			//String routeName = urlElement.childNode(0).outerHtml();
			
		}
		return routeURLs;
	}
}

