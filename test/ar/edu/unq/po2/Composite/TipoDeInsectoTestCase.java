package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.TipoDeOpinion;

class TipoDeInsectoTestCase {
	
	private TipoDeInsecto filtro;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		filtro = new TipoDeInsecto(TipoDeOpinion.VINCHUCAGUASAYANA);
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnFiltroPorTipoDeInsecto() {		
		assertEquals(TipoDeOpinion.VINCHUCAGUASAYANA, this.filtro.getTipoDeInsectoAFiltrar());
	}

	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorNivelDeVerificacion() {
		//Mockeando las muestras
		when(muestra1.resultadoActual()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(muestra2.resultadoActual()).thenReturn(TipoDeOpinion.VINCHUCAGUASAYANA); 
		when(muestra3.resultadoActual()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);

		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
	
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra2);
		
		assertEquals(muestrasFiltradasEsperadas, this.filtro.filtrar(muestrasAFiltrar));
	}

}
