package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.TipoDeOpinion;

class NivelExpertoTestCase {

	private NivelExperto  nivelExperto;
	
	private Muestra muestra;
	
	private Participante participante;
	
	@BeforeEach
	void setUp() {
		
		participante  = mock(Participante.class); 
		
		muestra = mock(Muestra.class);
		
		nivelExperto  = new NivelExperto(participante);
		
	}
	
	@Test
	void verificacionDeInicializacionDeUnNivelExpertoDeUnParticipante() {
		assertEquals(this.participante, this.nivelExperto.getParticipante());
		
	}
	
	@Test
	void verificacionCuandoSeLePreguntaAUnNivelExpertoSiEsExperto() {
		assertTrue(this.nivelExperto.esExperto());
		
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelExperto() {
		//Mockeando al participante
		when(participante.realizoMuestrasEnElUltimoMes(10)).thenReturn(true);
		when(participante.realizoOpinionesEnElUltimoMes(20)).thenReturn(true);
		
		assertEquals("Soy un participante de nivel experto.", this.nivelExperto.nivelDeConocimiento());
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelExpertoANivelBasico() {
		//Mockeando al participante
		when(participante.realizoMuestrasEnElUltimoMes(10)).thenReturn(false);
		when(participante.realizoOpinionesEnElUltimoMes(20)).thenReturn(false);
		
		assertEquals("Soy un participante de nivel basico.", this.nivelExperto.nivelDeConocimiento());
		verify(participante, times(1)).setNivelDeConocimiento(Mockito.any());
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelExpertoANivelExpertoVerificado() {
		//Mockeando al participante
		when(participante.realizoMuestrasEnElUltimoMes(10)).thenReturn(true);
		when(participante.realizoOpinionesEnElUltimoMes(20)).thenReturn(true);
		
		when(participante.tieneVerificacionExterna()).thenReturn(true);
		
		assertEquals("Soy un participante de nivel experto verificado.", this.nivelExperto.nivelDeConocimiento());
		verify(participante, times(1)).setNivelDeConocimiento(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoOpinaSobreUnaMuestra() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		this.nivelExperto.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11));
		
		//Verify
		verify(muestra, times(1)).agregarOpinion(Mockito.any());
		verify(participante, times(1)).agregarOpinion(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoNoPuedeOpinarSobreUnaMuestraVerificada() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(true);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExperto.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	
	@Test
	void verificacionCuandoUnNivelExpertoNoPuedeOpinarSobreUnaMuestraVotadaPorExpertos() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(true);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExperto.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnNivelExpertoNoPuedeOpinarSobreUnaMuestraQueEsDelParticipante() { 
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(true);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelExperto.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
}
