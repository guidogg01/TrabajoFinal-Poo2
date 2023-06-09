package ar.edu.unq.po2.Observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class ZonaDeCobertura extends Subject {

	private List<Muestra> muestras;
	private Ubicacion epicentro;
	private Ubicacion borde; //Hace referencia al borde de la zona de cobertura.
	private String nombre;
	
	ZonaDeCobertura(Ubicacion epicentro, Ubicacion borde, String nombre) {
		super();
		this.setMuestras(new ArrayList<Muestra>());
		this.setEpicentro(epicentro);
		this.setBorde (borde);
		this.setNombre(nombre);
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	private void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	private void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}

	public Ubicacion getBorde() {
		return borde;
	}

	private void setBorde(Ubicacion borde) {
		this.borde = borde;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public double radio() {
		return this.getEpicentro().distanciaCon(this.getBorde());
	}

	public double distancia() {
		return this.diametro()*Math.PI;
	}
	
	private double diametro() {
		return this.radio()*2;
	}

	public List<ZonaDeCobertura> zonasQueSolapan(List<ZonaDeCobertura> zonasAComparar) {
		// Dos ZonaDeCobetura se solapan cuando el radio de zona1 es mayor a la distancia desde el epicentro de zona1, 
		// hasta el borde de zona2.
		return zonasAComparar.stream()
				             .filter(z -> this.radio() > this.getEpicentro().distanciaCon(z.getBorde()))
				             .toList();
	}
	
	private boolean estaDentroDeLaZona(Muestra muestra) {
		// Una Muestra esta dentro de la una zonaDeCobertura, si y solo si el radio de la zonaDeCobertura es mayor a la 
		// distancia desde el epicentro de la zonaDeCobertura hasta la ubicacion de la Muestra.
		return this.radio() > this.getEpicentro().distanciaCon(muestra.getUbicacion());
	} 
	
	public void agregarMuestra(Muestra muestra) {
		if(this.estaDentroDeLaZona(muestra)) {
			this.getMuestras().add(muestra);
			super.notificarCargaDeMuestra(this, muestra);
		}
	}
	
}
