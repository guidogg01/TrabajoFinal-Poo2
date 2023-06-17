package ar.edu.unq.po2.Composite;

import java.util.List;

import ar.edu.unq.po2.State.Muestra.Muestra;

public interface Busqueda {

	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar);
	
}
