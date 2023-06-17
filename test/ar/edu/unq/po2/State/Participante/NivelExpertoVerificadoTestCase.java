package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.State.Muestra.Muestra;

class NivelExpertoVerificadoTestCase {
	
	private NivelExpertoVerificado nivelExpertoVerificado;
	
	private Muestra muestra;

	private Participante participante;
	
	@BeforeEach
	void setUp() {
		
		participante  = mock(Participante.class); 
		
		muestra = mock(Muestra.class);
		
		nivelExpertoVerificado  = new NivelExpertoVerificado(participante);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelExpertoVerificadoDeUnParticipante() {
		assertEquals(this.participante, this.nivelExpertoVerificado.getParticipante());
		
	}
	
	@Test
	void verificacionCuandoSeLePreguntaAUnNivelExpertoVerificadoSiEsExperto() {
		assertTrue(this.nivelExpertoVerificado.esExperto());
		
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeUnNivelExpertoVerificado() {
		assertEquals("Soy un participante de nivel experto verificado.", this.nivelExpertoVerificado.nivelDeConocimiento());
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoVerificadoOpinaSobreUnaMuestra() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		this.nivelExpertoVerificado.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11));
		
		//Verify
		verify(muestra, times(1)).agregarOpinion(Mockito.any());
		verify(participante, times(1)).agregarOpinion(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoVerificadoNoPuedeOpinarSobreUnaMuestraVerificada() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(true);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExpertoVerificado.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	
	@Test
	void verificacionCuandoUnNivelExpertoVerificadoNoPuedeOpinarSobreUnaMuestraVotadaPorExpertos() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(true);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExpertoVerificado.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoVerificadoNoPuedeOpinarSobreUnaMuestraQueEsDelParticipante() { 
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(true);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExpertoVerificado.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
}
