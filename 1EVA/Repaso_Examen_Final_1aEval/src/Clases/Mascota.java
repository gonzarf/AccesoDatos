package Clases;

import java.util.ArrayList;

public class Mascota {
//Atributos
	int id;
	String nombre;
	String especie;
	String sexo;
	int edad;
	ArrayList<Cita> historial;
	
	//GETTER && SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Cita> getHistorial() {
		return historial;
	}
	public void setHistorial(ArrayList<Cita> historial) {
		this.historial = historial;
	}
	public Mascota(int id, String nombre, String especie, String sexo, int edad, ArrayList<Cita> historial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.historial = historial;
	}
	
	//CONSTRUCTOR
	
}
