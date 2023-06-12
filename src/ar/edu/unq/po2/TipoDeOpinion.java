package ar.edu.unq.po2;

public enum TipoDeOpinion {
	
	VINCHUCASORDIDA  ("Soy una vinchuca Sordida"),
	VINCHUCAINFESTANS("Soy una vinchuca Infestans"),
	VINCHUCAGUASAYANA("Soy una vinchuca Guasayana"),
	CHINCHEFOLIADA   ("Soy una chinche Foliada"),
	PHTIACHINCHE     ("Soy una phtia chinche"),
	NINGUNA("La imagen no corresponde a un insecto"),
	IMAGENPOCOCLARA("La imagen es poco clara"), 
	NODEFINIDO("El resultado actual es no definido");
	
	private String descripcion;
	
	private TipoDeOpinion(String descripcion) {
		this.setDescripcion(descripcion);
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}