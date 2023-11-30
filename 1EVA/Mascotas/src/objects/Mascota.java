package objects;

import java.util.ArrayList;

public class Mascota {
	
	private String id;
	private String nombre; 
	private String especie;
	private String sexo;
	private String edad;
	private ArrayList<Cita> historia;
	
	public Mascota(String id, String nombre, String especie, String sexo, String edad, ArrayList<Cita> historia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.historia = historia;
	}
	
	public Mascota() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public ArrayList<Cita> getHistoria() {
		return historia;
	}

	public void setHistoria(ArrayList<Cita> historia) {
		this.historia = historia;
	}
	
	

}
