package Clases;

public class Cita {
	//Atributos
	String fecha;
	String motivo;
	
	
	//GETTER && SETTER
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	//CONSTRUCTOR
	public Cita(String fechaCita, String motivoCita) {
		this.fecha = fecha;
		this.motivo = motivo;
	}
	
}
