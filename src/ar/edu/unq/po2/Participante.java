package ar.edu.unq.po2;

public class Participante {
	
	private int ID;
	
	public Participante(int id) {
		super();
		this.setID(id);
	}

	public boolean esExperto() {
		//Esto se debería delegar al nivelDeConocomiento para que lo haga cada uno de los estados.
		//this.getNivelDeConomiento().esEstadoExperto();
		return true;
	}

	public int getID() {
		return this.ID;
	}
	
	private void setID(int id) {
		this.ID = id;
	}

}
