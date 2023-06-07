package ar.edu.unq.po2.StateMuestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;

public abstract class EstadoDeMuestra {
	
	private Muestra miMuestra;
	
	public EstadoDeMuestra(Muestra miMuestra) {
		super();
		this.setMiMuestra(miMuestra);
	}

	public Muestra getMiMuestra() {
		return miMuestra;
	}

	private void setMiMuestra(Muestra miMuestra) {
		this.miMuestra = miMuestra;
	}
	
	public boolean fueVerificada() {
		return this.getMiMuestra().coincidieronExpertos();
	}
	
	public abstract ENivelDeVerificacion nivelDeVerificacion();

}
