package main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import objects.Cita;
import objects.Mascota;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("mascotas.xml");
		
		leerXML(file);
		
	}
	
	public static void leerXML(File file) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db;
		Document document;
		NodeList nodeList;
		Cita nuevacita = null;
		Mascota nuevamascota = null;
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

		try {

			db = dbf.newDocumentBuilder();
			document = db.parse(file);
			document.normalizeDocument();
			
			nodeList = document.getElementsByTagName("mascota");

            for (int i = 0; i < nodeList.getLength(); i++) {
            	
                Element mascota = (Element) nodeList.item(i);
                
                String id = mascota.getElementsByTagName("id").item(0).getTextContent();
                String nombre = mascota.getElementsByTagName("nombre").item(0).getTextContent();
                String especie = mascota.getElementsByTagName("especie").item(0).getTextContent();
                String sexo = mascota.getElementsByTagName("sexo").item(0).getTextContent();
                String edad = mascota.getElementsByTagName("edad").item(0).getTextContent();
                
                nodeList = document.getElementsByTagName("cita");
                
                for(int x = 0; x < nodeList.getLength(); x++) {
                	
                	Element cita = (Element) nodeList.item(i);
                	
                	String fecha = cita.getElementsByTagName("fecha").item(0).getTextContent();
                	String motivo = cita.getElementsByTagName("motivo").item(0).getTextContent();
                	
                	nuevacita = new Cita();
                	
                	nuevacita.setFecha(fecha);
                	nuevacita.setMotivo(motivo);

                }
                
                
                nuevamascota = new Mascota();
            
                nuevamascota.setId(id);
                nuevamascota.setNombre(nombre);
                nuevamascota.setEspecie(especie);
                nuevamascota.setSexo(sexo);
                nuevamascota.setEdad(edad);
                nuevamascota.getHistoria().add(nuevacita);
            }
            
            mascotas.add(nuevamascota);
            
            for(int i=0; i<mascotas.size();i++) {
            	System.out.println(mascotas.get(i).getNombre());
            }


		} catch (Exception e) {
			
			System.out.println("Error");
		}

	}

}
