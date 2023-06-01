package ar.edu.unq.po2;

import java.util.List;

import ar.edu.unq.po2.Composite.ENivelDeVerificacion;

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

	public double distanciaConMuestra(Muestra muestra) {
		return this.getUbicacion().distanciaCon(muestra.getUbicacion());
	}

	public LocalDate fechaDeUltimaVotacion() {
		return this.getOpiniones().get(this.getOpiniones().size() - 1).getFechaDeCreacion();
	}

	public ENivelDeVerificacion obtenerNivelDeVerificacion() {
		ENivelDeVerificacion resultado = ENivelDeVerificacion.VOTADA;
		// Una opinion es verificada cuando dos expertos opinan lo mismo.
		if(this.getOpiniones().stream().filter(o -> o.esOpinionDeExperto()).count((Opinion o1, Opinion o2) -> o1.tieneElMismoTipoDeOpinionQue(o2)).size() >= 2) {
			resultado = ENivelDeVerificacion.VERIFICADA;
		}
		return resultado;
	}

}