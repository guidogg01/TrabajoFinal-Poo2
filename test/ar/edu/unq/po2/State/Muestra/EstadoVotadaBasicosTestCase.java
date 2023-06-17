package ar.edu.unq.po2.State.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.ENivelDeVerificacion;
import ar.edu.unq.po2.Opinion;
import ar.edu.unq.po2.TipoDeOpinion;

class EstadoVotadaBasicosTestCase {
	
	private EstadoVotadaBasicos estado;
	
	private Muestra muestra;
	
	private Opinion opinion;
	
	@BeforeEach
	void setUp() {
		
		muestra = mock(Muestra.class);
		
		opinion = mock(Opinion.class);
		
		estado  = new EstadoVotadaBasicos(muestra);
		
	}

	@Test
	void verificacionDeInicializacionDeUnEstadoVotadaBasicos() {
		assertEquals(muestra, this.estado.getMiMuestra());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraNoEsDeEstadoVotadaBasicos() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(true);
		
		assertEquals(ENivelDeVerificacion.VERIFICADA, this.estado.nivelDeVerificacion());
		verify(muestra, times(1)).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoElNivelDeVerificacionDeUnaMuestraEsDeEstadoVotadaBasicos() {
		//mockeando la muestra
		when(muestra.coincidieronExpertos()).thenReturn(false);
		
		assertEquals(ENivelDeVerificacion.VOTADABASICOS, this.estado.nivelDeVerificacion());
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnEstadoVotadaBasicosAgregaUnaOpinionDeUnParticipanteBasico() {
		//Mockeando la opinion
		when(opinion.esOpinadaPorExperto()).thenReturn(false);
		
		//Exercise
		this.estado.agregarOpinion(opinion);
		
		//Verify
		verify(muestra, times(1)).addOpinion(opinion);
		verify(muestra, never()).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnEstadoVotadaBasicosAgregaUnaOpinionDeUnParticipanteExperto() {
		//Mockeando la opinion
		when(opinion.esOpinadaPorExperto()).thenReturn(true);
		
		//Exercise
		this.estado.agregarOpinion(opinion);
		
		//Verify
		verify(muestra, times(1)).addOpinion(opinion);
		verify(muestra, times(1)).setEstadoActual(Mockito.any());
	}
	
	@Test
	void verificacionDeResultadoActualDeUnEstadoVotadaBasicos() {
		//Mockeando la muestra
		when(muestra.votoPorParticipantesBasicos()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);
		
		assertEquals(TipoDeOpinion.IMAGENPOCOCLARA, this.estado.resultadoActual());
	}

}
