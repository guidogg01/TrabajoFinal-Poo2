package ar.edu.unq.po2;

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

	protected abstract void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion);
	
}
