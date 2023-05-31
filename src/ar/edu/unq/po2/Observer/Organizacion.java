package ar.edu.unq.po2.Observer;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.Ubicacion;

public class Organizacion implements IZonaDeCoberturaListeners {

	private ONG tipoDeONG;
	private int cantidadDeTrabajadores;
	private Ubicacion ubicacion;
	private ZonaDeCobertura miZonaDeCobertura;
	private FuncionalidadExterna funcionalidadExterna;
	
	Organizacion(ONG tipoDeONG, int cantidadDeTrabajadores, Ubicacion ubicacion, ZonaDeCobertura zonaDeCobertura, FuncionalidadExterna funcionalidadExterna) {
		super();
		this.setTipoDeONG(tipoDeONG);
		this.setCantidadDeTrabajadores(cantidadDeTrabajadores);
		this.setUbicacion(ubicacion);
		this.setMiZonaDeCobertura(zonaDeCobertura);
		this.setFuncionalidadExterna(funcionalidadExterna);
	}

	public ONG getTipoDeONG() {
		return tipoDeONG;
	}

	private void setTipoDeONG(ONG tipoDeONG) {
		this.tipoDeONG = tipoDeONG;
	}

	public int getCantidadDeTrabajadores() {
		return cantidadDeTrabajadores;
	}

	private void setCantidadDeTrabajadores(int cantidadDeTrabajadores) {
		this.cantidadDeTrabajadores = cantidadDeTrabajadores;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	private void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public ZonaDeCobertura getMiZonaDeCobertura() {
		return miZonaDeCobertura;
	}

	private void setMiZonaDeCobertura(ZonaDeCobertura miZonaDeCobertura) {
		this.miZonaDeCobertura = miZonaDeCobertura;
		this.getMiZonaDeCobertura().subscribirObserver(this);
	}

	public FuncionalidadExterna getFuncionalidadExterna() {
		return funcionalidadExterna;
	}

	public void setFuncionalidadExterna(FuncionalidadExterna funcionalidadExterna) {
		this.funcionalidadExterna = funcionalidadExterna;
	}

	@Override
	public void nuevaMuestraCargada(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.getFuncionalidadExterna().nuevoEvento(this, zonaDeCobertura, muestra);
	}
 
	@Override
	public void nuevaValidacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		// this.getFuncionalidadExterna().nuevoEvento(this. zonaDeCobertura, muestra);
	}	
	
}
