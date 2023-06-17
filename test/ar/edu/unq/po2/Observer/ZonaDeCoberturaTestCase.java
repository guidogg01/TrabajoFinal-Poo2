package ar.edu.unq.po2.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.Observer.Organizacion;
import ar.edu.unq.po2.Observer.ZonaDeCobertura;
import ar.edu.unq.po2.State.Muestra.Muestra;

class ZonaDeCoberturaTestCase {

	private ZonaDeCobertura zonaQuilmes;
	private Ubicacion ubicacionDeEpicentroQuilmes;
	private Ubicacion ubicacionDeBordeQuilmes;
	
	private ZonaDeCobertura zonaBernal;
	private Ubicacion ubicacionDeEpicentroBernal;
	private Ubicacion ubicacionDeBordeBernal;
	
	private ZonaDeCobertura zonaWilde;
	private Ubicacion ubicacionDeEpicentroWilde;
	private Ubicacion ubicacionDeBordeWilde;
	
	private Muestra muestra;
	private Ubicacion ubicacionDeMuestra;
	
	private Organizacion organizacionObserver;
	
	@BeforeEach
	void setUp() {
		
		muestra     = mock(Muestra.class);
		ubicacionDeMuestra = mock(Ubicacion.class);
		
		ubicacionDeEpicentroQuilmes = mock(Ubicacion.class);
		ubicacionDeBordeQuilmes     = mock(Ubicacion.class);
		
		ubicacionDeEpicentroBernal  = mock(Ubicacion.class);
		ubicacionDeBordeBernal      = mock(Ubicacion.class);
		
		ubicacionDeEpicentroWilde   = mock(Ubicacion.class);
		ubicacionDeEpicentroWilde   = mock(Ubicacion.class);
		
		zonaQuilmes = new ZonaDeCobertura(ubicacionDeEpicentroQuilmes, ubicacionDeBordeQuilmes, "Zona Quilmes");
		
		zonaBernal  = new ZonaDeCobertura(ubicacionDeEpicentroBernal, ubicacionDeBordeBernal, "Zona Bernal");
		
		zonaWilde   = new ZonaDeCobertura(ubicacionDeEpicentroWilde, ubicacionDeBordeWilde, "Zona Wilde");
		
		organizacionObserver = mock(Organizacion.class);
		
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaZonaDeCobertura() {
		// Setup
		int longitudEsperadaDeEpicentro = 2;
		int longitudEsperadaDeBorde = 6;
		String nombreEsperado = "Zona Quilmes";
		
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentroQuilmes.getLongitud()).thenReturn(2d);
		when(ubicacionDeBordeQuilmes.getLongitud()).thenReturn(6d);
		
				
		assertTrue(this.zonaQuilmes.getMuestras().isEmpty());
		assertEquals(longitudEsperadaDeEpicentro, this.zonaQuilmes.getEpicentro().getLongitud());
		assertEquals(longitudEsperadaDeBorde, this.zonaQuilmes.getBorde().getLongitud());
		assertEquals(nombreEsperado, this.zonaQuilmes.getNombre());
	}
	
	@Test
	void verificacionDeRadioDeUnaZonaDeCobertura() {
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d);
		
