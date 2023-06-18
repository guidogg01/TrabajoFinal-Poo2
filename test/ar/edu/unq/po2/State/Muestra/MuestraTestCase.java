package ar.edu.unq.po2.State.Muestra;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Participante.Participante;

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
	
	private EstadoVotadaBasicos  estadoVotadaBasicos;
	private EstadoVotadaExpertos estadoVotadaExpertos;
	
	
	@BeforeEach
	void setUp(){
		
		participante1 = mock(Participante.class);
		participante2 = mock(Participante.class);
		
		ubicacion1    = mock(Ubicacion.class);
		ubicacion2    = mock(Ubicacion.class);

		opinion       = mock(Opinion.class);
		opinion2      = mock(Opinion.class);
		opinion3      = mock(Opinion.class);
		
		estadoVotadaBasicos   = new EstadoVotadaBasicos(muestra1); // no se realiza con mockito debido a que no se podía testear las funcionalidades necesarias.
		estadoVotadaExpertos  = new EstadoVotadaExpertos(muestra2); // no se realiza con mockito debido a que no se podía testear las funcionalidades necesarias.
		
		//Mockeando los participantes
		// Se mockea el id del participante debido a que aquí es en donde se inicializa la muestra y donde se le pide el id al participante.
		when(participante2.getID()).thenReturn(10);
		when(participante2.esExperto()).thenReturn(false);
		when(participante1.getID()).thenReturn(5);
		when(participante1.esExperto()).thenReturn(true);
		
		muestra1   = new Muestra(TipoDeOpinion.VINCHUCASORDIDA,   participante2, ubicacion1, LocalDate.now());
		muestra2   = new Muestra(TipoDeOpinion.VINCHUCAGUASAYANA, participante1, ubicacion2, LocalDate.now());
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaMuestraRealizadaPorParticipanteBasico() {
		//SetUp
		TipoDeOpinion tipoDeVinchucaFotografiadaEsperado = TipoDeOpinion.VINCHUCASORDIDA;
		String fotoEsperada = "Soy una vinchuca Sordida";
		int    idDeParticipanteEsperado = 10;
		Double latitudEsperadaDeLaUbicacion = 4d;
		
		//Mockeando la ubicacion
		when(ubicacion1.getLatitud()).thenReturn(4d);
		
		assertEquals(tipoDeVinchucaFotografiadaEsperado, this.muestra1.getTipoDeVinchucaFotografiada());
		assertEquals(fotoEsperada, this.muestra1.getFoto());
		assertEquals(this.participante2, this.muestra1.getParticipante());
		assertEquals(idDeParticipanteEsperado, this.muestra1.getIdDeParticipante());
		assertEquals(latitudEsperadaDeLaUbicacion, this.muestra1.getUbicacion().getLatitud());
		assertEquals(LocalDate.now(), this.muestra1.getFechaDeCreacion());
		assertTrue(this.muestra1.getOpiniones().isEmpty());
		assertEquals(this.estadoVotadaBasicos.getClass(), this.muestra1.getEstadoActual().getClass());
	}
	
	@Test
	void verificacionDeInicializacionDeUnaMuestraRealizadaPorParticipanteExperto() {
		//SetUp
		TipoDeOpinion tipoDeVinchucaFotografiadaEsperado = TipoDeOpinion.VINCHUCAGUASAYANA;
		String fotoEsperada = "Soy una vinchuca Guasayana";
		int    idDeParticipanteEsperado = 5;
		Double latitudEsperadaDeLaUbicacion = 2d;
		
		//Mockeando la ubicacion
		when(ubicacion2.getLatitud()).thenReturn(2d);
		
		assertEquals(tipoDeVinchucaFotografiadaEsperado, this.muestra2.getTipoDeVinchucaFotografiada());
		assertEquals(fotoEsperada, this.muestra2.getFoto());
		assertEquals(this.participante1, this.muestra2.getParticipante());
		assertEquals(idDeParticipanteEsperado, this.muestra2.getIdDeParticipante());
		assertEquals(latitudEsperadaDeLaUbicacion, this.muestra2.getUbicacion().getLatitud());
		assertEquals(LocalDate.now(), this.muestra2.getFechaDeCreacion());
		assertTrue(this.muestra2.getOpiniones().isEmpty());
		assertEquals(this.estadoVotadaExpertos.getClass(), this.muestra2.getEstadoActual().getClass());
	}
	
	@Test
	void verificacionCuandoUnTipoDeVinchucaFotografiadaNoEsElEsperado() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Muestra(TipoDeOpinion.PHTIACHINCHE, participante1, ubicacion2, LocalDate.now()); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoSeRealizaUnAddOpinionAUnaMuestra() {
		//Exersice
		this.muestra1.addOpinion(this.opinion);
		
		assertFalse(this.muestra1.getOpiniones().isEmpty());
	}
	
	@Test
	void verificacionDeDistanciaDeDosMuestras() {
		//Setup
		Double distanciaEsperada = 4d;
		
		//Mockeando la ubicacion de las muestras
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
	void verificacionCuandoSeCreaUnaMuestraPorUnParticipanteBasicoSuNivelDeVerificacionCorrespondeAlNivelDelMismo() {
		assertEquals(ENivelDeVerificacion.VOTADABASICOS, this.muestra1.obtenerNivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoSeCreaUnaMuestraPorUnParticipanteExpertcoSuNivelDeVerificacionCorrespondeAlNivelDelMismo() {
		assertEquals(ENivelDeVerificacion.VOTADAEXPERTOS, this.muestra2.obtenerNivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoElEstadoDeUnaMuestraEsVerificada() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.muestra1.obtenerNivelDeVerificacion());
	}
	
	@Test
	void verificacionCuandoEnUnaMuestraCoincidieronExpertos() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
				
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
				
		assertTrue(this.muestra1.coincidieronExpertos());
	}
	
	@Test
	void verificacionCuandoEnUnaMuestraNoCoincidieronExpertos() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
				
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
				
		assertFalse(this.muestra1.coincidieronExpertos());
	}
	
	@Test
	void verificacionDelResultadoActualCuandoSeCreaUnaMuestraEsSuTipoDeOpinion() {		
		assertEquals(TipoDeOpinion.VINCHUCASORDIDA, this.muestra1.resultadoActual());
	}
	
	@Test
	void verificacionDelResultadoActualDeUnaMuestraDeSoloParticipantesBasicos() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(false);
		when(opinion3.esOpinadaPorExperto()).thenReturn(false);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		assertEquals(TipoDeOpinion.PHTIACHINCHE, this.muestra1.resultadoActual());
		
	}
	
	@Test
	void verificacionDelResultadoActualDeUnaMuestraDeSoloParticipantesExpertos() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.NINGUNA);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAGUASAYANA);
		
		//SetUp
		this.muestra2.agregarOpinion(opinion);
		this.muestra2.agregarOpinion(opinion2);
		this.muestra2.agregarOpinion(opinion3);
		
		assertEquals(TipoDeOpinion.VINCHUCAGUASAYANA, this.muestra2.resultadoActual());
		
	}
	
	@Test
	void verificacionDelResultadoActualNoDefinidoDeUnaMuestra() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(true);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		this.muestra1.agregarOpinion(opinion3);
		
		assertEquals(TipoDeOpinion.NODEFINIDO, this.muestra1.resultadoActual());
		
	}
	
	@Test
	void verificacionCuandoOpinanParticipantesExpertosLasOpinionesDeLosParticipantesBasicosNoSeAgregan() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		when(opinion3.esOpinadaPorExperto()).thenReturn(false);
		
		when(opinion.getTipoDeOpinion()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		when(opinion3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIACHINCHE);

		when(participante2.esExperto()).thenReturn(true);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			this.muestra1.agregarOpinion(opinion3); //Esto funciona pero está afuera del coverage
		});
		
	}
	
	@Test
	void vericifacionSiUnaMuestraEsVotadaPorExpertos() {
		//Mockeando las opiniones
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		when(opinion2.esOpinadaPorExperto()).thenReturn(true);
		
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		this.muestra1.agregarOpinion(opinion2);
		
		assertTrue(this.muestra1.esVotadaPorExpertos());
	}
	
	@Test
	void verificacionCuandoUnParticipanteYaOpinoSobreUnaMuestra() {
		//SetUp
		this.muestra1.agregarOpinion(opinion);
		
		//Mockeando la opinion
		when(opinion.fueCreadaPor(participante1)).thenReturn(true);
		
		assertTrue(this.muestra1.elParticipanteYaOpino(this.participante1));
	}
	
}