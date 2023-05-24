package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {

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

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public void setEpicentro(Ubicacion epicentro) {
		this.epicentro = epicentro;
	}

	public Ubicacion getBorde() {
		return borde;
	}

	public void setBorde(Ubicacion borde) {
		this.borde = borde;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int radio() {
		return this.getEpicentro().distanciaCon(this.getBorde());
	}

	public Double distancia() {
		return this.diametro()*Math.PI;
	}
	
	private int diametro() {
		return this.radio()*2;
	}
	
}
