package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {
		
		try {
			
			int tamRegistro = 39;
			byte[] texto = new byte[tamRegistro];
			RandomAccessFile registros = new RandomAccessFile("archivo.txt", "rw");
			
			//registros.read(texto);
			//System.out.println(new String(texto));
			
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			
			registros.seek(0);

			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			
			registros.seek(0);
			
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			System.out.println((char)registros.read());
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
	}

}
