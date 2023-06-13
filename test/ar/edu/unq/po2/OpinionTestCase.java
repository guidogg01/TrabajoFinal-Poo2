package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.State.Participante.Participante;

class OpinionTestCase {
	
	private Opinion opinion;
	
	private Participante participante;
	private Participante participante2;

	@BeforeEach
	void setUp() {
		
		participante = mock(Participante.class);

		opinion  = new Opinion(TipoDeOpinion.CHINCHEFOLIADA, participante, LocalDate.of(2020, 4, 15));
		
	}

	@Test
	void verificacionDeInizialicionDeUnaOpinion() {
		
		assertEquals(TipoDeOpinion.CHINCHEFOLIADA, this.opinion.getTipoDeOpinion());
		assertEquals(participante, this.opinion.getOpinador());
		assertEquals(LocalDate.of(2020, 4, 15), this.opinion.getFechaDeCreacion());
		
	}
	
	@Test
	void verificacionCuandoUnTipoDeOpinionNoEsElEsperado() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Opinion(TipoDeOpinion.NODEFINIDO, participante, LocalDate.now()); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnaOpinionEsOpinadaPorExperto() {
		// Mockeando el participante
		when(participante.esExperto()).thenReturn(true);
		
		assertTrue(opinion.esOpinadaPorExperto());
	}
	
	@Test
	void verificacionCuandoUnaOpinionNoEsOpinadaPorExperto() {
		// Mockeando el participante
		when(participante.esExperto()).thenReturn(false);
		
		assertFalse(opinion.esOpinadaPorExperto());
	}
	
	@Test
	void verificacionCuandoUnaOpinionFueCreadaPorElParticipante() {
		assertTrue(this.opinion.fueCreadaPor(this.participante));
	}
	
	@Test
	void verificacionCuandoUnaOpinionNoFueCreadaPorElParticipante() {
		assertFalse(this.opinion.fueCreadaPor(this.participante2));
	}

}