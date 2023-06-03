package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Observer.ONG;

class TipoDeOpinionTestCase {

	@Test
	void verificacionDeInicializacionDeUnTipoDeOpinionDeUnaVinchucaSordida() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.VINCHUCASORDIDA;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.VINCHUCASORDIDA;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}

	@Test
	void verificacionDeInicializacionDeUnTipoDeOpinionDeUnaVinchucaInfestans() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.VINCHUCAINFESTANS;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.VINCHUCAINFESTANS;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnTipoDeOpinionDeUnaVinchucaGuasayana() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.VINCHUCAGUASAYANA;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.VINCHUCAGUASAYANA;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnTipoDeOpinionDeUnaChincheFoliada() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.CHINCHEFOLIADA;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.CHINCHEFOLIADA;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}
	
	@Test
	void verificacionDeInicializacionDeUnTipoDeOpinionDeUnaPhtiaCinche() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.PHTIACHINCHE;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.PHTIACHINCHE;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}
	
	@Test
	void verificacionDeInicializacionDeNingunTipoDeOpinion() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.NINGUNA;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.NINGUNA;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}
	
	@Test
	void verificacionDeInicializacionDeNingunTipoDeOpinionDeUnaImagenPocoClara() {
		
		TipoDeOpinion tipoDeOpinion = TipoDeOpinion.IMAGENPOCOCLARA;
		TipoDeOpinion tipoDeOpinionEsperada = TipoDeOpinion.IMAGENPOCOCLARA;
		
		assertEquals(tipoDeOpinionEsperada, tipoDeOpinion);
	}

}
