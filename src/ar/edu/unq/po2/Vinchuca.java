package ar.edu.unq.po2;

public enum Vinchuca {
	
	SORDIDA("Soy una vinchuca Sordida"), INFESTANS("Soy una vinchuca Infestans"), GUASAYANA("Soy una vinchuca Guasayana");
	
	private String descripcion;
	
	private Vinchuca(String descripcion) {
		this.setDescripcion(descripcion);
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
