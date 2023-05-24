package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTestCase {

	private Organizacion organizacion;
	
	private Ubicacion ubicacion;
	
	@BeforeEach
	void setUp() {
		
		ubicacion = mock(Ubicacion.class);
		
		organizacion = new Organizacion(ONG.ASISTENCIA, 10, ubicacion);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaOrganizacion() {
		
		//Mockeando la ubicación.
		when(ubicacion.getLatitud()).thenReturn(4d);
		
		ONG tipoDeOrganizacionEsperada = ONG.ASISTENCIA;
		int cantEsperadaDeTrabajadores = 10;
		int latitudEsperada = 4;
		
		assertEquals(tipoDeOrganizacionEsperada, this.organizacion.getTipoDeONG());
		assertEquals(cantEsperadaDeTrabajadores, this.organizacion.getCantidadDeTrabajadores());
		assertEquals(latitudEsperada, this.organizacion.getUbicacion().getLatitud());
	}
	
}