package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {

	private List<Muestra> muestras;
	private Ubicacion2 epicentro;
	private Ubicacion2 borde; //Hace referencia al borde de la zona de cobertura.
	private String nombre;
	
	ZonaDeCobertura(Ubicacion2 epicentro, Ubicacion2 borde, String nombre) {
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

	public Ubicacion2 getEpicentro() {
		return epicentro;
	}

	public void setEpicentro(Ubicacion2 epicentro) {
		this.epicentro = epicentro;
	}

	public Ubicacion2 getBorde() {
		return borde;
	}

	public void setBorde(Ubicacion2 borde) {
		this.borde = borde;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double radio() {
		return this.getEpicentro().distanciaCon(this.getBorde());
	}

	public Double distancia() {
		return this.diametro()*Math.PI;
	}
	
	private Double diametro() {
		return this.radio()*2;
	}
	
}
