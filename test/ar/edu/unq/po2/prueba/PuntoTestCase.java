package ar.edu.unq.po2.prueba;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoTestCase {

	private Punto punto1;
	
	@BeforeEach
	void setUp() {
		punto1 = new Punto(2,4);
	}
	
	@Test
	void testPrueba() {
		assertEquals(2,punto1.getX());
	}

}
