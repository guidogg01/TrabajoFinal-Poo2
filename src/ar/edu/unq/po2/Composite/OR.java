package ar.edu.unq.po2.Composite;

import java.util.List;
import java.util.ArrayList;

import ar.edu.unq.po2.Muestra;

public class OR implements Busqueda {
	
	private Busqueda primerBusqueda;
	private Busqueda segundaBusqueda;

	public OR(Busqueda primerBusqueda, Busqueda segundaBusqueda) {
		super();
		this.setPrimerBusqueda(primerBusqueda);
		this.setSegundaBusqueda(segundaBusqueda);
	}

	public Busqueda getPrimerBusqueda() {
		return primerBusqueda;
	}

	private void setPrimerBusqueda(Busqueda primerBusqueda) {
		this.primerBusqueda = primerBusqueda;
	}

	public Busqueda getSegundaBusqueda() {
		return segundaBusqueda;
	}

	private void setSegundaBusqueda(Busqueda segundaBusqueda) {
		this.segundaBusqueda = segundaBusqueda;
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) { 
		//Como es un or ambos resultados que salgan de cada busqueda son validos por lo que se hace un append entre las dos listas.
		List<Muestra> nuevaListaFiltrada = new ArrayList<>();

	    List<Muestra> primerFiltrado = this.getPrimerBusqueda().filtrar(muestrasAFiltrar);
	    nuevaListaFiltrada.addAll(primerFiltrado);

	    List<Muestra> segundoFiltrado = this.getSegundaBusqueda().filtrar(muestrasAFiltrar);
	    nuevaListaFiltrada.addAll(segundoFiltrado);

	    return nuevaListaFiltrada;
	}

}
