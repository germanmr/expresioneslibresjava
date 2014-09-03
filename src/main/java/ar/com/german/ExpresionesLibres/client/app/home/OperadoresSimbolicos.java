package ar.com.german.ExpresionesLibres.client.app.home;

public enum OperadoresSimbolicos {

	// .equals() o ==
	IGUAL("ES IGUAL A "),
	// <> o !.equals
	DISTINTO("ES DISTINTO DE "),
	// <
	MENOR("ES MENOR QUE "),
	// <=
	MENORIGUAL("ES MENOR IGUAL QUE"),
	// >
	MAYOR("ES MAYOR QUE "),
	// >=
	MAYORIGUAL("ES MAYOR IGUAL QUE "),
	// .contains() para numeros y cadenas
	ENTRE("ESTA ENTRE");

	private final String descripcion;

	private OperadoresSimbolicos(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	

}
