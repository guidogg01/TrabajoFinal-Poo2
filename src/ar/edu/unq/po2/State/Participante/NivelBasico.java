package ar.edu.unq.po2.State.Participante;

import java.time.LocalDate;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class NivelBasico extends NivelDeConocimiento {

	public NivelBasico(Participante participante) {
		super(participante);
	}
	
	@Override
	public boolean esExperto() {
		return false;
	}

	@Override
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		if(muestra.esVerificada() 
		   || this.getParticipante().esMiMuestra(muestra) 
		   || this.getParticipante().opineSobre(muestra) 
		   || muestra.esVotadaPorExpertos()) {
			throw new IllegalArgumentException("Error, no es posible realizar la opinion.");
		}
		
		Opinion nuevaOpinion = new Opinion(tipoDeOpinion, this.getParticipante(), fechaDeCreacion);
		muestra.agregarOpinion(nuevaOpinion);
		this.getParticipante().agregarOpinion(nuevaOpinion);
	}

	@Override
	public String nivelDeConocimiento() {
		String mensajeEsperado = "Soy un participante de nivel basico.";
		
		if(super.participoEnMuestrasYOpiniones(10, 20)) {
			this.getParticipante().setNivelDeConocimiento(new NivelExperto(this.getParticipante()));
			mensajeEsperado = "Soy un participante de nivel experto.";
		} else if (super.tieneVerificacionExterna()) {
			this.getParticipante().setNivelDeConocimiento(new NivelExpertoVerificado(this.getParticipante()));
			mensajeEsperado = "Soy un participante de nivel experto verificado.";
		}
		
		return mensajeEsperado;
	}

}
