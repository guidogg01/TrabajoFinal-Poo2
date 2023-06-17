package ar.edu.unq.po2.State.Muestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

public class EstadoVotadaExpertos extends EstadoDeMuestra {

	public EstadoVotadaExpertos(Muestra miMuestra) {
		super(miMuestra);
	}

	@Override
	public ENivelDeVerificacion nivelDeVerificacion() {
		
		ENivelDeVerificacion resultado = ENivelDeVerificacion.VOTADAEXPERTOS;
		
		if (this.getMiMuestra().coincidieronExpertos()) {
			this.getMiMuestra().setEstadoActual(new EstadoVerificada(this.getMiMuestra()));
			resultado = ENivelDeVerificacion.VERIFICADA;
		}
		
		return resultado;
	}

	@Override
	public void agregarOpinion(Opinion opinion) {
		if (!opinion.esOpinadaPorExperto()) {
			throw new IllegalArgumentException("Error, no podes votar por ser Participante Basico.");
		} 
		
		this.getMiMuestra().addOpinion(opinion);
		
		if (this.getMiMuestra().coincidieronExpertos()) {
			this.getMiMuestra().setEstadoActual(new EstadoVerificada(this.getMiMuestra()));
		}
		
	}

	@Override
	public TipoDeOpinion resultadoActual() {
		return this.getMiMuestra().votoPorParticipantesExpertos();
	}

}
