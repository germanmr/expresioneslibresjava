package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Es cualquier entidad del modelo de negocio de una {@link Regla}
 * 
 * @author germanmr
 * 
 */
public final class Concepto {

	// Se utiliza para identificar al concepto en la regla
	String identificacion;
	// Es un nombre decriptivo
	String descripcion;

	public Concepto() {
	}

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

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Concepto [identificacion=" + identificacion + ", descripcion=" + descripcion + ", toString()="
				+ super.toString() + "]";
	}

}
