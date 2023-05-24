package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UbicacionTestCase {

	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacion4;
	
	@BeforeEach
	public void setUp() {
		
		ubicacion1 = new Ubicacion(2d,5d);
		ubicacion2 = new Ubicacion(4d,8d);
		ubicacion3 = new Ubicacion(1d,3d);
		ubicacion4 = new Ubicacion(7d,2d);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaUbicacion() {
		// Setup
		int longitudEsperada = 2;
		int latitudEsperada  = 5;
		
		assertEquals(longitudEsperada, this.ubicacion1.getLongitud());
		assertEquals(latitudEsperada,  this.ubicacion1.getLatitud());
	}

	@Test
	void verificacionDeDistanciaEntreDosUbicaciones() {
		// Setup
		int distanciaEsperada = 5;
		
		// Excercise
		Double distanciaRecibida = this.ubicacion1.distanciaCon(this.ubicacion2);
		
		assertEquals(distanciaEsperada, distanciaRecibida);
	}
	
	@Test
	void verificacionUbicacionesCercanasAMenosDeCiertaDistancia() {
		// Setup
		List<Ubicacion> ubicacionesAComparar = Arrays.asList(this.ubicacion2, 
				                                             this.ubicacion3, 
				                                             this.ubicacion4);
		List<Ubicacion> ubicacionesCercanasEsperadas = Arrays.asList(this.ubicacion3);
		
		assertEquals(ubicacionesCercanasEsperadas, this.ubicacion1.ubicacionesCercanasA(4d, ubicacionesAComparar));
	}
	
}
