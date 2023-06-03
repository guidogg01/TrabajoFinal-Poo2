package ar.edu.unq.po2.Observer;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra;

public class Subject {
	
	private List<IZonaDeCoberturaListeners> observers;

	public Subject() {
		super();
		this.setObservers(new ArrayList<IZonaDeCoberturaListeners>());
	}

	public List<IZonaDeCoberturaListeners> getObservers() {
		return observers;
	}

	private void setObservers(List<IZonaDeCoberturaListeners> observers) {
		this.observers = observers;
	}
	
	public void subscribirObserver(IZonaDeCoberturaListeners observer) {
		this.getObservers().add(observer);
	}
	
	public void desubscribirObserver(IZonaDeCoberturaListeners observer) {
		this.getObservers().remove(observer);
	}
	
	public void notificarCargaDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.getObservers()
		    .stream()
		    .forEach(o -> o.nuevaMuestraCargada(zonaDeCobertura, muestra));
		this.notificarValidacionDeMuestra(zonaDeCobertura, muestra);
	}
	
	public void notificarValidacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.getObservers()
		    .stream()
	        .forEach(o -> o.nuevaValidacionDeMuestra(zonaDeCobertura, muestra));
	}

}
