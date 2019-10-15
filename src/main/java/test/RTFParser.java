package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class RTFParser {

	public static void main(String[] agr)
			throws SAXException, TikaException, TransformerConfigurationException, IOException {
		String path = "D:/2.rtf";
		Metadata metadata = new Metadata();
		Tika tika = new Tika();
		InputStream input = new FileInputStream(path);
		StringWriter sw = new StringWriter();
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();
		handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "xml");
		handler.getTransformer().setOutputProperty(OutputKeys.INDENT, "no");
		handler.setResult(new StreamResult(sw));
		tika.getParser().parse(input, handler, metadata, new ParseContext());
		String htmlText = sw.toString();
		Document doc = Jsoup.parse(htmlText);
		Elements links = doc.select("p a");

		System.err.println(links.after("p"));
		List<RTFParsedData> rtfList = null;
		try {
			rtfList = links.stream().map(link -> {
				String tempData = link.siblingElements().get(1).text();
				String tempData2[] = tempData.split(",");
				RTFMetaData metaData = new RTFMetaData(Integer.parseInt(tempData2[2].split(" ")[0]), "Author");
				Link linkData = new Link(link.text(), link.attr("href"));
				return new RTFParsedData(linkData, tempData2[0], new Date(), tempData2[3],
						link.siblingElements().get(2).text(), metaData);
			}).collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("rtfList" + rtfList);

	}
}
