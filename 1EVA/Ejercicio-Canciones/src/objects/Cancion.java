package objects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cancion {
	private int id;
	private String titulo;
	private String artista;
	private int duracion;
	private String album;
	private String letra;

	public Cancion(int id, String titulo, String artista, int duracion, String album, String letra) {

		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
		this.album = album;
		this.letra = letra;
	}

	public Cancion() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public void añadir(ArrayList<Cancion> canciones) {

		Scanner sc = new Scanner(System.in);
		Cancion nueva = new Cancion();
		String string;
		int numero = 0;
		int id = 0;
		
		for (int i = 0; i< canciones.size();i++) {
			id++;
		}
		
		nueva.setId(id);

		System.out.print("Introduzca el titulo de la cancion:");
		string = sc.nextLine();

		nueva.setTitulo(string);

		System.out.print("Introduzca el artista de la cancion:");
		string = sc.nextLine();

		nueva.setArtista(string);

		while (numero > 0 && numero <= 500) {
			
			System.out.print("Introduzca la duracion de la cancion en segundos:");
			numero = sc.nextInt();

		}

		nueva.setDuracion(numero);

		System.out.print("Introduzca el album de la cancion:");
		string = sc.nextLine();

		nueva.setAlbum(string);
		
		canciones.add(nueva);

	}

}
