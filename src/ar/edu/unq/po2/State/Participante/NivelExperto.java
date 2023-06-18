package ar.edu.unq.po2.State.Participante;

import java.time.LocalDate;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class NivelExperto extends NivelDeConocimiento {

	public NivelExperto(Participante participante) {
		super(participante);
	}

	@Override
	public String nivelDeConocimiento() {
		String mensajeEsperado = "Soy un participante de nivel experto.";
		
		if(!super.participoEnMuestrasYOpiniones(10, 20)) {
			this.getParticipante().setNivelDeConocimiento(new NivelBasico(this.getParticipante()));
			mensajeEsperado = "Soy un participante de nivel basico.";
		} else if (super.tieneVerificacionExterna()) {
			this.getParticipante().setNivelDeConocimiento(new NivelExpertoVerificado(this.getParticipante()));
			mensajeEsperado = "Soy un participante de nivel experto verificado.";
		}
		
		return mensajeEsperado;
	}

	@Override
	public void verificacionDeEstado() {
		if (!super.participoEnMuestrasYOpiniones(10, 20)) {
			this.getParticipante().setNivelDeConocimiento(new NivelBasico(this.getParticipante()));
		}
		
	}

	@Override
	public void enviarMuestra(TipoDeOpinion tipoDeVinchuca, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		Muestra muestraAEnviar = new Muestra(tipoDeVinchuca, this.getParticipante(), ubicacion, fechaDeCreacion);
		
		this.getParticipante().agregarMuestraAPagina(muestraAEnviar);
		
		this.getParticipante().agregarMuestra(muestraAEnviar);
		
		this.verificacionDeEstado();
		
	}

	@Override
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		
		this.verificacionDeEstado();
		
		if(this.getParticipante().esMiMuestra(muestra) || this.getParticipante().opineSobre(muestra)) {
			throw new IllegalArgumentException("Error, no es posible realizar la opinion.");
		}
				
		Opinion nuevaOpinion = new Opinion(tipoDeOpinion, this.getParticipante(), fechaDeCreacion);
		muestra.agregarOpinion(nuevaOpinion);
		this.getParticipante().agregarOpinion(nuevaOpinion);
			
		
	}

}
