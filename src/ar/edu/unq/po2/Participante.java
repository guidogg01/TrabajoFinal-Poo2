package ar.edu.unq.po2;

public class Participante {

	public boolean esExperto() {
		//Esto se debería delegar al nivelDeConocomiento para que lo haga cada uno de los estados.
		//this.getNivelDeConomiento().esEstadoExperto();
		return true;
	}

}
