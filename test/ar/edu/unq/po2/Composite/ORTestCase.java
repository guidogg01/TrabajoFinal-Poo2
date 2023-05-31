package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;

class ORTestCase {
	
	private OR or;
	
	private FechaDeCreacion filtroFechaDeCreacion;
	private FechaUltimaVotacion filtroFechaUltimaVotacion;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
		filtroFechaDeCreacion     = mock(FechaDeCreacion.class);
		filtroFechaUltimaVotacion = mock(FechaUltimaVotacion.class);
		
		or = new OR(filtroFechaDeCreacion, filtroFechaUltimaVotacion);
		
	}

	@Test
	void verificacionDeInicializacionDeUnaBusquedaDeTipoOR() {
		assertEquals(filtroFechaDeCreacion, this.or.getPrimerBusqueda());
		assertEquals(filtroFechaUltimaVotacion, this.or.getSegundaBusqueda());
	}
	
	@Test
	void verificacionDeBusquedaDeTipoORSoloConLeafs() {
		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
			
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda1 = Arrays.asList(this.muestra2);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda2 = Arrays.asList(this.muestra3);
		
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra2, this.muestra3);
		
		//Mockeando las busquedas
		when(filtroFechaDeCreacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda1);
		when(filtroFechaUltimaVotacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda2);   
		
		assertEquals(muestrasFiltradasEsperadas, this.or.filtrar(muestrasAFiltrar));
		
		verify(this.filtroFechaDeCreacion, times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroFechaUltimaVotacion, times(1)).filtrar(muestrasAFiltrar);
	} 

}
