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
	
	private Ubicacion 	 ubicacion1;
	private Ubicacion 	 ubicacion2;
	
	private Opinion   	 opinion;
	private Opinion   	 opinion2;
	private Opinion   	 opinion3;
	
	private EstadoVotada estadoVotada;
	
	
	@BeforeEach
	void setUp(){
		
		ubicacion1   = mock(Ubicacion.class);
		ubicacion2   = mock(Ubicacion.class);

		opinion      = mock(Opinion.class);
		opinion2     = mock(Opinion.class);
		opinion3     = mock(Opinion.class);
		
		estadoVotada = new EstadoVotada(muestra1);
		
		muestra1   = new Muestra(TipoDeOpinion.VINCHUCASORDIDA,   10, ubicacion1, LocalDate.now());
		muestra2   = new Muestra(TipoDeOpinion.VINCHUCAGUASAYANA, 5 , ubicacion2, LocalDate.now());
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnaMuestra() {
		//Mockeando la ubicacion
		when(ubicacion1.getLatitud()).thenReturn(4d);
	
		TipoDeOpinion tipoDeVinchucaFotografiadaEsperado = TipoDeOpinion.VINCHUCASORDIDA;
		String fotoEsperada = "Soy una vinchuca Sordida";
		int idDeParticipanteEsperado = 10;
		Double latitudEsperadaDeLaUbicacion = 4d;
		
		
		assertEquals(tipoDeVinchucaFotografiadaEsperado, this.muestra1.getTipoDeVinchucaFotografiada());
		assertEquals(fotoEsperada, this.muestra1.getFoto());
		assertEquals(idDeParticipanteEsperado,this.muestra1.getIdDeParticipante());
		assertEquals(latitudEsperadaDeLaUbicacion, this.muestra1.getUbicacion().getLatitud());
		assertEquals(LocalDate.now(), this.muestra1.getFechaDeCreacion());
		assertTrue(this.muestra1.getOpiniones().isEmpty());
		assertEquals(this.estadoVotada.getClass(), this.muestra1.getEstadoActual().getClass());
	}
	
	@Test
	void verificacionCuandoUnTipoDeVinchucaFotografiadaNoEsElEsperado() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Muestra(TipoDeOpinion.PHTIACHINCHE, 2, ubicacion2, LocalDate.now()); //Esto funciona pero está afuera del coverage
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
		
		when(opinion.tieneMismoTipoDeOpinionQue(opinion3)).thenReturn(true);
		
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
		
		when(opinion.tieneMismoTipoDeOpinionQue(opinion3)).thenReturn(true);
		
		assertTrue(this.muestra1.coincidieronExpertos());
	}
	
	@Test
	void verificacionDelResultadoActualSeCreaUnaMuestraEsSuTipoDeOpinion() {
		assertEquals(TipoDeOpinion.VINCHUCASORDIDA, this.muestra1.resultadoActual());
	}
	
}