package ar.edu.unq.po2;

import java.time.LocalDate;

import ar.edu.unq.po2.State.Participante.Participante;

public class Opinion {
	
	private TipoDeOpinion tipoDeOpinion;
	private Participante  opinador;
	private LocalDate     fechaDeCreacion;
	
	public Opinion(TipoDeOpinion tipoDeOpinion, Participante opinador, LocalDate fechaDeCreacion) {
		super();
		this.setTipoDeOpinion(tipoDeOpinion);
		this.setOpinador(opinador);
		this.setFechaDeCreacion(fechaDeCreacion); 
	}

	public TipoDeOpinion getTipoDeOpinion() {
		return tipoDeOpinion;
	}

	private void setTipoDeOpinion(TipoDeOpinion tipoDeOpinion) {
		if (esTipoIndebido(tipoDeOpinion)) {
			throw new IllegalArgumentException("Error, no es un tipo de opinion valido.");
		}
		
		this.tipoDeOpinion = tipoDeOpinion;
	}


	public Participante getOpinador() {
		return opinador;
	}

	private void setOpinador(Participante opinador) {
		this.opinador = opinador;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	private void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	private boolean esTipoIndebido(TipoDeOpinion tipoDeOpinion) {
		return tipoDeOpinion == TipoDeOpinion.NODEFINIDO;
	}

	public boolean esOpinadaPorExperto() {
		return this.getOpinador().esExperto();
	}

	public boolean fueCreadaPor(Participante participante) {//TESTEAR
		return this.getOpinador().equals(participante);
	}
	
}