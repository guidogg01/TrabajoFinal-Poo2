package ar.edu.unq.po2.Composite;

import java.util.List;

import ar.edu.unq.po2.TipoDeOpinion;
import ar.edu.unq.po2.State.Muestra.Muestra;

public class TipoDeInsecto  implements IFiltro {
	
	private TipoDeOpinion tipoDeInsectoAFiltrar;

	public TipoDeInsecto(TipoDeOpinion tipoDeInsectoAFiltrar) {
		super();
		this.setTipoDeInsectoAFiltrar(tipoDeInsectoAFiltrar);
	}
	
	public TipoDeOpinion getTipoDeInsectoAFiltrar() {
		return tipoDeInsectoAFiltrar;
	}

	private void setTipoDeInsectoAFiltrar(TipoDeOpinion tipoDeInsectoAFiltrar) {
		this.tipoDeInsectoAFiltrar = tipoDeInsectoAFiltrar;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestrasAFiltrar) {
		return muestrasAFiltrar.stream()
                               .filter(m -> m.resultadoActual().equals(this.getTipoDeInsectoAFiltrar()))
                               .toList();
	}

}
