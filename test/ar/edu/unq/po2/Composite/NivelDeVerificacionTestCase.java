package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;

class NivelDeVerificacionTestCase {
	
	private NivelDeVerificacion filtro;

	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		filtro = new NivelDeVerificacion(ENivelDeVerificacion.VERIFICADA);
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnFiltroPorNivelDeVerificacion() {		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.filtro.getNivelDeVerificacionAFiltrar());
	}

	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorNivelDeVerificacion() {
		//Mockeando las muestras
		when(muestra1.obtenerNivelDeVerificacion()).thenReturn(ENivelDeVerificacion.VOTADA);
		when(muestra2.obtenerNivelDeVerificacion()).thenReturn(ENivelDeVerificacion.VERIFICADA); 
		when(muestra3.obtenerNivelDeVerificacion()).thenReturn(ENivelDeVerificacion.VOTADA);

		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
	
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra2);
		
		assertEquals(muestrasFiltradasEsperadas, this.filtro.filtrar(muestrasAFiltrar));
	} 
}
