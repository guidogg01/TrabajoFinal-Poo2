package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaDeCoberturaTestCase {

	private ZonaDeCobertura zonaDeCobertura;
	
	private Ubicacion ubicacionDeEpicentro;
	private Ubicacion ubicacionDeBorde;
	
	@BeforeEach
	void setUp() {
		
		ubicacionDeEpicentro = mock(Ubicacion.class);
		ubicacionDeBorde     = mock(Ubicacion.class);
		
		zonaDeCobertura = new ZonaDeCobertura(ubicacionDeEpicentro, ubicacionDeBorde, "Zona Quilmes");
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaZonaDeCobertura() {
		// Setup
		int longitudEsperadaDeEpicentro = 2;
		int longitudEsperadaDeBorde = 6;
		String nombreEsperado = "Zona Quilmes";
		
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentro.getLongitud()).thenReturn(2d);
		when(ubicacionDeBorde.getLongitud()).thenReturn(6d);
		
				
		assertTrue(this.zonaDeCobertura.getMuestras().isEmpty());
		assertEquals(longitudEsperadaDeEpicentro, this.zonaDeCobertura.getEpicentro().getLongitud());
		assertEquals(longitudEsperadaDeBorde, this.zonaDeCobertura.getBorde().getLongitud());
		assertEquals(nombreEsperado, this.zonaDeCobertura.getNombre());
	}
	
	@Test
	void verificacionDeRadioDeUnaZonaDeCobertura() {
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentro.distanciaCon(ubicacionDeBorde)).thenReturn(7d);
		
		assertEquals(7, this.zonaDeCobertura.radio());
	}
	
	@Test
	void verificacionDeDistanciaDeUnaZonaDeCobertura() {
		// Setup
		double distanciaEsperada = 14*Math.PI; //Sería el diametro * PI.
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentro.distanciaCon(ubicacionDeBorde)).thenReturn(7d);
		
		assertEquals(distanciaEsperada, this.zonaDeCobertura.distancia());
	}

}