package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.List;

/**
 * Es cualquier entidad del modelo de negocio de una {@link Expresion}
 * 
 * @author germanmr
 * 
 */
public final class Concepto {

	// Se utiliza para identificar al concepto en la regla
	String identificacion;
	// Es un nombre decriptivo
	String descripcion;

	/**
	 * Es basicamente el tiop de dato a alto nivel( numero, cadena, booleano)
	 * para relacionar a la hora de comparar
	 */
	TiposConceptos tiposConceptos;

	List<Comparador> comparadoresValidos;

	public Concepto() {
	}

	/**
	 * Crea un concepto con una identificacion, una descripcion y un
	 * {@link TiposConceptos}
	 * 
	 * @param identificacion
	 * @param descripcion
	 * @param tiposConceptos
	 */
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

	public TiposConceptos getTiposConceptos() {
		return tiposConceptos;
	}

	public void setTiposConceptos(TiposConceptos tiposConceptos) {
		this.tiposConceptos = tiposConceptos;
	}

	public List<Comparador> getComparadoresValidos() {
		return comparadoresValidos;
	}

	public void setComparadoresValidos(List<Comparador> comparadoresValidos) {
		this.comparadoresValidos = comparadoresValidos;
	}

	public String getPrefijo() {

		String prefijo = "";
		if (tiposConceptos.equals(TiposConceptos.CADENA)) {
			prefijo = "\"";
		}

		return prefijo;
	}

	public String getSufijo() {
		String sufijo = "";
		if (tiposConceptos.equals(TiposConceptos.CADENA)) {
			sufijo = "\"";
		}

		return sufijo;

	}

}
