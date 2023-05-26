package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<IZonaDeCoberturaListeners> observers;

	public Subject() {
		super();
		this.setObservers(new ArrayList<IZonaDeCoberturaListeners>());
	}

	public List<IZonaDeCoberturaListeners> getObservers() {
		return observers;
	}

	public void setObservers(List<IZonaDeCoberturaListeners> observers) {
		this.observers = observers;
	}
	
	public void subscribirObserver(IZonaDeCoberturaListeners observer) {
		this.getObservers().add(observer);
	}
	
	public void desubscribirObserver(IZonaDeCoberturaListeners observer) {
		this.getObservers().remove(observer);
	}

}
