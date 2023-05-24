package ar.edu.unq.po2;

public class Organizacion {

	private ONG tipoDeONG;
	private int cantidadDeTrabajadores;
	private Ubicacion ubicacion;
	
	Organizacion(ONG tipoDeONG, int cantidadDeTrabajadores, Ubicacion ubicacion) {
		super();
		this.setTipoDeONG(tipoDeONG);
		this.setCantidadDeTrabajadores(cantidadDeTrabajadores);
		this.setUbicacion(ubicacion);
	}

	public ONG getTipoDeONG() {
		return tipoDeONG;
	}

	public void setTipoDeONG(ONG tipoDeONG) {
		this.tipoDeONG = tipoDeONG;
	}

	public int getCantidadDeTrabajadores() {
		return cantidadDeTrabajadores;
	}

	public void setCantidadDeTrabajadores(int cantidadDeTrabajadores) {
		this.cantidadDeTrabajadores = cantidadDeTrabajadores;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}	
	
}
