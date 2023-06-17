package ar.edu.unq.po2.Composite;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.State.Muestra.Muestra;

public class FechaUltimaVotacion implements IFiltro {

	private LocalDate fechaAFiltrar;

	public FechaUltimaVotacion(LocalDate fechaAFiltrar) {
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
	                           .filter(m -> m.fechaDeUltimaVotacion().equals(this.getFechaAFiltrar()))
	                           .toList();
	}
	
}
