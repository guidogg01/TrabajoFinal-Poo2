package ar.edu.unq.po2.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.Observer.ONG;
import ar.edu.unq.po2.Observer.Organizacion;
import ar.edu.unq.po2.Observer.ZonaDeCobertura;

class OrganizacionTestCase {

	private Organizacion organizacion;
	
	private Ubicacion ubicacion;
	private ZonaDeCobertura zonaDeCobertura;
	private FuncionalidadExterna funcionalidadExterna;
	
	private Muestra muestra;
	
	@BeforeEach
	void setUp() {
		
		ubicacion            = mock(Ubicacion.class);
		zonaDeCobertura      = mock(ZonaDeCobertura.class);
		funcionalidadExterna = mock(FuncionalidadExterna.class);
		
		organizacion    = new Organizacion(ONG.ASISTENCIA, 10, ubicacion, zonaDeCobertura, funcionalidadExterna);
		
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
		FuncionalidadExterna funcionalidadExternaEsperada = this.funcionalidadExterna;
		
		assertEquals(tipoDeOrganizacionEsperada, this.organizacion.getTipoDeONG());
		assertEquals(cantEsperadaDeTrabajadores, this.organizacion.getCantidadDeTrabajadores());
		assertEquals(latitudEsperada, this.organizacion.getUbicacion().getLatitud());
		assertEquals(zonaDeCoberturaEsperada, this.organizacion.getMiZonaDeCobertura());
		assertEquals(funcionalidadExternaEsperada, this.organizacion.getFuncionalidadExterna());
		
		verify(this.zonaDeCobertura, times(1)).subscribirObserver(this.organizacion);
	}
	
	@Test
	void verificacionCuandoSeRecibeUnaNotificacionDeNuevaMuestraCargada() {
		//Excersice
		this.organizacion.nuevaMuestraCargada(this.zonaDeCobertura, this.muestra);
		
		verify(this.funcionalidadExterna, times(1)).nuevoEvento(this.organizacion, this.zonaDeCobertura, this.muestra);
	}

	@Test
	void verificacionCuandoSeRecibeUnaNotificacionDeUnaNuevaValidacionDeMuestra() {
		//Excersice
		this.organizacion.nuevaValidacionDeMuestra(zonaDeCobertura, muestra);
		
		verify(this.funcionalidadExterna, times(1)).nuevoEvento(this.organizacion, this.zonaDeCobertura, this.muestra);
	}
	
}