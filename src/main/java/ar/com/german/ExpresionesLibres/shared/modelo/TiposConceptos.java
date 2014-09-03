package ar.com.german.ExpresionesLibres.shared.modelo;

public enum TiposConceptos {

	CADENA("STRING"), NUMERO("NUMERO"), BOOLEANO("BOOLEANO");

	private final String descripcion;

	private TiposConceptos(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
