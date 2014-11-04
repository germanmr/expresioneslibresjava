package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Tipos de datos de los conceptos <br>
 * Fueron simplificados a Cadena, numero o booleano
 * 
 * @author germanmr
 * 
 */
public enum TiposConceptos {
	/**
	 * Cada uno de estos tiene {@link OperadoresSimbolicos} permitidos Ejemplo:
	 * Booleano no puede ser mayor igual que
	 */

	CADENA("STRING"), NUMERO("NUMERO"), BOOLEANO("BOOLEANO");

	private final String descripcion;

	private TiposConceptos(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
