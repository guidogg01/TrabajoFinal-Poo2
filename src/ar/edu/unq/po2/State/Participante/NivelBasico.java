package ar.edu.unq.po2.State.Participante;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.TipoDeOpinion;

public class NivelBasico extends NivelDeConocimiento {

	public NivelBasico(Participante participante) {
		super(participante);
	}
	
	@Override
	public boolean esExperto() {
		return false;
	}

	@Override
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion) {
		// TODO Auto-generated method stub
		
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
