package ar.edu.unq.po2.State.Participante;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.TipoDeOpinion;

public abstract class NivelDeConocimiento {

	private Participante participante;

	public NivelDeConocimiento(Participante participante) {
		super();
		this.setParticipante(participante);
	}
	
	public Participante getParticipante() {
		return participante;
	}

	private void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public boolean esExperto() {
	// solo debe hacerle override el basico y ponerle false	
		return true;
	}

	public abstract void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion);

	public abstract String nivelDeConocimiento();

	public boolean participoEnMuestrasYOpiniones(int cantMuestras, int cantOpiniones) {
		return (this.getParticipante().realizoMuestrasEnElUltimoMes(cantMuestras))
			    &&
			   (this.getParticipante().realizoOpinionesEnElUltimoMes(cantOpiniones));
	}
	
}
