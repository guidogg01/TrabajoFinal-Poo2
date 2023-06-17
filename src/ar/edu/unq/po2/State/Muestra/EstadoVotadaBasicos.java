package ar.edu.unq.po2.State.Muestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

public class EstadoVotadaBasicos extends EstadoDeMuestra {

	public EstadoVotadaBasicos(Muestra miMuestra) {
		super(miMuestra);
	}

	@Override
	public ENivelDeVerificacion nivelDeVerificacion() {
		
		ENivelDeVerificacion resultado = ENivelDeVerificacion.VOTADABASICOS;
		
		if (this.getMiMuestra().coincidieronExpertos()) {
			this.getMiMuestra().setEstadoActual(new EstadoVerificada(this.getMiMuestra()));
			resultado = ENivelDeVerificacion.VERIFICADA;
		}
		
		return resultado;
	}

	@Override
	public void agregarOpinion(Opinion opinion) {
		if (opinion.esOpinadaPorExperto()) {
			this.getMiMuestra().setEstadoActual(new EstadoVotadaExpertos(this.getMiMuestra()));
		}
		this.getMiMuestra().addOpinion(opinion);
	}

	@Override
	public TipoDeOpinion resultadoActual() {
		return this.getMiMuestra().votoPorParticipantesBasicos();
	}	

}
