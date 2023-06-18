package ar.edu.unq.po2.State.Participante;

import java.time.LocalDate;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class NivelExpertoVerificado extends NivelDeConocimiento {

	public NivelExpertoVerificado(Participante participante) {
		super(participante);
	}

	@Override
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		
		if(this.getParticipante().esMiMuestra(muestra) || this.getParticipante().opineSobre(muestra)) {
			throw new IllegalArgumentException("Error, no es posible realizar la opinion.");
		}
				
		Opinion nuevaOpinion = new Opinion(tipoDeOpinion, this.getParticipante(), fechaDeCreacion);
		muestra.agregarOpinion(nuevaOpinion);
		this.getParticipante().agregarOpinion(nuevaOpinion);
				
	}

	@Override
	public String nivelDeConocimiento() {
		return "Soy un participante de nivel experto verificado.";
	}

	@Override
	public void verificacionDeEstado() {
		// No se implementa debido a que siempre será nivel experto verificado y su estado no se modifica. 		
	}

	@Override
	public void enviarMuestra(TipoDeOpinion tipoDeVinchuca, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		Muestra muestraAEnviar = new Muestra(tipoDeVinchuca, this.getParticipante(), ubicacion, fechaDeCreacion);
		
		this.getParticipante().agregarMuestraAPagina(muestraAEnviar);
		
		this.getParticipante().agregarMuestra(muestraAEnviar);
		
	}

}
