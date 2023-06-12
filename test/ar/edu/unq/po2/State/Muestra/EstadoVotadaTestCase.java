package ar.edu.unq.po2.State.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.State.Muestra.EstadoVotada;

class EstadoVotadaTestCase {
	
	private EstadoVotada estado;
	
	private Muestra muestra;
	
	@BeforeEach
	void setUp() {
		
		muestra = mock(Muestra.class);
		
		estado  = new EstadoVotada(muestra);
		
	}

	@Test
	void verificacionDeInicializacionDeUnEstadoVotada() {
		assertEquals(muestra, this.estado.getMiMuestra());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraNoEsDeEstadoVotada() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(true);
		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.estado.nivelDeVerificacion());
		verify(muestra, times(1)).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraEsDeEstadoVotada() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(false);
		
		assertEquals(ENivelDeVerificacion.VOTADA, this.estado.nivelDeVerificacion());
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}

}
