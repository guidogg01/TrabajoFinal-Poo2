package ar.edu.unq.po2;

import java.util.List;
import java.util.Map;

import ar.edu.unq.po2.State.Muestra.EstadoDeMuestra;
import ar.edu.unq.po2.State.Muestra.EstadoVotada;
import ar.edu.unq.po2.State.Participante.Participante;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;

public class Muestra {
	
	private TipoDeOpinion   tipoDeVinchucaFotografiada;
	private String          foto;
	private Participante    participante;
	private int             idDeParticipante;
	private Ubicacion       ubicacion;
	private LocalDate       fechaDeCreacion;
	private List<Opinion>   opiniones;
	private EstadoDeMuestra estadoActual;
	
	public Muestra(TipoDeOpinion tipoDeVinchucaFotografiada, Participante participante, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		super();
		this.setTipoDeVinchucaFotografiada(tipoDeVinchucaFotografiada);
		this.setFoto(this.getTipoDeVinchucaFotografiada().getDescripcion()); //En base a la vinchuca fotografiada es la descripción.
		this.setParticipante(participante);
		this.setIdDeParticipante(this.getParticipante().getID());
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

	public Participante getParticipante() {
		return participante;
	}

	private void setParticipante(Participante participante) {
		this.participante = participante;
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
		// agarra todos los expertos que hayan votado, y se fija si hay al menos 2 que opinan lo mismo.		
		return this.opinionesDeExpertos().stream()
				                         .anyMatch(tipoDeOpinion1 -> this.opinionesDeExpertos()
				                           .stream()
				                	       .anyMatch(tipoDeOpinion2 -> tipoDeOpinion1.equals(tipoDeOpinion2)));
	}
	
	public TipoDeOpinion resultadoActual() { 
		TipoDeOpinion resultado = votoPorParticipantesBasicos();
		if (esVotadaPorExpertos()) {
			resultado = votoPorParticipantesExpertos();
		}
		return resultado;
	} 
	
	private List<TipoDeOpinion> opinionesDeExpertos() {
		List<TipoDeOpinion> nuevaListaDeOpiniones = new ArrayList<>();
		
		List<TipoDeOpinion> opinionesDeExpertos = this.getOpiniones().stream()
				                                                     .filter(o -> o.esOpinadaPorExperto())
				                                                     .map(o -> o.getTipoDeOpinion())
				                                                     .toList();
		nuevaListaDeOpiniones.addAll(opinionesDeExpertos);
		
		if (this.getParticipante().esExperto()) {
			nuevaListaDeOpiniones.add(this.getTipoDeVinchucaFotografiada());
		}
		
		return nuevaListaDeOpiniones;
	}
	
	private List<TipoDeOpinion> opinionesDeBasicos() {
		List<TipoDeOpinion> nuevaListaDeOpiniones = new ArrayList<>();
		
		List<TipoDeOpinion> opinionesDeBasicos = this.getOpiniones().stream()
				                                                    .filter(o -> !o.esOpinadaPorExperto())
				                                                    .map(o -> o.getTipoDeOpinion())
				                                                    .toList();
		nuevaListaDeOpiniones.addAll(opinionesDeBasicos);
		
		if (!this.getParticipante().esExperto()) {
			nuevaListaDeOpiniones.add(this.getTipoDeVinchucaFotografiada());
		}
		
		return nuevaListaDeOpiniones;
	}
	
	private TipoDeOpinion votoPorParticipantesBasicos() {
		return this.encontrarTipoDeOpinionMasRepetido(this.opinionesDeBasicos());
	}
	
	private TipoDeOpinion votoPorParticipantesExpertos() {
		return this.encontrarTipoDeOpinionMasRepetido(this.opinionesDeExpertos());
	}
	
	private TipoDeOpinion encontrarTipoDeOpinionMasRepetido(List<TipoDeOpinion> opinionesAProcesar) {
		
		Map<TipoDeOpinion, Integer> contador = new HashMap<>();
        TipoDeOpinion elementoMasRepetido = null;
        int maxFrecuencia = 0;
        
        for (TipoDeOpinion tipoDeOpinion : opinionesAProcesar) {
            int frecuencia = contador.getOrDefault(tipoDeOpinion, 0) + 1;
            contador.put(tipoDeOpinion, frecuencia);
            
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                elementoMasRepetido = tipoDeOpinion;
            } else if(frecuencia == maxFrecuencia) {
            	elementoMasRepetido = TipoDeOpinion.NODEFINIDO;
            }
        }
        
        return elementoMasRepetido;
	}
	
	public boolean esVotadaPorExpertos() {
		return this.getParticipante().esExperto() || this.getOpiniones().stream().anyMatch(o -> o.esOpinadaPorExperto());
	}

	public boolean esVerificada() {
		// Se crea en mensaje esVerificada debido a que genera una mayor abstracción.
		return this.coincidieronExpertos();
	}

	public boolean elParticipanteYaOpino(Participante participante) {
		return this.getOpiniones()
				   .stream()
				   .anyMatch(o -> o.fueCreadaPor(participante));
	}
	
}