		assertEquals(7, this.zonaQuilmes.radio());
	}
	
	@Test
	void verificacionDeDistanciaDeUnaZonaDeCobertura() {
		// Setup
		double distanciaEsperada = 14*Math.PI; //Sería el diametro * PI.
		
		//Mockeando las ubicaciones.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d);
		
		assertEquals(distanciaEsperada, this.zonaQuilmes.distancia());
	}
	
	@Test
	void verificacionDeZonasDeCoberturaQueSeSolapan() {
		//Setup
		List<ZonaDeCobertura> zonasAComparar = Arrays.asList(this.zonaBernal, this.zonaWilde);
		
		List<ZonaDeCobertura> zonasEsperadas = Arrays.asList(this.zonaBernal);
		
		//Mockeando cada una de las ubicaciones de cada ZonaDeCobertura.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d); // el radio de ZonaQuilmes
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeBernal)).thenReturn(4d);  // distancia entre el epicentro de ZonaQuilmes y el borde de ZonaBernal.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeWilde)).thenReturn(11d);  // distancia entre el epicentro de ZonaQuilmes y el borde de ZonaWilde.
		
		assertEquals(zonasEsperadas, this.zonaQuilmes.zonasQueSolapan(zonasAComparar));
	}
	
	@Test
	void verificacionDeAgregadoValidoDeUnaMuestraAUnaZonaDeCobertura() {
		//Mockeando la ubicacion de la muestra
		when(ubicacionDeMuestra.getLatitud()).thenReturn(1d);
		when(ubicacionDeMuestra.getLongitud()).thenReturn(3d);
		
		//Mockeando la muestra
		when(muestra.getUbicacion()).thenReturn(ubicacionDeMuestra);
		
		//Mockeando las ubicaciones de zonaQuilmes.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d); // el radio de ZonaQuilmes
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeMuestra)).thenReturn(4d);
		
		//Excersice
		this.zonaQuilmes.agregarMuestra(this.muestra);
		
		assertFalse(this.zonaQuilmes.getMuestras().isEmpty());
	}
	
	@Test
	void verificacionDeAgregadoNoValidoDeUnaMuestraAUnaZonaDeCobertura() {
		//Mockeando la ubicacion de la muestra
		when(ubicacionDeMuestra.getLatitud()).thenReturn(1d);
		when(ubicacionDeMuestra.getLongitud()).thenReturn(3d);
		
		//Mockeando la muestra
		when(muestra.getUbicacion()).thenReturn(ubicacionDeMuestra);
		
		//Mockeando las ubicaciones de zonaQuilmes.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d); // el radio de ZonaQuilmes
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeMuestra)).thenReturn(9d);
		
		//Excersice
		this.zonaQuilmes.agregarMuestra(this.muestra);
		
		assertTrue(this.zonaQuilmes.getMuestras().isEmpty());
	}
	
	@Test
	void verificacionCuandoUnaZonaDeCoberturaAgregaUnaMuestraLeNotificaASusListeners() {
		//Mockeando la ubicacion de la muestra
		when(ubicacionDeMuestra.getLatitud()).thenReturn(1d);
		when(ubicacionDeMuestra.getLongitud()).thenReturn(3d);
		
		//Mockeando la muestra
		when(muestra.getUbicacion()).thenReturn(ubicacionDeMuestra);
		
		//Mockeando las ubicaciones de zonaQuilmes.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d); // el radio de ZonaQuilmes
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeMuestra)).thenReturn(4d);
		
		//Excersice
		this.zonaQuilmes.subscribirObserver(this.organizacionObserver);
		this.zonaQuilmes.agregarMuestra(this.muestra);
		
		verify(this.organizacionObserver, times(1)).nuevaMuestraCargada(this.zonaQuilmes, this.muestra);
	}
	
	@Test
	void verificacionCuandoUnaZonaDeCoberturaNotificaUnaValidacionDeUnaMuestraASusListeners() {
		//Mockeando la ubicacion de la muestra
		when(ubicacionDeMuestra.getLatitud()).thenReturn(1d);
		when(ubicacionDeMuestra.getLongitud()).thenReturn(3d);
		
		//Mockeando la muestra
		when(muestra.getUbicacion()).thenReturn(ubicacionDeMuestra);
		
		//Mockeando las ubicaciones de zonaQuilmes.
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeBordeQuilmes)).thenReturn(7d); // el radio de ZonaQuilmes
		when(ubicacionDeEpicentroQuilmes.distanciaCon(ubicacionDeMuestra)).thenReturn(4d);
		
		//Excersice
		this.zonaQuilmes.subscribirObserver(this.organizacionObserver);
		this.zonaQuilmes.agregarMuestra(this.muestra);
		
		verify(this.organizacionObserver, times(1)).nuevaMuestraCargada(this.zonaQuilmes, this.muestra);
		verify(this.organizacionObserver, times(1)).nuevaValidacionDeMuestra(this.zonaQuilmes, this.muestra);
	}

}