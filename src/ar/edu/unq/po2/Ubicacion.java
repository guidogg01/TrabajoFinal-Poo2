package ar.edu.unq.po2;

import java.util.List;

public class Ubicacion {

	private double longitud;
	private double latitud;
	
	public Ubicacion(double longitud, double latitud) {
		super();
		this.setLongitud(longitud);
		this.setLatitud(latitud);
	}

	public double getLongitud() {
		return longitud;
	}

	private void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	private void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double distanciaCon(Ubicacion ubicacion) {
		double distanciaLongitud = Math.abs(this.longitud - ubicacion.getLongitud());
		double distanciaLatitud  = Math.abs(this.latitud - ubicacion.getLatitud());
		return distanciaLongitud + distanciaLatitud;
	}

	//Que la distanciaMaxima sea un Double que representa una cantidad de kilómetros...
	public List<Ubicacion> ubicacionesCercanasA(double distanciaMaxima, List<Ubicacion> ubicacionesAComparar) {
		return ubicacionesAComparar.stream()
				                   .filter(u -> u.distanciaCon(this) <= distanciaMaxima)
				                   .toList();
	}
	
}
