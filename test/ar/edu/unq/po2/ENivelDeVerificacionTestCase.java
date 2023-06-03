package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Observer.ONG;

class ENivelDeVerificacionTestCase {

	@Test
	void verificacionDeInicializacionDeUnNivelDeVerificacionVerificada() {
		
		ENivelDeVerificacion nivelDeVerificacion = ENivelDeVerificacion.VERIFICADA;
		ENivelDeVerificacion nivelDeVerificacionEsperada = ENivelDeVerificacion.VERIFICADA;
		
		assertEquals(nivelDeVerificacionEsperada, nivelDeVerificacion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelDeVerificacionVotada() {
		
		ENivelDeVerificacion nivelDeVerificacion = ENivelDeVerificacion.VOTADA;
		ENivelDeVerificacion nivelDeVerificacionEsperada = ENivelDeVerificacion.VOTADA;
		
		assertEquals(nivelDeVerificacionEsperada, nivelDeVerificacion);
	}
}
