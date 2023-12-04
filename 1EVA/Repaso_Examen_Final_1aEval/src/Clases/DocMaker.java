package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DocMaker {

	public void crearHTML(ArrayList<Persona> listaPersonas) {
		File nombfeArchivo = new File("psMiguel.html");

		FileWriter fr;
		try {
			fr = new FileWriter(nombfeArchivo);
			BufferedWriter bf = new BufferedWriter(fr);

			bf.write("<!DOCTYPE html>");
			bf.newLine();
			bf.write("<html lang=\"en\">");
			bf.newLine();
			// head
			bf.write("<head>");
			bf.newLine();
			bf.write("    <title>pS</title>");
			bf.newLine();
			bf.write("    <meta charset=\"utf-8\"/>");
			bf.newLine();
			bf.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>");
			bf.newLine();
			bf.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
			bf.newLine();
			bf.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"personas.css\"/>");
			bf.newLine();
			bf.write("</head>");
			bf.newLine();
			// body
			bf.write("<body>");
			bf.newLine();
			for (Persona p : listaPersonas) {
				bf.write("    <div class=persona id=" + p.getId() + ">");
				bf.newLine();
				bf.write("        <div class=avatar><img src=" + p.getDireccionWeb() +"></div>");
				bf.newLine();
				bf.write("        <div><span class=resaltar>Nombre:</span>" + p.getNombre() +"</div>");
				bf.newLine();
				bf.write("        <div><span class=resaltar>Apellidos:</span>"+ p.getApellido1() + " " + p.apellido2 + "</div>");
				bf.newLine();
				bf.write("        <div><span class=resaltar>Edad:</span>" + p.getEdad() + "</div>");
				bf.newLine();
				bf.write("        <div class=eliminar><button onclick=this.parentElement.parentElement.remove()>Borrar</button></div>");
				bf.newLine();
				bf.write("    </div>");
				bf.newLine();
			}

			bf.write("</body>");
			bf.newLine();
			bf.write("</html>");

			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

}

}
