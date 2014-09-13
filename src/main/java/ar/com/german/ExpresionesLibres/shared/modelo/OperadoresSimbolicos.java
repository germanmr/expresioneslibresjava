package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Esta enumeracion esta hecha para poder utilizar los Comparadores de una
 * manera mas abstracta conta los {@link Concepto} y valores
 * 
 * @author germanmr
 * 
 */
public enum OperadoresSimbolicos {

	IGUAL("ES IGUAL A "), DISTINTO("ES DISTINTO DE "), MENOR("ES MENOR QUE "), MENORIGUAL("ES MENOR IGUAL QUE"), MAYOR("ES MAYOR QUE "), MAYORIGUAL(
			"ES MAYOR IGUAL QUE "), ESTANEN(" ESTA EN ");

	private final String descripcion;

	private OperadoresSimbolicos(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
