package ar.edu.unq.po2.State.Muestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

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
	
	public abstract ENivelDeVerificacion nivelDeVerificacion();

	public abstract void agregarOpinion(Opinion opinion);

	public abstract TipoDeOpinion resultadoActual();

}
