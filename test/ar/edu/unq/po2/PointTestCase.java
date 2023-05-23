package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointTestCase {
	
	private Point punto1;
	private Point punto2;

	@BeforeEach
	public void setUp() {
		punto1 = new Point();
		punto2 = new Point(2, 3);
	}
	
	@Test
	void verificacionDeInicializacionDeUnPointPorDefault() {
		int ejeXEsperado = 0;
		int ejeYEsperado = 0;
		
		assertEquals(ejeXEsperado, punto1.getX());
		assertEquals(ejeYEsperado, punto1.getY());
	}
	
	@Test
	void verificacionDeInicializacionDeUnPointConCoordenadas() {
		int ejeXEsperado = 2;
		int ejeYEsperado = 3;
		
		assertEquals(ejeXEsperado, punto2.getX());
		assertEquals(ejeYEsperado, punto2.getY());
	}
	
	@Test
	void verificacionDeRestaEntreDosPuntos() {
		int ejeXEsperado = 1;
		int ejeYEsperado = 2;
		
		Point punto3 = new Point(1, 5);
		
		Point puntoRecibido = this.punto2.restarCon(punto3);
		
		assertEquals(ejeXEsperado, puntoRecibido.getX());
		assertEquals(ejeYEsperado, puntoRecibido.getY());
	}
	
	@Test
	void verificacionCuandoUnPuntoNoEsMenorOIgualQueOtroPunto() {
		assertFalse(this.punto2.esMenorOIgualQue(this.punto1));
	}
	
	@Test
	void verificacionCuandoUnPuntoEsMenorOIgualQueOtroPunto() {
		assertTrue(this.punto1.esMenorOIgualQue(this.punto2));
	}

}
