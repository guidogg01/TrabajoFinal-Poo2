package ar.edu.unq.po2.State.Participante;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.TipoDeOpinion;

class NivelBasicoTestCase {

	private NivelBasico  nivelBasico;
	
	private Muestra muestra;
	
	private Participante participante;
	
	@BeforeEach
	void setUp() {
		
		participante = mock(Participante.class); 
		
		muestra = mock(Muestra.class);
		
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
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelBasico() {
		//Mockeando al participante
		when(participante.realizoMuestrasEnElUltimoMes(10)).thenReturn(true);
		when(participante.realizoOpinionesEnElUltimoMes(20)).thenReturn(false);
		
		assertEquals("Soy un participante de nivel basico.", this.nivelBasico.nivelDeConocimiento());
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelBasicoAnivelExperto() {
		//Mockeando al participante
		when(participante.realizoMuestrasEnElUltimoMes(10)).thenReturn(true);
		when(participante.realizoOpinionesEnElUltimoMes(20)).thenReturn(true);
		
		assertEquals("Soy un participante de nivel experto.", this.nivelBasico.nivelDeConocimiento());
		verify(participante, times(1)).setNivelDeConocimiento(Mockito.any());
	}
	
	@Test
	void verificacionDeNivelDeConocimientoDeNivelBasicoAnivelExpertoVerificado() {
		//Mockeando al participante
		when(participante.tieneVerificacionExterna()).thenReturn(true);
		
		assertEquals("Soy un participante de nivel experto verificado.", this.nivelBasico.nivelDeConocimiento());
		verify(participante, times(1)).setNivelDeConocimiento(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnNivelBasicoOpinaSobreUnaMuestra() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		when(muestra.esVotadaPorExpertos()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		this.nivelBasico.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11));
		
		//Verify
		verify(muestra, times(1)).agregarOpinion(Mockito.any());
		verify(participante, times(1)).agregarOpinion(Mockito.any());
	}
	
	@Test
	void verificacionCuandoUnNivelBasicoNoPuedeOpinarSobreUnaMuestraVerificada() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(true);
		when(muestra.esVotadaPorExpertos()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelBasico.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnNivelBasicoNoPuedeOpinarSobreUnaMuestraVotadaPorExpertos() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		when(muestra.esVotadaPorExpertos()).thenReturn(true);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelBasico.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnNivelBasicoNoPuedeOpinarSobreUnaMuestraQueEsDelParticipante() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		when(muestra.esVotadaPorExpertos()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(true);
		when(participante.opineSobre(muestra)).thenReturn(false);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelBasico.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}
	
	@Test
	void verificacionCuandoUnNivelBasicoNoPuedeOpinarSobreUnaMuestraQueYaFueOpinadaPorElParticipante() {
		//Mockeando la muestra
		when(muestra.esVerificada()).thenReturn(false);
		when(muestra.esVotadaPorExpertos()).thenReturn(false);
		
		//Mockeando el participante
		when(participante.esMiMuestra(muestra)).thenReturn(false);
		when(participante.opineSobre(muestra)).thenReturn(true);
		
		//Exercise
		assertThrows(IllegalArgumentException.class, () -> {
			this.nivelBasico.opinarSobre(this.muestra, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 6, 11)); //Esto funciona pero está afuera del coverage
		});
	}

}
