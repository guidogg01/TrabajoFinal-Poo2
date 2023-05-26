package ar.edu.unq.po2.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.Observer.ONG;
import ar.edu.unq.po2.Observer.Organizacion;
import ar.edu.unq.po2.Observer.ZonaDeCobertura;

class OrganizacionTestCase {

	private Organizacion organizacion;
	
	private Ubicacion ubicacion;
	private ZonaDeCobertura zonaDeCobertura;
	
	@BeforeEach
	void setUp() {
		
		ubicacion       = mock(Ubicacion.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		
		organizacion    = new Organizacion(ONG.ASISTENCIA, 10, ubicacion, zonaDeCobertura);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaOrganizacion() {
		//Mockeando la ubicación.
		when(ubicacion.getLatitud()).thenReturn(4d);
		
		//Setup
		ONG tipoDeOrganizacionEsperada = ONG.ASISTENCIA;
		int cantEsperadaDeTrabajadores = 10;
		int latitudEsperada = 4;
		ZonaDeCobertura zonaDeCoberturaEsperada = this.zonaDeCobertura; 
		
		assertEquals(tipoDeOrganizacionEsperada, this.organizacion.getTipoDeONG());
		assertEquals(cantEsperadaDeTrabajadores, this.organizacion.getCantidadDeTrabajadores());
		assertEquals(latitudEsperada, this.organizacion.getUbicacion().getLatitud());
		assertEquals(zonaDeCoberturaEsperada, this.organizacion.getMiZonaDeCobertura());
		
		verify(this.zonaDeCobertura, times(1)).subscribirObserver(this.organizacion);
	}

}