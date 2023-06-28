package ar.edu.unq.po2;

import java.util.List;

import ar.edu.unq.po2.Composite.Busqueda;
import ar.edu.unq.po2.Observer.ZonaDeCobertura;
import ar.edu.unq.po2.State.Muestra.Muestra;

import java.util.ArrayList;

public class Pagina {
	
	private List<Muestra> muestras;
	private List<ZonaDeCobertura> zonasDeCobertura;

	Pagina() {
		super();
		this.setMuestras(new ArrayList<Muestra>());
		this.setZonasDeCobertura(new ArrayList<ZonaDeCobertura>());
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	private void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
	
	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public void setZonasDeCobertura(List<ZonaDeCobertura> zonasDeCobertura) {
		this.zonasDeCobertura = zonasDeCobertura;
	}

	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
		
		this.agregarMuestraAZonaCorrespondiente(muestra);
	}
	
	public void agregarZonaDeCobertura(ZonaDeCobertura zonaDeCobertura) {
		this.getZonasDeCobertura().add(zonaDeCobertura);
	}
	
	private void agregarMuestraAZonaCorrespondiente(Muestra muestra) {
		this.getZonasDeCobertura().stream()
		                          .forEach(z -> z.agregarMuestra(muestra));
	}

	public List<Muestra> muestrasCercanasDe(Muestra muestra, double distanciaMaxima) {
		return this.getMuestras()
				   .stream()
				   .filter(m -> muestra.distanciaConMuestra(m) < distanciaMaxima)
				   .toList();
	}

	public List<Muestra> filtrarMuestras(Busqueda busqueda) {
		return busqueda.filtrar(this.getMuestras());
	}
}