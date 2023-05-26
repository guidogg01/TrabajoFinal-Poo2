package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTestCase {

	private Muestra   muestra1;
	private Muestra   muestra2;
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	
	private Opinion   opinion;
	
	
	@BeforeEach
	void setUp(){
		
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);

		opinion   = mock(Opinion.class);
		
		muestra1   = new Muestra(Vinchuca.SORDIDA,   10, ubicacion1);
		muestra2   = new Muestra(Vinchuca.GUASAYANA, 5 , ubicacion2);
	}
	
	@Test
	void verificacionDeInicializacionDeUnaMuestra() {
		//Mockeando la ubicacion
		when(ubicacion1.getLatitud()).thenReturn(4d);
	
		Vinchuca tipoDeVinchucaFotografiadaEsperado = Vinchuca.SORDIDA;
		String fotoEsperada = "Soy una vinchuca Sordida";
		int idDeParticipanteEsperado = 10;
		Double latitudEsperadaDeLaUbicacion = 4d;
		
		assertEquals(tipoDeVinchucaFotografiadaEsperado, this.muestra1.getTipoDeVinchucaFotografiada());
		assertEquals(fotoEsperada, this.muestra1.getFoto());
		assertEquals(idDeParticipanteEsperado,this.muestra1.getIdDeParticipante());
		assertEquals(latitudEsperadaDeLaUbicacion, this.muestra1.getUbicacion().getLatitud());
		assertTrue(this.muestra1.getOpiniones().isEmpty());
	}
	
	@Test
	void verificacionCuandoSeAgregaUnaNuevaOpinionAUnaMuestra() {
		//Excersice
		this.muestra1.agregarOpinion(this.opinion);
		
		assertFalse(this.muestra1.getOpiniones().isEmpty());
	}
	
	@Test
	void verificacionDeDistanciaDeDosMuestras() {
		//setUp
		Double distanciaEsperada = 4d;
		
		//Moceando la ubicacion de las muestras
		when(ubicacion1.distanciaCon(ubicacion2)).thenReturn(4d);
		
		assertEquals(distanciaEsperada, this.muestra1.distanciaConMuestra(this.muestra2));		
	}

}










