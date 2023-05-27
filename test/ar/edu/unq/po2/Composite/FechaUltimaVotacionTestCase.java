package ar.edu.unq.po2.Composite;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;

class FechaUltimaVotacionTestCase {

	private FechaUltimaVotacion filtro;
	
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		filtro = new FechaUltimaVotacion(LocalDate.of(2023, 8, 17));
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnFiltroPorFechaDeCreacion() {
		//Setup
		LocalDate fechaDeCreacionEsperada = LocalDate.of(2023, 8, 17);
		
		assertEquals(fechaDeCreacionEsperada, this.filtro.getFechaAFiltrar());
	}

	
	@Test
	void verificacionDeFiltradoDeUnFiltroPorFechaDeCreacion() {
		//Mockeando las muestras
		when(muestra1.fechaDeUltimaVotacion()).thenReturn(LocalDate.of(2022, 2, 19));
		when(muestra2.fechaDeUltimaVotacion()).thenReturn(LocalDate.of(2023, 8, 17)); 
		when(muestra3.fechaDeUltimaVotacion()).thenReturn(LocalDate.of(2023, 10, 16));

		//Setup
		List<Muestra> muestrasAFiltrar = Arrays.asList(this.muestra1, this.muestra2, this.muestra3);
	
		List<Muestra> muestrasFiltradasEsperadas = Arrays.asList(this.muestra2);
		
		assertEquals(muestrasFiltradasEsperadas, this.filtro.filtrar(muestrasAFiltrar));
	}
}
