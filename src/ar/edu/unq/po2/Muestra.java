package ar.edu.unq.po2;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Muestra {
	
	private Vinchuca      tipoDeVinchucaFotografiada;
	private String        foto;
	private int           idDeParticipante;
	private Ubicacion     ubicacion;
	private LocalDate     fechaDeCreacion;
	private List<Opinion> opiniones;
	
	Muestra(Vinchuca tipoDeVinchucaFotografiada, int idDeParticipante, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		super();
		this.setTipoDeVinchucaFotografiada(tipoDeVinchucaFotografiada);
		this.setFoto(this.getTipoDeVinchucaFotografiada().getDescripcion()); //En base a la vinchuca fotografiada es la descripción.
		this.setIdDeParticipante(idDeParticipante);
		this.setUbicacion(ubicacion);
		this.setFechaDeCreacion(fechaDeCreacion);
		this.setOpiniones(new ArrayList<Opinion>());
	}

	public Vinchuca getTipoDeVinchucaFotografiada() {
		return tipoDeVinchucaFotografiada;
	}

	private void setTipoDeVinchucaFotografiada(Vinchuca tipoDeVinchucaFotografiada) {
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

	public void agregarOpinion(Opinion opinion) {
		this.getOpiniones().add(opinion);		
	}

	public Double distanciaConMuestra(Muestra muestra) {
		return this.getUbicacion().distanciaCon(muestra.getUbicacion());
	}

	public LocalDate fechaDeUltimaVotacion() {
		return this.getOpiniones().get(this.getOpiniones().size() - 1).getFechaDeCreacion();
	}

	public boolean esVerificada() {
		// retorna true en caso de que 2 expertos la hayan validado, en caso contrario retorna false, lo cual indica que es votada.
		return true; // ESTA HARDCODEADO HACER TDD Y DEMÁS.
	}
	
}