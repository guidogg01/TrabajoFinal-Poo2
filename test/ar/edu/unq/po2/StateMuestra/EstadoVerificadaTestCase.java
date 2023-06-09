package ar.edu.unq.po2.StateMuestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.StateMuestra.EstadoVerificada;

class EstadoVerificadaTestCase {

private EstadoVerificada estado;
	
	private Muestra muestra;
	
	@BeforeEach
	void setUp() {
		
		muestra = mock(Muestra.class);
		
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
}
