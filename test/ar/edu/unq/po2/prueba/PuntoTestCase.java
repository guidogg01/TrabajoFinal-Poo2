package ar.edu.unq.po2.prueba;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoTestCase {

	private Punto punto1;
	private Punto punto2;
	
	@BeforeEach
	void setUp() {
		punto1 = new Punto(2,4);
		punto2 = mock(Punto.class);
		
	}
	
	@Test
	void testPrueba() {
		assertEquals(2,punto1.getX());
	}
	
	@Test
	void testPrueba1() {
		when(punto2.getX()).thenReturn(2f);
	
		assertEquals(2f, punto2.getX());
	}

}
