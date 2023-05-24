package ar.edu.unq.po2;

import java.util.List;

public class Ubicacion2 {

	private Double longitud;
	private Double latitud;
	
	public Ubicacion2(Double longitud, Double latitud) {
		super();
		this.setLongitud(longitud);
		this.setLatitud(latitud);
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	public Double distanciaCon(Ubicacion2 ubicacion) {
		Double distanciaLongitud = Math.abs(this.longitud - ubicacion.getLongitud());
		Double distanciaLatitud  = Math.abs(this.latitud - ubicacion.getLatitud());
		return distanciaLongitud + distanciaLatitud;
	}

	//Que la distanciaMaxima sea un Double que representa una cantidad de kilómetros...
	public List<Ubicacion2> ubicacionesCercanasA(Double distanciaMaxima, List<Ubicacion2> ubicacionesAComparar) {
		return ubicacionesAComparar.stream()
				                   .filter(u -> u.distanciaCon(this) <= distanciaMaxima)
				                   .toList();
	}
	
}
