package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Cancion;

public class Main {

	public static void main(String[] args) {

		File textocanciones = new File("canciones.txt");
		ArrayList<Cancion> canciones = new ArrayList<>();
		int opcion = 0;
		Scanner sc = new Scanner(System.in);

		try {

			if (!textocanciones.exists()) {
				System.out.println("Creando archivo...");
				textocanciones.createNewFile();
			}

			FileReader fr = new FileReader("canciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String atributos[];
			boolean seguir = true;

			while ((linea = br.readLine()) != null) {

				Cancion nueva = new Cancion(); 	// CREAMOS UNA VARIABLE CANCION PARA PASSARLE LOS ATRIBUTOS LEIDOS
				atributos = linea.split(","); 	// SEPARAMOS LA LINEA POR LAS COMAS PARA OBTENER LOS ATRIBUTOS EN UN ARRAY
												// DE STRINGS

				// LE DAMOS EL VALOR A CADA ATRIBUTO SEGUN SU PUESTO EN EL ARRAY DE ATRIBUTOS

				nueva.setId(Integer.parseInt(atributos[0])); // CONVERTIMOS EL STRING EN UN INT
				nueva.setTitulo(atributos[1]);
				nueva.setArtista(atributos[2]);
				nueva.setDuracion(Integer.parseInt(atributos[3])); // CONVERTIMOS EL STRING EN UN INT
				nueva.setAlbum(atributos[4]);
				nueva.setLetra(atributos[5]);

				// UNA VEZ AÑADIDOS TODOS LOS ATRIBUTOS AÑADIMOS EL OBJETO AL ARRAYLIST DE
				// CANCIONES

				canciones.add(nueva);

			}

			br.close();
			fr.close();
			
			do {
			System.out.println(
					"MENU \n 1.- VER CANCIONES DISPONIBLES \n 2.- ANADIR CANCION \n 3.- MODIFICAR CANCION \n 4.- BORRAR CANCION \n 5.- SALIR");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:

				System.out.println("Canciones: ");

				for (int i = 0; i < canciones.size(); i++) {

					System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
							+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
							+ canciones.get(i).getTitulo());

				}

				break;

			case 2:

				anadir(canciones);

				break;

			case 3:

				modificar(canciones);
				
				break;

			case 4:

				borrar(canciones);
				
				break;
				
			case 5:
				
				seguir=false;

			}
			
			}while (seguir==true);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	public static void anadir(ArrayList<Cancion> canciones) {
		
		
		
		try {
			
			FileWriter fw = new FileWriter("canciones.txt");
			PrintWriter pw = new PrintWriter(fw, true);
			Scanner sc = new Scanner(System.in);
			


			Cancion nueva = new Cancion();
			int duracion;

			nueva.setId((canciones.get(canciones.size() - 1).getId()) + 1);

			System.out.print("Introduzca el titulo de la cancion:");
			String titulo = sc.nextLine();

			nueva.setTitulo(titulo);

			System.out.print("Introduzca el artista de la cancion:");
			String artista = sc.nextLine();

			nueva.setArtista(artista);

			do {

				System.out.print("Introduzca la duracion de la cancion en segundos:");
				duracion = sc.nextInt();
				sc.nextLine();

			} while (duracion <= 0 || duracion >= 500);

			nueva.setDuracion(duracion);

			System.out.print("Introduzca el album de la cancion:");
			String album = sc.nextLine();

			nueva.setAlbum(album);

			nueva.setLetra(titulo + ".txt");

			canciones.add(nueva);

			File letra = new File(nueva.getLetra());
			letra.createNewFile();
			
			for (int i = 0; i < canciones.size(); i++) {

				pw.println(canciones.get(i).getId() + "," + canciones.get(i).getTitulo() + "," + canciones.get(i).getArtista() + ","
						+ canciones.get(i).getDuracion() + "," + canciones.get(i).getAlbum() + "," + canciones.get(i).getLetra());

			}
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}
	
	public static void modificar(ArrayList<Cancion> canciones) {
		
		Scanner sc = new Scanner(System.in);
		FileWriter fw;

		try {
			
			fw = new FileWriter("canciones.txt");
			PrintWriter pw = new PrintWriter(fw, true);
			
			System.out.println("QUE CANCION DESEA MODIFICAR?");

			for (int i = 0; i < canciones.size(); i++) {

				System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
						+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
						+ canciones.get(i).getTitulo() + ", " + canciones.get(i).getLetra());

			}

			int eleccionMod = sc.nextInt();
			sc.nextLine();
			Cancion cancionModificar = canciones.get(eleccionMod - 1);

			System.out.println("QUE DESEA MODIFICAR?");
			System.out.println("1.- TITULO: " + cancionModificar.getTitulo());
			System.out.println("2.- ARTISTA: " + cancionModificar.getArtista());
			System.out.println("3.- ALBUM: " + cancionModificar.getAlbum());
			System.out.println("4.- DURACION: " + cancionModificar.getDuracion());
			System.out.println("5.- SALIR");

			int opcionModif = sc.nextInt();
			sc.nextLine();

			switch (opcionModif) {

			case 1:

				System.out.print("INTRODUZCA EL NUEVO TITULO: ");
				String newTitulo = sc.nextLine();
				cancionModificar.setTitulo(newTitulo);
				break;

			case 2:

				System.out.print("INTRODUZCA EL NUEVO ARTISTA: ");
				String newArtista = sc.nextLine();
				cancionModificar.setTitulo(newArtista);
				break;

			case 3:

				System.out.print("INTRODUZCA EL NUEVO ALBUM: ");
				String newAlbum = sc.nextLine();
				cancionModificar.setTitulo(newAlbum);
				break;

			case 4:

				System.out.print("INTRODUZCA EL NUEVO DURACION: ");
				String newDuracion = sc.nextLine();
				cancionModificar.setTitulo(newDuracion);
				break;

			case 5:

				break;

			}
			
			for (int i = 0; i < canciones.size(); i++) {

				pw.println(canciones.get(i).getId() + "," + canciones.get(i).getTitulo() + ","
						+ canciones.get(i).getArtista() + "," + canciones.get(i).getDuracion() + ","
						+ canciones.get(i).getAlbum() + "," + canciones.get(i).getLetra());

			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		
	}

	public static void borrar(ArrayList<Cancion> canciones) {
		
		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		
		try {
			
			fw = new FileWriter("canciones.txt");
			PrintWriter pw = new PrintWriter(fw, true);
			
			System.out.println("QUE CANCION DESEA BORRAR?");

			for (int i = 0; i < canciones.size(); i++) {

				System.out.println(canciones.get(i).getId() + ", " + canciones.get(i).getArtista() + ", "
						+ canciones.get(i).getAlbum() + ", " + canciones.get(i).getDuracion() + ", "
						+ canciones.get(i).getTitulo() + ", " + canciones.get(i).getLetra());

			}

			int eleccionBorrar = sc.nextInt();
			sc.nextLine();

			Cancion cancionBorrar = canciones.get(eleccionBorrar - 1);

			System.out.println("VA A BORRAR: " + cancionBorrar.getId() + ", " + cancionBorrar.getArtista() + ", "
					+ cancionBorrar.getAlbum() + ", " + cancionBorrar.getDuracion() + ", "
					+ cancionBorrar.getTitulo() + ", " + cancionBorrar.getLetra() + "\n ESTA SEGURO S/N");
			String confirmar = sc.nextLine();

			if (confirmar.equalsIgnoreCase("s")) {

				canciones.remove(eleccionBorrar - 1);

				for (int i = 0; i < canciones.size(); i++) {

					pw.println(canciones.get(i).getId() + "," + canciones.get(i).getTitulo() + ","
							+ canciones.get(i).getArtista() + "," + canciones.get(i).getDuracion() + ","
							+ canciones.get(i).getAlbum() + "," + canciones.get(i).getLetra());

				}

			}
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}
}
