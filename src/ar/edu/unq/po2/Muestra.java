package ar.edu.unq.po2;

import java.util.List;

import ar.edu.unq.po2.StateMuestra.EstadoDeMuestra;
import ar.edu.unq.po2.StateMuestra.EstadoVotada;

import java.time.LocalDate;
import java.util.ArrayList;

public class Muestra {
	
	private TipoDeOpinion   tipoDeVinchucaFotografiada;
	private String          foto;
	private int             idDeParticipante;
	private Ubicacion       ubicacion;
	private LocalDate       fechaDeCreacion;
	private List<Opinion>   opiniones;
	private EstadoDeMuestra estadoActual;
	
	Muestra(TipoDeOpinion tipoDeVinchucaFotografiada, int idDeParticipante, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		super();
		this.setTipoDeVinchucaFotografiada(tipoDeVinchucaFotografiada);
		this.setFoto(this.getTipoDeVinchucaFotografiada().getDescripcion()); //En base a la vinchuca fotografiada es la descripción.
		this.setIdDeParticipante(idDeParticipante);
		this.setUbicacion(ubicacion);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setOpiniones(new ArrayList<Opinion>());
		this.setEstadoActual(new EstadoVotada(this));
	}

	public TipoDeOpinion getTipoDeVinchucaFotografiada() {
		return tipoDeVinchucaFotografiada;
	}

	private void setTipoDeVinchucaFotografiada(TipoDeOpinion tipoDeVinchucaFotografiada) {
		if (!esTipoAceptable(tipoDeVinchucaFotografiada)) {
			throw new IllegalArgumentException("Error, no es un tipo de vinchuca.");
		}
		this.tipoDeVinchucaFotografiada = tipoDeVinchucaFotografiada;
	}

	public String getFoto() {
		return foto;
	}

	private void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdDeParticipante() {
		return idDeParticipante;
	}

	private void setIdDeParticipante(int idDeParticipante) {
		this.idDeParticipante = idDeParticipante;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	private void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	private void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	private void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	

	public EstadoDeMuestra getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(EstadoDeMuestra estadoActual) {
		// Se deja public debido a que cada estadoActual debe poder cambiar el de la muestra.
		this.estadoActual = estadoActual;
	}
	
	private boolean esTipoAceptable(TipoDeOpinion tipoDeOpinion) {
		return (tipoDeOpinion.equals(TipoDeOpinion.VINCHUCASORDIDA))
				||
			   (tipoDeOpinion.equals(TipoDeOpinion.VINCHUCAINFESTANS))
			    ||
			   (tipoDeOpinion.equals(TipoDeOpinion.VINCHUCAGUASAYANA));
	}

	public void agregarOpinion(Opinion opinion) {
		this.getOpiniones().add(opinion);		
	}

	public double distanciaConMuestra(Muestra muestra) {
		return this.getUbicacion().distanciaCon(muestra.getUbicacion());
	}

	public LocalDate fechaDeUltimaVotacion() {
		return this.getOpiniones().get(this.getOpiniones().size() - 1).getFechaDeCreacion();
	}

	public ENivelDeVerificacion obtenerNivelDeVerificacion() {
		return this.getEstadoActual().nivelDeVerificacion();
	}

	public boolean coincidieronExpertos() {
		// COMPLETAR hacer test
		// agarra todos los expertos que hayan votado, y se fija si hay al menos 2 que opinan lo mismo.
		List<Opinion> opinionesDeExpertos = this.getOpiniones().stream().filter(o -> o.esOpinadaPorExperto()).toList();
		
		return opinionesDeExpertos.stream()
				                  .anyMatch(opinion1 -> this.getOpiniones()
				                    .stream()
				                	.anyMatch(opinion2 -> opinion1.tieneMismoTipoDeOpinionQue(opinion2)));
	}
	
	public TipoDeOpinion resultadoActual() { 
		return this.getTipoDeVinchucaFotografiada();
	}

}