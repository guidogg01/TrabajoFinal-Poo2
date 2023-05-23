package ar.edu.unq.po2.prueba;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

class UbicacionTestCase {
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	
	
	@BeforeEach
	public void setUp() {
		
		ubicacion1 = new Ubicacion(2, 5);
		ubicacion2 = new Ubicacion(4, 8);
	}

	@Test
	void verificacionDeInicializacionDeUnaUbicacion() {
		
		int ejeXdeLongitudEsperada = 2;
		int ejeYdeLatitudEsperada  = 5;
		
		assertEquals(ejeXdeLongitudEsperada, this.ubicacion1.getLongitud());
		assertEquals(ejeYdeLatitudEsperada,  this.ubicacion1.getLatitud());
	}
	
	@Test
	void verificacionDeDistanciaEntreDosUbicaciones() {
		
		// creacion de valores esperados
		int distanciaEsperadaEnX = 2; 
		int distanciaEsperadaEnY = 3;
		
		// Excercise
		int distanciaRecibidaEnX = this.ubicacion1.distanciaCon(this.ubicacion2).getX();
		int distanciaRecibidaEnY = this.ubicacion1.distanciaCon(this.ubicacion2).getY();
		
		assertEquals(distanciaEsperadaEnX, distanciaRecibidaEnX);
		assertEquals(distanciaEsperadaEnY, distanciaRecibidaEnY);
	}

}
