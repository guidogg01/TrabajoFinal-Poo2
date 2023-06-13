package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.Pagina;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;

class ParticipanteTestCase {
	
	private Participante participante;
	
	private Pagina pagina;
	
	private NivelBasico nivelBasico;
	
	private Ubicacion ubicacion;
	
	private Opinion opinion;
	
	private Muestra muestra;
	private Muestra muestra2;
	private Muestra muestra3;
	
	@BeforeEach
	void setUp() {
		
		pagina = mock(Pagina.class);
		
		participante = new Participante(12345, this.pagina);
		
		nivelBasico = new NivelBasico(participante); // No se realiza con mockito debido a que no se podía testear las funcionalidades necesarias.
		
		ubicacion = mock(Ubicacion.class);
		
		opinion  = mock(Opinion.class);
		
		muestra  = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnParticipante() {
		
		assertEquals(12345, this.participante.getID());
		assertEquals(this.pagina, this.participante.getPagina());
		assertTrue(this.participante.getMuestras().isEmpty());
		assertTrue(this.participante.getOpiniones().isEmpty());
		assertEquals(this.nivelBasico.getClass(), this.participante.getNivelDeConocimiento().getClass());
		assertFalse(this.participante.isTieneVerificacionExterna());
		
	}
	
	@Test
	void verificacionCuandoSeCreaUnParticipanteEsNivelBasico() {
		assertFalse(this.participante.esExperto());
		
	}
	
	@Test
	void verificacionDeOtorgacionDeVerificacionExternaAUnParticipante() {
		//Exercise
		this.participante.otorgarVerificacionExterna();
		
		assertTrue(this.participante.tieneVerificacionExterna());
	}
	
	@Test
	void verificacionCuandoUnParticipanteEnviaUnaMuestra() {
		//Exercise
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCAGUASAYANA, this.ubicacion, LocalDate.of(2023, 6, 12));
		
		//Verify
		assertEquals(1, this.participante.getMuestras().size());
		verify(pagina, times(1)).agregarMuestra(Mockito.any());
		
	}
	
	@Test
	void verificacionCuandoUnParticipanteAgregaUnaMuestra() {
		//Exercise
		this.participante.agregarOpinion(this.opinion);
		
		assertEquals(1, this.participante.getOpiniones().size());
		assertTrue(this.participante.getOpiniones().contains(this.opinion));
	}
	
	@Test
	void verificacionDeObtencionDeUnNivelDeConocimientoDeUnParticipante() {
		assertEquals("Soy un participante de nivel basico.", this.participante.obtenerNivelDeConocimiento());
	}
	
	@Test
	void verficiacionDeCuantasMuestrasRealizoElParticipanteEnLosUltimos30Dias() {
		//setUp
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCAGUASAYANA, ubicacion, LocalDate.of(2023, 6, 12));
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCASORDIDA, ubicacion, LocalDate.of(2023, 5, 22));
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCAINFESTANS, ubicacion, LocalDate.of(2021, 6, 12));
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCASORDIDA, ubicacion, LocalDate.of(2023, 6, 2));
		
		assertTrue(this.participante.realizoMuestrasEnElUltimoMes(1));		
	}
	
	@Test
	void verficiacionDeCuantasOpinionesRealizoElParticipanteEnLosUltimos30Dias() {
		//setUp
		this.participante.opinarSobre(this.muestra, TipoDeOpinion.CHINCHEFOLIADA, LocalDate.of(2023, 6, 12));
		this.participante.opinarSobre(this.muestra2, TipoDeOpinion.PHTIACHINCHE, LocalDate.of(2021, 6, 12));
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCAINFESTANS, ubicacion, LocalDate.of(2023, 6, 12));
		this.participante.opinarSobre(this.muestra3, TipoDeOpinion.PHTIACHINCHE, LocalDate.of(2023, 6, 12));
		
		assertTrue(this.participante.realizoOpinionesEnElUltimoMes(2)); 
	}
	
	@Test
	void verificacionCuandoUnaMuestraEsDeUnParticipante() {
		//SetUp
		this.participante.agregarMuestra(this.muestra);
		this.participante.agregarMuestra(this.muestra2);
		
		assertTrue(this.participante.esMiMuestra(this.muestra2));
	}
	
	@Test
	void verificacionCuandoUnaMuestraNoEsDeUnParticipante() {
		//SetUp
		this.participante.agregarMuestra(this.muestra);
		this.participante.agregarMuestra(this.muestra2);
		
		assertFalse(this.participante.esMiMuestra(this.muestra3));
	}

	@Test
	void verificacionCuandoUnParticipanteYaOpinoSobreUnaMuestra() {
		//Mockeando la muestra
		when(muestra.elParticipanteYaOpino(participante)).thenReturn(true);
		
		assertTrue(this.participante.opineSobre(this.muestra));
	}
	
	@Test
	void verificacionCuandoUnParticipanteNoOpinoSobreUnaMuestra() {
		//Mockeando la muestra
		when(muestra.elParticipanteYaOpino(participante)).thenReturn(false);
		
		assertFalse(this.participante.opineSobre(this.muestra));
	}

}
