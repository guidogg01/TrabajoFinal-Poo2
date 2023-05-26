package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectTestCase {
	
	private Subject subject;
	
	private IZonaDeCoberturaListeners iZona;
	
	@BeforeEach
	void setup() {
		
		subject = new Subject();
		
		iZona   = mock(IZonaDeCoberturaListeners.class);
		
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
		//Exercise
		this.subject.desubscribirObserver(this.iZona);
		
		assertTrue(this.subject.getObservers().isEmpty());
	}

}
