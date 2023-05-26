package ar.edu.unq.po2.Observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Observer.ONG;

class ONGTestCase {
	
	@Test
	void verificacionDeInicializacionDeUnaONGDeTipoAsistencia() {
		
		ONG organizacionNoGubernamental = ONG.ASISTENCIA;
		ONG tipoDeOrganizacionEsperada  = ONG.ASISTENCIA;
		
		assertEquals(tipoDeOrganizacionEsperada, organizacionNoGubernamental);
	}

	@Test
	void verificacionDeInicializacionDeUnaONGDeTipoSalud() {
		
		ONG organizacionNoGubernamental = ONG.SALUD;
		ONG tipoDeOrganizacionEsperada  = ONG.SALUD;
		
		assertEquals(tipoDeOrganizacionEsperada, organizacionNoGubernamental);
	}
	
	@Test
	void verificacionDeInicializacionDeUnaONGDeTipoCultural() {
		
		ONG organizacionNoGubernamental = ONG.CULTURAL;
		ONG tipoDeOrganizacionEsperada  = ONG.CULTURAL;
		
		assertEquals(tipoDeOrganizacionEsperada, organizacionNoGubernamental);
	}
	
	@Test
	void verificacionDeInicializacionDeUnaONGDeTipoEducativa() {
		
		ONG organizacionNoGubernamental = ONG.EDUCATIVA;
		ONG tipoDeOrganizacionEsperada  = ONG.EDUCATIVA;
		
		assertEquals(tipoDeOrganizacionEsperada, organizacionNoGubernamental);
	}

}
