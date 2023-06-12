package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NivelBasicoTestCase {

	private NivelBasico  nivelBasico;
	
	private Participante participante;
	
	@BeforeEach
	void setUp() {
		
		participante = mock(Participante.class); 
		
		nivelBasico  = new NivelBasico(participante);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelBasicoDeUnParticipante() {
		assertEquals(this.participante, this.nivelBasico.getParticipante());
		
	}
	
	@Test
	void verificacionCuandoSeLePreguntaAUnNivelBasicoSiEsExperto() {
		assertFalse(this.nivelBasico.esExperto());
		
	}
	
	

}
