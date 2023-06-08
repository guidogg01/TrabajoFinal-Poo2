package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionTestCase {
	
	private Opinion opinion;
	private Opinion opinion2;
	
	private Participante participante;
	private Participante participante2;

	@BeforeEach
	void setUp() {
		
		participante = mock(Participante.class);

		opinion  = new Opinion(TipoDeOpinion.CHINCHEFOLIADA, participante, LocalDate.of(2020, 4, 15));
		opinion2 = new Opinion(TipoDeOpinion.CHINCHEFOLIADA, participante2, LocalDate.of(2020, 6, 12));
		
	}

	@Test
	void verificacionDeInizialicionDeUnaOpinion() {
		
		assertEquals(TipoDeOpinion.CHINCHEFOLIADA, this.opinion.getTipoDeOpinion());
		assertEquals(participante, this.opinion.getOpinador());
		assertEquals(LocalDate.of(2020, 4, 15), this.opinion.getFechaDeCreacion());
		
	}
	
	@Test
	void verificacionCuandoUnaOpinionEsOpinadaPorExperto() {
		// Mockeando el participante
		when(participante.esExperto()).thenReturn(true);
		
		assertTrue(opinion.esOpinadaPorExperto());
	}
	
	@Test
	void verificacionCuandoUnaOpinionTieneElMismoTipoDeOpinionQueOtraOpinion() {
		
		assertTrue(opinion.tieneMismoTipoDeOpinionQue(opinion2));
		
	}

}