package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Observer.ONG;

class VinchucaTestCase {
	
	private Vinchuca vinchuca;
	
	@Test
	void verificacionDeInicializacionDeUnaVinchucaSordida() {
		
		vinchuca = Vinchuca.SORDIDA;
		
		String tipoDeDescripcionDeVinchucaEsperada  = "Soy una vinchuca Sordida";
		
		assertEquals(tipoDeDescripcionDeVinchucaEsperada, this.vinchuca.getDescripcion());
	}
	
	@Test
	void verificacionDeInicializacionDeUnaVinchucaInfestans() {
		
		vinchuca = Vinchuca.INFESTANS;
		
		String tipoDeDescripcionDeVinchucaEsperada  = "Soy una vinchuca Infestans";
		
		assertEquals(tipoDeDescripcionDeVinchucaEsperada, this.vinchuca.getDescripcion());
	}
	
	@Test
	void verificacionDeInicializacionDeUnaVinchucaGuasayana() {
		
		vinchuca = Vinchuca.GUASAYANA;
		
		String tipoDeDescripcionDeVinchucaEsperada  = "Soy una vinchuca Guasayana";
		
		assertEquals(tipoDeDescripcionDeVinchucaEsperada, this.vinchuca.getDescripcion());
	}

}
