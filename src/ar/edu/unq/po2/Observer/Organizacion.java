package ar.edu.unq.po2.Observer;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.Ubicacion;

public class Organizacion implements IZonaDeCoberturaListeners {

	private ONG tipoDeONG;
	private int cantidadDeTrabajadores;
	private Ubicacion ubicacion;
	private ZonaDeCobertura miZonaDeCobertura;
	
	Organizacion(ONG tipoDeONG, int cantidadDeTrabajadores, Ubicacion ubicacion, ZonaDeCobertura zonaDeCobertura) {
		super();
		this.setTipoDeONG(tipoDeONG);
		this.setCantidadDeTrabajadores(cantidadDeTrabajadores);
		this.setUbicacion(ubicacion);
		this.setMiZonaDeCobertura(zonaDeCobertura);
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

	public ZonaDeCobertura getMiZonaDeCobertura() {
		return miZonaDeCobertura;
	}

	public void setMiZonaDeCobertura(ZonaDeCobertura miZonaDeCobertura) {
		this.miZonaDeCobertura = miZonaDeCobertura;
		this.getMiZonaDeCobertura().subscribirObserver(this);
	}

	@Override
	public void nuevaMuestraCargada(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		// funcionalidad externa, nuevoEvento(...)
	}
 
	@Override
	public void nuevaValidacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		// funcionalidad externa, nuevoEvento(...)
		
	}	
	
}
