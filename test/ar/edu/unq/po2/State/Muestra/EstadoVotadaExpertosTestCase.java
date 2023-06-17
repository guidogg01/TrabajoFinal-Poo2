package ar.edu.unq.po2.State.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

class EstadoVotadaExpertosTestCase {
	
	private EstadoVotadaExpertos estado;

private Muestra muestra;
	
	private Opinion opinion;
	
	@BeforeEach
	void setUp() {
		
		muestra = mock(Muestra.class);
		
		opinion = mock(Opinion.class);
		
		estado  = new EstadoVotadaExpertos(muestra);
		
	}

	@Test
	void verificacionDeInicializacionDeUnEstadoVotadaExpertos() {
		assertEquals(muestra, this.estado.getMiMuestra());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraNoEsDeEstadoVotadaExpertos() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(true);
		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.estado.nivelDeVerificacion());
		verify(muestra, times(1)).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraEsDeEstadoVotadaExpertos() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(false);
		
		assertEquals(ENivelDeVerificacion.VOTADAEXPERTOS, this.estado.nivelDeVerificacion());
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnEstadoVotadaExpertosAgregaUnaOpinionDeUnParticipanteBasico() {
		//Mockeando la opinion
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.estado.agregarOpinion(opinion); //Esto funciona pero está afuera del coverage
		});
		
		//Verify
		verify(muestra, never()).addOpinion(opinion);
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnEstadoVotadaExpertosAgregaUnaOpinionDeUnParticipanteExpertoYCoicideConLaOpinionDeOtroParticipanteExperto() {
		//Mockeando la opinion
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		
		//Mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(true);
		
		//Exercise
		this.estado.agregarOpinion(opinion);
		
		//Verify
		verify(muestra, times(1)).addOpinion(opinion);
		verify(muestra, times(1)).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnEstadoVotadaExpertosAgregaUnaOpinionDeUnParticipanteExpertoYNoCoicideConLaOpinionDeOtroParticipanteExperto() {
		//Mockeando la opinion
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		
		//Mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(false);
		
		//Exercise
		this.estado.agregarOpinion(opinion);
		
		//Verify
		verify(muestra, times(1)).addOpinion(opinion);
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionDeResultadoActualDeUnEstadoVotadaExpertos() {
		//Mockeando la muestra
		when(muestra.votoPorParticipantesExpertos()).thenReturn(TipoDeOpinion.VINCHUCAGUASAYANA);
		
		assertEquals(TipoDeOpinion.VINCHUCAGUASAYANA, this.estado.resultadoActual());
	}
}
