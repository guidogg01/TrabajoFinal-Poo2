package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.State.Muestra.Muestra;

class FechaDeCreacionTestCase {
	
	private FechaDeCreacion filtro;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		filtro = new FechaDeCreacion(LocalDate.of(2023, 4, 27));
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnFiltroPorFechaDeCreacion() {
		//Setup
		LocalDate fechaDeCreacionEsperada = LocalDate.of(2023, 4, 27);
		
		assertEquals(fechaDeCreacionEsperada, this.filtro.getFechaAFiltrar());
	}

	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorFechaDeCreacion() {
		//Mockeando las muestras
		when(muestra1.getFechaDeCreacion()).thenReturn(LocalDate.of(2022, 2, 19));
		when(muestra2.getFechaDeCreacion()).thenReturn(LocalDate.of(2023, 4, 27)); 
		when(muestra3.getFechaDeCreacion()).thenReturn(LocalDate.of(2023, 10, 16));

		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
	
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra2);
		
		assertEquals(muestrasFiltradasEsperadas, this.filtro.filtrar(muestrasAFiltrar));
	}	
	
}
