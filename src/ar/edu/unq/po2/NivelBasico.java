package ar.edu.unq.po2;

public class NivelBasico extends NivelDeConocimiento {

	public NivelBasico(Participante participante) {
		super(participante);
	}
	
	@Override
	public boolean esExperto() {
		return false;
	}

	@Override
	protected void opinarSobre(Muestra muestra, TipoDeOpinion tipoDeOpinion) {
		// TODO Auto-generated method stub
		
	}

}
