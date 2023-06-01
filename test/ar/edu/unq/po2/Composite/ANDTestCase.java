package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;

class ANDTestCase {
	
	private AND and;
	private AND and1;
	
	private FechaDeCreacion filtroFechaDeCreacion;
	private FechaUltimaVotacion filtroFechaUltimaVotacion;
	private NivelDeVerificacion filtroNivelDeVerificacion;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra muestra4;
	private Muestra muestra5;

	
	@BeforeEach
	void setUp() {
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		
		filtroFechaDeCreacion     = mock(FechaDeCreacion.class);
		filtroFechaUltimaVotacion = mock(FechaUltimaVotacion.class);
		filtroNivelDeVerificacion = mock(NivelDeVerificacion.class);
		
		and  = new AND(filtroFechaDeCreacion, filtroFechaUltimaVotacion);
		and1 = new AND(filtroNivelDeVerificacion, and);
		
	}

	@Test
	void verificacionDeInicializacionDeUnaBusquedaDeTipoAND() {
		assertEquals(filtroFechaDeCreacion, this.and.getPrimerBusqueda());
		assertEquals(filtroFechaUltimaVotacion, this.and.getSegundaBusqueda());
	}
	
	@Test
	void verificacionDeBusquedaDeTipoANDSoloConLeafs() {
		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
			
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda1 = Arrays.asList(this.muestra2, this.muestra3);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda2 = Arrays.asList(this.muestra3, this.muestra4);
		
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra3);
		
		//Mockeando las busquedas
		when(filtroFechaDeCreacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda1);
		when(filtroFechaUltimaVotacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda2);   
		
		assertEquals(muestrasFiltradasEsperadas, this.and.filtrar(muestrasAFiltrar));
		
		verify(this.filtroFechaDeCreacion, times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroFechaUltimaVotacion, times(1)).filtrar(muestrasAFiltrar);
	} 
	
	@Test
	void verificacionDeBusquedaDeTipoANDConComposite() {
		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3, this.muestra4, this.muestra5);
			
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda1 = Arrays.asList(this.muestra5, this.muestra2, this.muestra3, this.muestra4);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda2 = Arrays.asList(this.muestra5, this.muestra4);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda3 = Arrays.asList(this.muestra4, this.muestra3, this.muestra5);
		
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra4, this.muestra5);
		
		//Mockeando las busquedas
		when(filtroFechaDeCreacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda1);
		when(filtroFechaUltimaVotacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda2);
		when(filtroNivelDeVerificacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda3);
		
		assertEquals(muestrasFiltradasEsperadas, this.and1.filtrar(muestrasAFiltrar));
		
		verify(this.filtroFechaDeCreacion,     times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroFechaUltimaVotacion, times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroNivelDeVerificacion, times(1)).filtrar(muestrasAFiltrar);
	}
	
	@Test
	void verificacionDeBusquedaDeTipoANDRetornaVacio() {
		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3, this.muestra4, this.muestra5);
			
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda1 = Arrays.asList(this.muestra1, this.muestra3);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda2 = Arrays.asList(this.muestra2);
		List<Muestra> muestrasFiltradasEsperadasParaBusqueda3 = Arrays.asList(this.muestra4, this.muestra1, this.muestra5);
		
		//Mockeando las busquedas
		when(filtroFechaDeCreacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda1);
		when(filtroFechaUltimaVotacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda2);
		when(filtroNivelDeVerificacion.filtrar(muestrasAFiltrar)).thenReturn(muestrasFiltradasEsperadasParaBusqueda3);
		
		assertTrue(this.and1.filtrar(muestrasAFiltrar).isEmpty());
		
		verify(this.filtroFechaDeCreacion,     times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroFechaUltimaVotacion, times(1)).filtrar(muestrasAFiltrar);
		verify(this.filtroNivelDeVerificacion, times(1)).filtrar(muestrasAFiltrar);
		
	}
}






















