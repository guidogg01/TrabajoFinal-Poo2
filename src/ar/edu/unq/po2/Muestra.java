package ar.edu.unq.po2;

import java.util.List;

import java.util.ArrayList;

public class Muestra {
	
	private Vinchuca      tipoDeVinchucaFotografiada;
	private String        foto;
	private int           idDeParticipante;
	private Ubicacion     ubicacion;
	private List<Opinion> opiniones;
	
	Muestra(Vinchuca tipoDeVinchucaFotografiada, int idDeParticipante, Ubicacion ubicacion) {
		super();
		this.setTipoDeVinchucaFotografiada(tipoDeVinchucaFotografiada);
		this.setFoto(this.getTipoDeVinchucaFotografiada().getDescripcion()); //En base a la vinchuca fotografiada es la descripción.
		this.setIdDeParticipante(idDeParticipante);
		this.setUbicacion(ubicacion);
		this.setOpiniones(new ArrayList<Opinion>());
	}

	public Vinchuca getTipoDeVinchucaFotografiada() {
		return tipoDeVinchucaFotografiada;
	}

	public void setTipoDeVinchucaFotografiada(Vinchuca tipoDeVinchucaFotografiada) {
		this.tipoDeVinchucaFotografiada = tipoDeVinchucaFotografiada;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdDeParticipante() {
		return idDeParticipante;
	}

	public void setIdDeParticipante(int idDeParticipante) {
		this.idDeParticipante = idDeParticipante;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public void agregarOpinion(Opinion opinion) {
		this.getOpiniones().add(opinion);		
	}

	public Double distanciaConMuestra(Muestra muestra) {
		return this.getUbicacion().distanciaCon(muestra.getUbicacion());
	}
	
}