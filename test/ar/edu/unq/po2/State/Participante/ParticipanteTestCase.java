package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.Pagina;
import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.Ubicacion;
import ar.edu.unq.po2.State.Participante.NivelBasico;
import ar.edu.unq.po2.State.Participante.Participante;

class ParticipanteTestCase {
	
	private Participante participante;
	
	private Pagina pagina;
	
	private NivelBasico nivelBasico;
	
	private Ubicacion ubicacion;
	
	private Opinion opinion;
	
	@BeforeEach
	void setUp() {
		
		pagina = mock(Pagina.class);
		
		participante = new Participante(12345, this.pagina);
		
		nivelBasico = new NivelBasico(participante); // No se realiza con mockito debido a que no se podía testear las funcionalidades necesarias.
		
		ubicacion = mock(Ubicacion.class);
		
		opinion = mock(Opinion.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnParticipante() {
		
		assertEquals(12345, this.participante.getID());
		assertEquals(this.pagina, this.participante.getPagina());
		assertTrue(this.participante.getMuestras().isEmpty());
		assertTrue(this.participante.getOpiniones().isEmpty());
		assertEquals(this.nivelBasico.getClass(), this.participante.getNivelDeConocimiento().getClass());
		
	}
	
	@Test
	void verificacionCuandoSeCreaUnParticipanteEsNivelBasico() {
		assertFalse(this.participante.esExperto());
		
	}
	
	@Test
	void verificacionCuandoUnParticipanteEnviaUnaMuestra() {
		//Exercise
		this.participante.enviarMuestra(TipoDeOpinion.VINCHUCAGUASAYANA, this.ubicacion);
		
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

}
