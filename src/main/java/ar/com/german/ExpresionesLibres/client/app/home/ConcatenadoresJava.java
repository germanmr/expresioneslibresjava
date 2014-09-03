package ar.com.german.ExpresionesLibres.client.app.home;

public enum ConcatenadoresJava {

	ADEMAS(" ADEMAS "),
	// &&
	O(" O ");
	// ||

	private final String descripcion;

	private ConcatenadoresJava(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
