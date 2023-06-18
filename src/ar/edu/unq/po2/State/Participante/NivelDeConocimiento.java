package ar.edu.unq.po2.State.Participante;

import java.time.LocalDate;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Muestra.Muestra;

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

	public abstract void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion);
	
	public abstract void verificacionDeEstado();

	public abstract String nivelDeConocimiento();

	public boolean participoEnMuestrasYOpiniones(int cantMuestras, int cantOpiniones) {
		return (this.getParticipante().realizoMuestrasEnElUltimoMes(cantMuestras))
			    &&
			   (this.getParticipante().realizoOpinionesEnElUltimoMes(cantOpiniones));
	}

	public boolean tieneVerificacionExterna() {
		return this.getParticipante().tieneVerificacionExterna();
	}

	public abstract void enviarMuestra(TipoDeOpinion tipoDeVinchuca, Ubicacion ubicacion, LocalDate fechaDeCreacion);
	
}
