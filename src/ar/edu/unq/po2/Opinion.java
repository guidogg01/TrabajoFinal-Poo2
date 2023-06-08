package ar.edu.unq.po2;

import java.time.LocalDate;

public class Opinion {
	
	private TipoDeOpinion tipoDeOpinion;
	private Participante  opinador;
	private LocalDate     fechaDeCreacion;
	
	Opinion(TipoDeOpinion tipoDeOpinion, Participante opinador, LocalDate fechaDeCreacion) {
		super();
		this.setTipoDeOpinion(tipoDeOpinion);
		this.setOpinador(opinador);
		this.setFechaDeCreacion(fechaDeCreacion);
	}

	public TipoDeOpinion getTipoDeOpinion() {
		return tipoDeOpinion;
	}

	private void setTipoDeOpinion(TipoDeOpinion tipoDeOpinion) {
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

	public boolean esOpinadaPorExperto() {
		return this.getOpinador().esExperto();
	}

	public boolean tieneMismoTipoDeOpinionQue(Opinion opinion) {
		return this.getTipoDeOpinion().equals(opinion.getTipoDeOpinion());
	}
}