package ar.edu.unq.po2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante {
	
	private int ID;
	private Pagina pagina;
	private List<Muestra> muestras;
	private List<Opinion> opiniones;
	private NivelDeConocimiento nivelDeConocimiento;
	
	public Participante(int id, Pagina pagina) {
		super();
		this.setID(id);
		this.setPagina(pagina);
		this.setMuestras(new ArrayList<Muestra>());
		this.setOpiniones(new ArrayList<Opinion>());
		this.setNivelDeConocimiento(new NivelBasico(this));
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

	public boolean esExperto() {
		return this.getNivelDeConocimiento().esExperto();
	}
	
	private void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}
	
	public void agregarOpinion(Opinion opinion)  {
		this.getOpiniones().add(opinion);
	}
	
	public void enviarMuestra(TipoDeOpinion tipoDeVinchuca, Ubicacion ubicacion) {
		Muestra muestraAEnviar = new Muestra(tipoDeVinchuca, this, ubicacion, LocalDate.now());
		
		this.getPagina().agregarMuestra(muestraAEnviar);
		
		this.agregarMuestra(muestraAEnviar);		
	}
	
	public void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion) {
		
		this.getNivelDeConocimiento().opinarSobre(muestra, tipoDeOpinion);
		
	}


}
