package ar.edu.unq.po2.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Muestra;
import ar.edu.unq.po2.Observer.IZonaDeCoberturaListeners;
import ar.edu.unq.po2.Observer.Subject;

class SubjectTestCase {
	
	private Subject subject;
	
	private IZonaDeCoberturaListeners iZona;
	private ZonaDeCobertura zonaDeCobertura;
	
	private Muestra muestra;
	
	@BeforeEach
	void setup() {
		
		subject = new Subject();
		
		iZona   = mock(IZonaDeCoberturaListeners.class);
		muestra = mock(Muestra.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		
	}

	@Test
	void verificacionDeInicializacionDeUnSubject() {
		assertTrue(this.subject.getObservers().isEmpty());
	}
	
	@Test
	void verificacionCuandoUnSubjectSubscribeAUnObserver() {
		//Exercise
		this.subject.subscribirObserver(this.iZona);
		
		assertFalse(this.subject.getObservers().isEmpty());
	}
	
	@Test
	void verificacionCuandoUnSubjectDesubscribeAUnObserver() {
		//SetUp
		this.subject.subscribirObserver(this.iZona);
		
		//Exercise
		this.subject.desubscribirObserver(this.iZona);
		
		assertTrue(this.subject.getObservers().isEmpty());
	}
	
	@Test
	void verificacionCuandoSeNotificaUnaMuestraCargadaYLaValidacionDeLaMisma() {
		//SetUp
		this.subject.subscribirObserver(this.iZona);
		
		//Exercise
		this.subject.notificarCargaDeMuestra(zonaDeCobertura, muestra);
		
		verify(this.iZona, times(1)).nuevaMuestraCargada(this.zonaDeCobertura, this.muestra);
		verify(this.iZona, times(1)).nuevaValidacionDeMuestra(this.zonaDeCobertura, this.muestra);
	}

}
















