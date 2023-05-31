package ar.edu.unq.po2.Composite;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Muestra;

public class AND implements Busqueda {
	
	private Busqueda primerBusqueda;
	private Busqueda segundaBusqueda;

	public AND(Busqueda primerBusqueda, Busqueda segundaBusqueda) {
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
		//Como es un and ...
		List<Muestra> nuevaListaFiltrada = new ArrayList<>();

		List<Muestra> primerFiltrado = this.getPrimerBusqueda().filtrar(muestrasAFiltrar);
		nuevaListaFiltrada.addAll(primerFiltrado);

		List<Muestra> segundoFiltrado = this.getSegundaBusqueda().filtrar(muestrasAFiltrar);
		nuevaListaFiltrada.retainAll(segundoFiltrado);

		return nuevaListaFiltrada;
	}

}
