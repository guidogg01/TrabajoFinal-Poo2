package ar.edu.unq.po2.StateMuestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;

public class EstadoVotada extends EstadoDeMuestra {

	public EstadoVotada(Muestra miMuestra) {
		super(miMuestra);
	}

	@Override
	public ENivelDeVerificacion nivelDeVerificacion() {
		
		ENivelDeVerificacion resultado = ENivelDeVerificacion.VOTADA;
		
		if (super.fueVerificada()) {
			this.getMiMuestra().setEstadoActual(new EstadoVerificada(this.getMiMuestra()));
			resultado = ENivelDeVerificacion.VERIFICADA;
		}
		
		return resultado;
	}	

}
