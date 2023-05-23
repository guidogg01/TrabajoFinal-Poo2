package ar.edu.unq.po2;

import java.util.List;

public class Ubicacion {
	
	private Point punto;
	
	public Ubicacion(int longitud, int latitud) {
		super();
		this.setPunto(new Point(longitud, latitud));
	}

	public Point getPunto() {
		return punto;
	}

	private void setPunto(Point punto) {
		this.punto = punto;
	}

	public int getLongitud() {
		return this.getPunto().getX();
	}
	
	public int getLatitud() {
		return this.getPunto().getY();
	}

	public Point distanciaCon(Ubicacion ubicacion) {
		return this.getPunto().restarCon(ubicacion.getPunto());
	}

	public List<Ubicacion> ubicacionesCercanasA(Point distanciaMaxima, List<Ubicacion> ubicacionesAComparar) {
		return ubicacionesAComparar.stream()
				                   .filter(u -> u.distanciaCon(this).esMenorOIgualQue(distanciaMaxima))
				                   .toList();
	}	

}
