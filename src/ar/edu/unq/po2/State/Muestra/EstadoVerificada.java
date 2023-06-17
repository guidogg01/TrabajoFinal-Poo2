package ar.edu.unq.po2.State.Muestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

public class EstadoVerificada extends EstadoDeMuestra {

	public EstadoVerificada(Muestra miMuestra) {
		super(miMuestra);
	}

	@Override
	public ENivelDeVerificacion nivelDeVerificacion() {
		// Se retorna el ENivelDeVerificaicion sin antes analizar la muestra, debido a que una muestra que ya es verificada, no puede volver a ser de estado votada.
		return ENivelDeVerificacion.VERIFICADA;
	}

	@Override
	public void agregarOpinion(Opinion opinion) {
		// Se retorna un error debido a que no se le puede agregar una opinion a una Muestra que es Verificada.
		throw new IllegalArgumentException("Error, no se puede agregar una opinion a una Muestra Verificada.");
	}

	@Override
	public TipoDeOpinion resultadoActual() {
		return this.getMiMuestra().votoPorParticipantesExpertos();
	}

}
