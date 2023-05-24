package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ubicacion2TestCase {

	private Ubicacion2 ubicacion1;
	private Ubicacion2 ubicacion2;
	private Ubicacion2 ubicacion3;
	private Ubicacion2 ubicacion4;
	
	@BeforeEach
	public void setUp() {
		
		ubicacion1 = new Ubicacion2(2d,5d);
		ubicacion2 = new Ubicacion2(4d,8d);
		ubicacion3 = new Ubicacion2(1d,3d);
		ubicacion4 = new Ubicacion2(7d,2d);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaUbicacion() {
		
		int longitudEsperada = 2;
		int latitudEsperada  = 5;
		
		assertEquals(longitudEsperada, this.ubicacion1.getLongitud());
		assertEquals(latitudEsperada,  this.ubicacion1.getLatitud());
	}

	@Test
	void verificacionDeDistanciaEntreDosUbicaciones() {
		
		// creacion de valores esperados
		int distanciaEsperada = 5;
		
		// Excercise
		Double distanciaRecibida = this.ubicacion1.distanciaCon(this.ubicacion2);
		
		assertEquals(distanciaEsperada, distanciaRecibida);
	}
	
	@Test
	void verificacionUbicacionesCercanasAMenosDeCiertaDistancia() {
		
		List<Ubicacion2> ubicacionesAComparar = Arrays.asList(this.ubicacion2, 
				                                             this.ubicacion3, 
				                                             this.ubicacion4);
		
		List<Ubicacion2> ubicacionesCercanasEsperadas = Arrays.asList(this.ubicacion3);
		
		// mockeando el Point que es la distancia maxima que puede haber entre dos ubicaciones.
		
		assertEquals(ubicacionesCercanasEsperadas, this.ubicacion1.ubicacionesCercanasA(4d, ubicacionesAComparar));
	}
	
}
