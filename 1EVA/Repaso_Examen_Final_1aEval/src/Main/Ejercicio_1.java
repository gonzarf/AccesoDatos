package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Clases.Cita;
import Clases.Mascota;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// Haz un programa que lea un archivo XML y serialice su contenido en formato
		// objetos. El XML tiene la siguiente forma.

		File archivo = new File("mascotas.xml");
		ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db;
		Document document;

		XPath xPath; // para buscar dentro del archivo XML
		NodeList nodeList;
		String path;

		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(archivo);
			document.normalizeDocument();
			xPath = XPathFactory.newInstance().newXPath();

			path = "//mascota";
			
			// consulta y nodos de la consulta
			
			nodeList = (NodeList) xPath.compile(path).evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element elemento = (Element) nodeList.item(i);
				String id = elemento.getElementsByTagName("id").item(0).getTextContent();

				String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
				String especie = elemento.getElementsByTagName("especie").item(0).getTextContent();
				String sexo = elemento.getElementsByTagName("sexo").item(0).getTextContent();
				String edad = elemento.getElementsByTagName("edad").item(0).getTextContent();

				// Obtener la lista de citas para la mascota actual
				
				NodeList citasNodeList = elemento.getElementsByTagName("cita");
				ArrayList<Cita> historial = new ArrayList<Cita>();
				Cita cita;
				for (int j = 0; j < citasNodeList.getLength(); j++) {
					Element elementoCitas = (Element) citasNodeList.item(j);
					String fechaCita = elementoCitas.getElementsByTagName("fecha").item(0).getTextContent();
					String motivoCita = elementoCitas.getElementsByTagName("motivo").item(0).getTextContent();
					cita = new Cita(fechaCita, motivoCita);
					historial.add(cita);
				}
				
				serializarDatos(id, nombre, especie, sexo, edad, historial, listaMascotas);
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// PINTAMOS LAS MASCOTAS
		for (Mascota m : listaMascotas) {
			System.out.println(m.getNombre());
		}

	}

	private static void serializarDatos(String id, String nombre, String especie, String sexo, String edad,
			ArrayList<Cita> historial, ArrayList<Mascota> listaMascotas) {
		int idInt = Integer.parseInt(id);
		int edadInt = Integer.parseInt(edad);
		Mascota m = new Mascota(idInt, nombre, especie, sexo, edadInt, historial);
		listaMascotas.add(m);
	}

}
