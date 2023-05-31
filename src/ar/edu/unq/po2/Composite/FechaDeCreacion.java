package ar.edu.unq.po2.Composite;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.Muestra;

public class FechaDeCreacion implements IFiltro {

	private LocalDate fechaAFiltrar;

	public FechaDeCreacion(LocalDate fechaAFiltrar) {
		super();
		this.setFechaAFiltrar(fechaAFiltrar);
	}

	public LocalDate getFechaAFiltrar() {
		return fechaAFiltrar;
	}

	private void setFechaAFiltrar(LocalDate fechaAFiltrar) {
		this.fechaAFiltrar = fechaAFiltrar;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		return muestrasAFiltrar.stream()
				               .filter(m -> m.getFechaDeCreacion().equals(this.getFechaAFiltrar()))
				               .toList();
	}
	
}
