package ar.edu.unq.po2.Observer;

import ar.edu.unq.po2.State.Muestra.Muestra;

public interface IZonaDeCoberturaListeners {
	
	public void nuevaMuestraCargada(ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	public void nuevaValidacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	
}
