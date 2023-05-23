package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTestCase {
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacion4;
	
	private Point distanciaMaxima;
	
	
	@BeforeEach
	public void setUp() {
		
		ubicacion1 = new Ubicacion(2, 5);
		ubicacion2 = new Ubicacion(4, 8);
		ubicacion3 = new Ubicacion(1, 3);
		ubicacion4 = new Ubicacion(7, 2);
		
		distanciaMaxima = mock(Point.class);
		
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
	
	@Test
	void verificacionUbicacionesCercanasAMenosDeCiertaDistancia() {
		
		List<Ubicacion> ubicacionesAComparar = Arrays.asList(this.ubicacion2, 
				                                             this.ubicacion3, 
				                                             this.ubicacion4);
		
		List<Ubicacion> ubicacionesCercanasEsperadas = Arrays.asList(this.ubicacion2, 
				                                                     this.ubicacion3);
		
		// mockeando el Point que es la distancia maxima que puede haber entre dos ubicaciones.
		when(this.distanciaMaxima.getX()).thenReturn(2);
		when(this.distanciaMaxima.getY()).thenReturn(4);
		
		assertEquals(ubicacionesCercanasEsperadas, this.ubicacion1.ubicacionesCercanasA(distanciaMaxima, ubicacionesAComparar));
	}

}
