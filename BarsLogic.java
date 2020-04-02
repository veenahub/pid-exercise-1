package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class BarsLogic {

	public List<Bars> barslist() throws ParserConfigurationException, SAXException, IOException {

		List<Bars> bars = new ArrayList<Bars>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("/Users/sdalund/Desktop/gitllab/pid-exercise-1/bars.xml"));
		document.getDocumentElement().normalize();
		System.out.println("Root:" + document.getDocumentElement().getNodeName());

		NodeList nList = document.getDocumentElement().getChildNodes();
		System.out.println("size" + nList.getLength());

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Bars b = new Bars();
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				b.setBarname(eElement.getNodeName());
				b.setSN((eElement.getAttribute("SN")));
				b.setFett(Float.parseFloat(eElement.getElementsByTagName("fett").item(0).getTextContent()));
				b.setEnergy(Float.parseFloat(eElement.getElementsByTagName("energy").item(0).getTextContent()));
				b.setKolhydrat(Float.parseFloat(eElement.getElementsByTagName("kolhydrat").item(0).getTextContent()));
				b.setProtein(Float.parseFloat(eElement.getElementsByTagName("protein").item(0).getTextContent()));
				b.setFiber(Float.parseFloat(eElement.getElementsByTagName("fiber").item(0).getTextContent()));
				NodeList rList = eElement.getElementsByTagName("reviewer");
				for (int temp1 = 0; temp1 < rList.getLength(); temp1++) {
					Node node1 = rList.item(temp1);
					if (node1.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement1 = (Element) node1;
						// System.out.println((eElement1.getNodeName()));
						// System.out.println((eElement1.getAttribute("personID")));
						// System.out.println((eElement.getElementsByTagName("date").item(0).getTextContent()));
					}
				}

			}
			if (node.getNodeType() == Node.ELEMENT_NODE)
			bars.add(b);
		}

		return bars;

	}

	public void viewAllbars(List<Bars> bars) {

		for (Bars bb : bars) {
			System.out.println(bb.getBarname());

		}
	}

	public void sortByHighestProteinContent(List<Bars> proteinBarsList) {

		Collections.sort(proteinBarsList, new Comparator<Bars>() {
			@Override
			public int compare(Bars o1, Bars o2) {
				return Float.compare(o1.getProtein(), o2.getProtein());
			}
		});

		Collections.reverse(proteinBarsList);
		for (int i = 0; i < proteinBarsList.size(); i++) {
			System.out.println(proteinBarsList.get(i).getBarname() + "  " + proteinBarsList.get(i).getProtein());
		}
	}

	public void sortByHighestFatContent(List<Bars> proteinBarsList) {

		Collections.sort(proteinBarsList, new Comparator<Bars>() {
			@Override
			public int compare(Bars o1, Bars o2) {
				return Float.compare(o1.getFett(), o2.getFett());
			}
		});

		Collections.reverse(proteinBarsList);
		for (int i = 0; i < proteinBarsList.size(); i++) {
			System.out.println(proteinBarsList.get(i).getBarname() + "  " + proteinBarsList.get(i).getFett());
		}

	}

}
