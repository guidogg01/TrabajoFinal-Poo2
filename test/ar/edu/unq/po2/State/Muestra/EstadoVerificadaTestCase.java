package ar.edu.unq.po2.State.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

class EstadoVerificadaTestCase {

	private EstadoVerificada estado;
	
	private Muestra muestra;
	
	private Opinion opinion;
	
	@BeforeEach
	void setUp() {
		
		muestra = mock(Muestra.class);
		
		opinion = mock(Opinion.class);
		
		estado  = new EstadoVerificada(muestra);
		
	}

	@Test
	void verificacionDeInicializacionDeUnEstadoVerificada() {
		assertEquals(muestra, this.estado.getMiMuestra());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraEsDeEstadoVerificada() {
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.estado.nivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoSeQuiereAgregarUnaOpinionAUnEstadoVerificada() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.estado.agregarOpinion(opinion); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionDeResultadoActualDeUnEstadoVerificada() {
		//Mockeando la muestra
		when(muestra.votoPorParticipantesExpertos()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		assertEquals(TipoDeOpinion.PHTIACHINCHE, this.estado.resultadoActual());
	}
}
