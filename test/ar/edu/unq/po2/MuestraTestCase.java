package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.StateMuestra.EstadoVotada;

import java.time.LocalDate;

class MuestraTestCase {

	private Muestra   	 muestra1;
	private Muestra   	 muestra2;
	
	private Participante participante1;
	private Participante participante2;
	
	private Ubicacion 	 ubicacion1;
	private Ubicacion 	 ubicacion2;
	
	private Opinion   	 opinion;
	private Opinion   	 opinion2;
	private Opinion   	 opinion3;
	
	private EstadoVotada estadoVotada;
	
	
	@BeforeEach
	void setUp(){
		
		participante1 = mock(Participante.class);
		participante2 = mock(Participante.class);
		
		ubicacion1    = mock(Ubicacion.class);
		ubicacion2    = mock(Ubicacion.class);

		opinion       = mock(Opinion.class);
		opinion2      = mock(Opinion.class);
		opinion3      = mock(Opinion.class);
		
		estadoVotada  = new EstadoVotada(muestra1); // no se realiza con mockito debido a que no se podía testear las funcionalidades necesarias.
		
		muestra1   = new Muestra(TipoDeOpinion.VINCHUCASORDIDA,   participante2, ubicacion1, LocalDate.now());
		muestra2   = new Muestra(TipoDeOpinion.VINCHUCAGUASAYANA, participante1, ubicacion2, LocalDate.now());
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaMuestra() {
		//SetUp
		TipoDeOpinion tipoDeVinchucaFotografiadaEsperado = TipoDeOpinion.VINCHUCASORDIDA;
		String fotoEsperada = "Soy una vinchuca Sordida";
		int    idDeParticipanteEsperado = 10;
		Double latitudEsperadaDeLaUbicacion = 4d;
		
		//Mockeando el participante
		when(participante2.getID()).thenReturn(10);
		
		//Mockeando la ubicacion
		when(ubicacion1.getLatitud()).thenReturn(4d);
		
		assertEquals(tipoDeVinchucaFotografiadaEsperado, this.muestra1.getTipoDeVinchucaFotografiada());
		assertEquals(fotoEsperada, this.muestra1.getFoto());
		assertEquals(this.participante2, this.muestra1.getParticipante());
		assertEquals(idDeParticipanteEsperado, this.muestra1.getParticipante().getID()); // SE HACE DE ESTA MANERA PORQUE SE MOCKEAN DOS COSAS DIFERENTES... REVISAR!!!
		assertEquals(latitudEsperadaDeLaUbicacion, this.muestra1.getUbicacion().getLatitud());
		assertEquals(LocalDate.now(), this.muestra1.getFechaDeCreacion());
		assertTrue(this.muestra1.getOpiniones().isEmpty());
		assertEquals(this.estadoVotada.getClass(), this.muestra1.getEstadoActual().getClass());
	}
	
	@Test
	void verificacionCuandoUnTipoDeVinchucaFotografiadaNoEsElEsperado() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Muestra(TipoDeOpinion.PHTIACHINCHE, participante1, ubicacion2, LocalDate.now()); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoSeAgregaUnaNuevaOpinionAUnaMuestra() {
		//Excersice
		this.muestra1.agregarOpinion(this.opinion);
		
		assertFalse(this.muestra1.getOpiniones().isEmpty());
	}
	
	@Test
	void verificacionDeDistanciaDeDosMuestras() {
		//Setup
		Double distanciaEsperada = 4d;
		
		//Moceando la ubicacion de las muestras
		when(ubicacion1.distanciaCon(ubicacion2)).thenReturn(4d);
		
		assertEquals(distanciaEsperada, this.muestra1.distanciaConMuestra(this.muestra2));		
	}
	
	@Test
	void verificacionDeFechaDeLaUltimaVotacionQueRecibioUnaMuestra() {
		//Mockeando la opinion.
		when(this.opinion.getFechaDeCreacion()).thenReturn(LocalDate.of(2023, 12, 29));
		
		//Setup
		this.muestra1.agregarOpinion(this.opinion);
		LocalDate fechaEsperada = LocalDate.of(2023, 12, 29);
		
		assertEquals(fechaEsperada, this.muestra1.fechaDeUltimaVotacion());
		verify(this.opinion, times(1)).getFechaDeCreacion();
	}
	
	@Test
	void verificacionCuandoSeCreaUnaMuestraSuEstadoEsVotada() {
		assertEquals(ENivelDeVerificacion.VOTADA, this.muestra1.obtenerNivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoElEstadoDeUnaMuestraEsVerificada() {
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		when(opinion2.esOpinadaPorExperto()).thenReturn(false);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		//Mockeando el participante
		when(participante1.esExperto()).thenReturn(false);
		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.muestra1.obtenerNivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoEnUnaMuestraCoincidieronExpertos() {
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		when(opinion2.esOpinadaPorExperto()).thenReturn(false);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		assertTrue(this.muestra1.coincidieronExpertos());
	}
	
	@Test
	void verificacionDelResultadoActualCuandoSeCreaUnaMuestraEsSuTipoDeOpinion() {
		//Mockeando al participante
		when(participante2.esExperto()).thenReturn(false);
		
		assertEquals(TipoDeOpinion.VINCHUCASORDIDA, this.muestra1.resultadoActual());
	}
	
	@Test
	void verificacionDelResultadoActualDeUnaMuestraDeSoloParticipantesBasicos() {
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(false);
		when(opinion3.esOpinadaPorExperto()).thenReturn(false);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		//Mockeando al participante
		when(participante2.esExperto()).thenReturn(false);
		
		assertEquals(TipoDeOpinion.PHTIACHINCHE, this.muestra1.resultadoActual());
		
	}
	
	@Test
	void verificacionDelResultadoActualDeUnaMuestraDeSoloParticipantesExpertos() {
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		when(participante2.esExperto()).thenReturn(true);
		
		assertEquals(TipoDeOpinion.PHTIACHINCHE, this.muestra1.resultadoActual());
		
	}
	
}