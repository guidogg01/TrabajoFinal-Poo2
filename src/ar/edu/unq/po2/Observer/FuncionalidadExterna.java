package ar.edu.unq.po2.Observer;

import ar.edu.unq.po2.State.Muestra.Muestra;

public interface FuncionalidadExterna {
	
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zonaDeCobertura, Muestra muestra);

}
