package ar.edu.unq.po2.State.Participante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.Pagina;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class Participante {
	
	private int ID;
	private Pagina pagina;
	private List<Muestra> muestras;
	private List<Opinion> opiniones;
	private NivelDeConocimiento nivelDeConocimiento;
	private boolean tieneVerificacionExterna;
	
	public Participante(int id, Pagina pagina) {
		super();
		this.setID(id);
		this.setPagina(pagina);
		this.setMuestras(new ArrayList<Muestra>());
		this.setOpiniones(new ArrayList<Opinion>());
		this.setNivelDeConocimiento(new NivelBasico(this));
		this.setTieneVerificacionExterna(false);
	}

	public int getID() {
		return this.ID;
	}
	
	private void setID(int id) {
		this.ID = id;
	}
	
	public Pagina getPagina() {
		return pagina;
	}

	private void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	private void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	private void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public NivelDeConocimiento getNivelDeConocimiento() {
		return nivelDeConocimiento;
	}

	public void setNivelDeConocimiento(NivelDeConocimiento nivelDeConocimiento) {
		this.nivelDeConocimiento = nivelDeConocimiento;
	}
	
	public boolean isTieneVerificacionExterna() {
		return tieneVerificacionExterna;
	}

	private void setTieneVerificacionExterna(boolean tieneVerificacionExterna) {
		this.tieneVerificacionExterna = tieneVerificacionExterna;
	}
	
	public void otorgarVerificacionExterna() {
		this.setTieneVerificacionExterna(true);
		this.setNivelDeConocimiento(new NivelExpertoVerificado(this));
	}

	public boolean esExperto() {
		return this.getNivelDeConocimiento().esExperto();
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
	
	public void agregarOpinion(Opinion opinion)  {
		this.getOpiniones().add(opinion);
	}
	
	public void enviarMuestra(TipoDeOpinion tipoDeVinchuca, Ubicacion ubicacion, LocalDate fechaDeCreacion) {
		this.getNivelDeConocimiento().enviarMuestra(tipoDeVinchuca, ubicacion, fechaDeCreacion);
	}
	
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		this.getNivelDeConocimiento().opinarSobre(muestra, tipoDeOpinion, fechaDeCreacion);
	}

	public String obtenerNivelDeConocimiento() {
		return this.getNivelDeConocimiento().nivelDeConocimiento();
	}

	public boolean realizoMuestrasEnElUltimoMes(int cantMuestras) {		
		int cantMuestrasObtenidas = this.getMuestras()
				                        .stream()
				                        .filter(m -> LocalDate.now().compareTo(m.getFechaDeCreacion()) <= 30)
										.toList()
										.size();
		
		return cantMuestrasObtenidas >= cantMuestras;
	}

	public boolean realizoOpinionesEnElUltimoMes(int cantOpiniones) {
		int cantOpinionesObtenidas = this.getOpiniones()
                						 .stream()
                						 .filter(o -> LocalDate.now().compareTo(o.getFechaDeCreacion()) <= 30)
                						 .toList()
                						 .size();
		
		return cantOpinionesObtenidas >= cantOpiniones;
	}

	public boolean tieneVerificacionExterna() {
		// Se crea el mensaje tieneVerificacionExterna para generar abstraccion.
		return this.isTieneVerificacionExterna();
	}

	public boolean esMiMuestra(Muestra muestra) {
		return this.getMuestras()
				   .stream()
				   .anyMatch(m -> m.equals(muestra));
	}

	public boolean opineSobre(Muestra muestra) {
		return muestra.elParticipanteYaOpino(this);
	}

	public void agregarMuestraAPagina(Muestra muestraAEnviar) { //Testear
		this.getPagina().agregarMuestra(muestraAEnviar);		
	}

}
