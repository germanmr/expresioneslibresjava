package ar.com.german.ExpresionesLibres.client.beanshell.modelo;

/**
 * Es cualquier entidad del modelo de negocio de una {@link Regla}
 * 
 * @author germanmr
 * 
 */
public final class Concepto {

	// Se utiliza para identificar al concepto en la regla
	final String identificacion;
	// Es un nombre decriptivo
	final String descripcion;

	/**
	 * 
	 * @param codigo
	 * @param descripcion
	 */
	public Concepto(String codigo, String descripcion) {
		this.identificacion = codigo;
		this.descripcion = descripcion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
