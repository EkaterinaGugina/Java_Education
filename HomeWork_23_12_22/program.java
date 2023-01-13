import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sql.rowset.spi.XmlReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class program {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		int x = 0;
		int y = 0;
		int nx = 0;
		int ny = 0;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document xDoc = db.parse(XmlReader.class.getResourceAsStream("/data.xml"));
		xDoc.normalize();
		NodeList nList = xDoc.getElementsByTagName("Size");
		
		Node node = nList.item(0);
		Element element = (Element) node;

		int height = Integer.parseInt(element.getElementsByTagName("Height").item(0).getTextContent());
		int width = Integer.parseInt(element.getElementsByTagName("Width").item(0).getTextContent());
		WaveAlg Path = new WaveAlg(width, height);

		nList = xDoc.getElementsByTagName("Block");
		for (int i = 0; i < nList.getLength(); i++) {
			node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				element = (Element) node;
				x = Integer.parseInt(element.getElementsByTagName("X").item(0).getTextContent());
				y = Integer.parseInt(element.getElementsByTagName("Y").item(0).getTextContent());
				Path.block(x, y);
			}
		}

		// int[][] map = {
		// 	{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1 },
		// 	{ -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
		// 	{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
		// };


		Path.traceOut();
		System.out.println();


		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Введите координату х стартовой точки");
			x = sc.nextInt();
			System.out.println("Введите координату у стартовой точки");
			y = sc.nextInt();
			System.out.println("Введите координату х финишной точки");
			nx = sc.nextInt();
			System.out.println("Введите координату у финишной точки");
			ny = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Введено неверно!");
		}

		Path.findPath(x, y, nx, ny);

		Path.traceOut();
		System.out.println();

		Path.waveOut();
	}

}