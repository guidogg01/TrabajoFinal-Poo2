package ar.edu.unq.po2.Composite;

import java.util.List;

import ar.edu.unq.po2.Muestra;

public class NivelDeVerificacion implements IFiltro {
	
	private boolean nivelDeVerificacionAFiltrar;

	public NivelDeVerificacion(boolean nivelDeVerificacionAFiltrar) {
		// en caso de ser nivelDeVerificacionAFiltrar igual a true, entonces se deben filtrar por aquellas muestras que si estan verificadas,
		// en caso de ser nivelDeVerificacionAFiltrar igual a false, entonces se deben filtar por aquellas muestras que son votadas.
		super();
		this.setNivelDeVerificacionAFiltrar(nivelDeVerificacionAFiltrar);
	}
	
	public boolean getNivelDeVerificacionAFiltrar() {
		return nivelDeVerificacionAFiltrar;
	}

	private void setNivelDeVerificacionAFiltrar(boolean nivelDeVerificacionAFiltrar) {
		this.nivelDeVerificacionAFiltrar = nivelDeVerificacionAFiltrar;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		return muestrasAFiltrar.stream()
                               .filter(m -> m.esVerificada() && this.getNivelDeVerificacionAFiltrar())
                             //.filter(m -> m.esVerificada().equals(this.getNivelDeVerificacionAFiltrar())) compara que el enum de 
                               .toList();
	}

}
