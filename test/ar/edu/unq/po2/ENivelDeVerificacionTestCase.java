package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ENivelDeVerificacionTestCase {

	@Test
	void verificacionDeInicializacionDeUnNivelDeVerificacionVerificada() {
		
		ENivelDeVerificacion nivelDeVerificacion = ENivelDeVerificacion.VERIFICADA;
		ENivelDeVerificacion nivelDeVerificacionEsperada = ENivelDeVerificacion.VERIFICADA;
		
		assertEquals(nivelDeVerificacionEsperada, nivelDeVerificacion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelDeVerificacionVotadaBasicos() {
		
		ENivelDeVerificacion nivelDeVerificacion = ENivelDeVerificacion.VOTADABASICOS;
		ENivelDeVerificacion nivelDeVerificacionEsperada = ENivelDeVerificacion.VOTADABASICOS;
		
		assertEquals(nivelDeVerificacionEsperada, nivelDeVerificacion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelDeVerificacionVotadaExpertos() {
		
		ENivelDeVerificacion nivelDeVerificacion = ENivelDeVerificacion.VOTADAEXPERTOS;
		ENivelDeVerificacion nivelDeVerificacionEsperada = ENivelDeVerificacion.VOTADAEXPERTOS;
		
		assertEquals(nivelDeVerificacionEsperada, nivelDeVerificacion);
	}
}
