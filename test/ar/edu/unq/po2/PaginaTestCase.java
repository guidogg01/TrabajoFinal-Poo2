package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Composite.Busqueda;
import ar.edu.unq.po2.State.Muestra.Muestra;

class PaginaTestCase {
	
	private Pagina  pagina;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	private Busqueda busqueda;
	
	@BeforeEach
	void setUp() {
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
		busqueda = mock(Busqueda.class);
		
		pagina  = new Pagina();
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaPagina() {
		assertTrue(this.pagina.getMuestras().isEmpty());
	}
	
	@Test
	void verificacionDeCuandoSeAgregaUnaMuestraAUnaPagina() {
		//Excersice
		this.pagina.agregarMuestra(this.muestra1);
		
		assertFalse(this.pagina.getMuestras().isEmpty());
	}
	
	@Test
	void verificacionCuandoUnaPaginaBuscaLasMuestrasCercanasAOtra() {
		//setUp
		this.pagina.agregarMuestra(this.muestra2);
		this.pagina.agregarMuestra(this.muestra3);
		
		List<Muestra> muestrasCercanasEsperadas = Arrays.asList(this.muestra2);
		
		//Mockeando muestras
		when(muestra1.distanciaConMuestra(muestra2)).thenReturn(4d);
		when(muestra1.distanciaConMuestra(muestra3)).thenReturn(8d);
		
		assertEquals(muestrasCercanasEsperadas, this.pagina.muestrasCercanasDe(this.muestra1, 6d));
	}

	@Test
	void verificacionCuandoUnaPaginaRealizaUnFiltradoDeMuestras() {
		//setUp
		this.pagina.agregarMuestra(this.muestra1);
		this.pagina.agregarMuestra(this.muestra2);
		this.pagina.agregarMuestra(this.muestra3);
		
		List<Muestra> muestrasFiltradasPorLaBusqueda = Arrays.asList(this.muestra1);
		
		//Mockeando la busqueda
		when(busqueda.filtrar(pagina.getMuestras())).thenReturn(muestrasFiltradasPorLaBusqueda);
		
		assertEquals(muestrasFiltradasPorLaBusqueda, this.pagina.filtrarMuestras(this.busqueda));
		verify(busqueda, times(1)).filtrar(pagina.getMuestras());
	
	}
	
}


















