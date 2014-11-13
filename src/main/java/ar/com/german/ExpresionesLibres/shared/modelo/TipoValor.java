package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Primer intento de solucion para aramar las condiciones para oleccciones o
 * valores simples
 * 
 * @author germanmr
 * 
 */
public enum TipoValor {

	SIMPLE("VALOR SIMPLE"), COLECCION("COLECCION");

	private final String descripcion;

	private TipoValor(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
