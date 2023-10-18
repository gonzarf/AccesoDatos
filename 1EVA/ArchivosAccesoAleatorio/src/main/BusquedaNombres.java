package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class BusquedaNombres {

	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			byte[] texto = new byte[15];
			ArrayList<String> nombres = new ArrayList<String>();
			RandomAccessFile registros = new RandomAccessFile("archivo.txt", "rw"); 
			// System.out.print("Introduzca el nombre que desea buscar: ");
			// String nombre = sc.nextLine();
			
			registros.read(texto);
			System.out.println(new String(texto));
						
			while (registros.readLine() != null) {
				
				registros.read(texto);
				System.out.println(new String(texto));
				
			}
			
			System.out.println("-");
			
			for(int i = 0; i<nombres.size();i++) {
				System.out.println(nombres.get(i));
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
