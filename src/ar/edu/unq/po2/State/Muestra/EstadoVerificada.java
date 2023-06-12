package ar.edu.unq.po2.State.Muestra;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;

public class EstadoVerificada extends EstadoDeMuestra {

	public EstadoVerificada(Muestra miMuestra) {
		super(miMuestra);
	}

	@Override
	public ENivelDeVerificacion nivelDeVerificacion() {
		// Se retorna el ENivelDeVerificaicion sin antes analizar la muestra, debido a que una muestra que ya es verificada, no puede volver a ser de estado votada.
		return ENivelDeVerificacion.VERIFICADA;
	}

}
