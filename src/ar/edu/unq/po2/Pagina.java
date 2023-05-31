package ar.edu.unq.po2;

import java.util.List;

import java.util.ArrayList;

public class Pagina {
	
	private List<Muestra> muestras;

	Pagina() {
		super();
		this.setMuestras(new ArrayList<Muestra>());
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	private void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);		
	}

	public List<Muestra> muestrasCercanasDe(Muestra muestra, double distanciaMaxima) {
		return this.getMuestras()
				   .stream()
				   .filter(m -> muestra.distanciaConMuestra(m) < distanciaMaxima)
				   .toList();
	}
}