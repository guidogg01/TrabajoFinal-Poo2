package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpinionTestCase {
	
	private Opinion opinion;
	
	private Participante participante;

	@BeforeEach
	void setUp() {
		
		participante = mock(Participante.class);

		opinion = new Opinion(TipoDeOpinion.CHINCHEFOLIADA, participante, LocalDate.of(2020, 4, 15));
		
	}

	@Test
	void verificacionDeInizialicionDeUnaOpinion() {
		
		assertEquals(TipoDeOpinion.CHINCHEFOLIADA, this.opinion.getTipoDeOpinion());
		assertEquals(participante, this.opinion.getOpinador());
		assertEquals(LocalDate.of(2020, 4, 15), this.opinion.getFechaDeCreacion());
		
	}

}