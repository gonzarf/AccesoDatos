package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Clases.DocMaker;
import Clases.Persona;

public class Ejercicio_2 {

	public static void main(String[] args) {
		// Hacer un programa que lea datos de personas y genere una página web como esta
		// (también tenéis el código en archivo)
		// El archivo con los datos sigue esta estructura:

		// 5123,Juan,Fernández,López,22,https://www.svgrepo.com/show/61986/avatar.svg
		// 7518,María,Sanz,González,33,https://www.svgrepo.com/show/10678/avatar.svg
		// 8812,Sandra,Pazos,Galván,43,https://www.svgrepo.com/show/49569/avatar.svg
		//
		// El código HTML para generar a una persona sería este (lo tenéis en el archivo
		// HTML de ejemplo, junto al CSS que ya está hecho):

		File archivo = new File("DatosPersonas.txt");
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		DocMaker dm = new DocMaker();
		iniciar(archivo);
		listaPersonas = cargar(archivo, listaPersonas);
		dm.crearHTML(listaPersonas);

	}

	
	
	private static void iniciar(File archivo) {

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("5123,Juan,Fernández,López,22,https://www.svgrepo.com/show/61986/avatar.svg\n"
						+ "7518,María,Sanz,González,33,https://www.svgrepo.com/show/10678/avatar.svg\n"
						+ "8812,Sandra,Pazos,Galván,43,https://www.svgrepo.com/show/49569/avatar.svg");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	


	private static ArrayList<Persona> cargar(File archivo, ArrayList<Persona> listaPersonas) {
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea = "";
			while ((linea = br.readLine()) != null) {
				String[] contenido = linea.split(",");

				for (int i = 0; i < contenido.length; i++) {
					System.out.println(contenido[i]);
				}
				String ide = contenido[0];
				String edadString = contenido[4];

				int id = Integer.parseInt(ide);
				String nombre = contenido[1];
				String apellido1 = contenido[2];
				String apellido2 = contenido[3];
				int edad = Integer.parseInt(edadString);
				String direccionWeb = contenido[5];
				Persona p = new Persona(id, nombre, apellido1, apellido2, edad, direccionWeb);
				listaPersonas.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPersonas;
	}

}
