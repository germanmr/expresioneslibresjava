package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.List;

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

	TiposConceptos tiposConceptos;

	List<String> operadoresValidos;

	// OperadorComparacion

	public Concepto() {
	}

	public Concepto(String identificacion, String descripcion, TiposConceptos tiposConceptos) {
		this.identificacion = identificacion;
		this.descripcion = descripcion;
		this.tiposConceptos = tiposConceptos;
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
		return "Concepto [identificacion=" + identificacion + ", descripcion=" + descripcion + ", toString()=" + super.toString() + "]";
	}

}
