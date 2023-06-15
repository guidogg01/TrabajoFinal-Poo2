package ar.edu.unq.po2.Composite;

import java.util.List;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;

public class NivelDeVerificacion implements IFiltro {
	
	private ENivelDeVerificacion nivelDeVerificacionAFiltrar;

	public NivelDeVerificacion(ENivelDeVerificacion nivelDeVerificacionAFiltrar) {
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
