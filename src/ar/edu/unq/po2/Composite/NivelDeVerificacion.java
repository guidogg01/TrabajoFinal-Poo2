package ar.edu.unq.po2.Composite;

import java.util.List;

import ar.edu.unq.po2.Muestra;

public class NivelDeVerificacion implements IFiltro {
	
	private ENivelDeVerificacion nivelDeVerificacionAFiltrar;

	public NivelDeVerificacion(ENivelDeVerificacion nivelDeVerificacionAFiltrar) {
		// en caso de ser nivelDeVerificacionAFiltrar igual a true, entonces se deben filtrar por aquellas muestras que si estan verificadas,
		// en caso de ser nivelDeVerificacionAFiltrar igual a false, entonces se deben filtar por aquellas muestras que son votadas.
		super();
		this.setNivelDeVerificacionAFiltrar(nivelDeVerificacionAFiltrar);
	}
	
	public ENivelDeVerificacion getNivelDeVerificacionAFiltrar() {
		return nivelDeVerificacionAFiltrar;
	}

	private void setNivelDeVerificacionAFiltrar(ENivelDeVerificacion nivelDeVerificacionAFiltrar) {
		this.nivelDeVerificacionAFiltrar = nivelDeVerificacionAFiltrar;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		return muestrasAFiltrar.stream()
                               .filter(m -> m.obtenerNivelDeVerificacion().equals(this.getNivelDeVerificacionAFiltrar())) 
                               .toList();
	}

}
