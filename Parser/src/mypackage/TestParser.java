package mypackage;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class TestParser {
	
	
	public static void main(String[] args) throws IOException{
		Document doc = Jsoup.connect("http://rozklad.monp.org.ua/home/index/106/1397").get();
		Element workingHoursDiv = doc.getElementsByClass("workTable").first();
		Element weekendHoursDiv = doc.getElementsByClass("weekendTable").first();
		Element table = workingHoursDiv.child(0).child(0);
		for (Node trElement : table.childNodes()) { //
			int index = 0;
			for (Node td :trElement.childNodes()){
				if (index++ == 0){
					System.out.println();
					System.out.println(td.childNodeSize() == 1 ? td.childNode(0).outerHtml() : ""); // hour value
					continue;
				}
				System.out.print((td.childNodeSize() == 1 ? td.childNode(0).outerHtml() : "") + "\t");
			}
		}
	}

}
