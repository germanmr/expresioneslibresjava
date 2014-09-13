package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Lo utilizamos para obtener la relacion entre el un concepto y un valor
 * 
 * @author germanmr
 * 
 */
public class Comparador {

	private String descripcion;
	private OperadoresSimbolicos operadorSimbolico;

	public Comparador() {
	}

	public Comparador(String descripcion, OperadoresSimbolicos operadorSimbolico) {
		this.descripcion = descripcion;
		this.operadorSimbolico = operadorSimbolico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtenemos la expresion que va antes del valor en una comparacion
	 * 
	 * @return
	 */
	public String getPrefijo(TiposConceptos tipoConcepto) {
		// TODO refatorizaaaaaaaaaaaaaaa!!!!!!!!!!

		/**
		 * Los comparadores dependen del Tio de comparador y el Tipo de dato del
		 * concepto
		 */

		String operadorReal = "";

		switch (operadorSimbolico) {

		case IGUAL:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = "==";
			} else {
				operadorReal = ".equals(";
			}
			break;

		case DISTINTO:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = "<>";
			} else {
				operadorReal = ".equals(";
			}
			operadorReal = "<>";
			break;

		case MENOR:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = ">";
			} else {
				operadorReal = ".compareTo(";
			}

			break;

		case MENORIGUAL:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = "<=";
			} else {
				operadorReal = ".compareTo(";
			}
			break;

		case MAYOR:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = ">";
			} else {
				operadorReal = ".equals(";
			}

			break;

		case MAYORIGUAL:
			if (TiposConceptos.NUMERO.equals(tipoConcepto)) {
				operadorReal = ">=";
			} else {
				operadorReal = ".compareTo(";
			}
			// "a".compareTo("b"); // esto da (-1) menor a es menor que b
			boolean menorque = "a".compareTo("b") == -1 ? true : false;
			// concepto comparador
			// transformo a true
			// "b".compareTo("a"); // esto da (-1) menor
			// "a".compareTo("b"); // esto da (-1) menor

			break;

		case ESTANEN:
			operadorReal = ".contains(";
			break;

		default:
			break;
		}

		return operadorReal;

	}

	/**
	 * Es lo que va despues del valor en algunas expresiones
	 * 
	 * @return
	 */
	public String getSufijo(TiposConceptos tipoConcepto) {
		String operadorReal = "";

		switch (operadorSimbolico) {

		case IGUAL:
			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")";
			}

			break;

		case DISTINTO:

			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")";
			}

			break;

		case MENORIGUAL:

			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")< 1 ? true : false";
			}

			break;
		case MENOR:
			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")< 0 ? true : false";
			}

			break;

		case MAYORIGUAL:

			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")> -1 ? true : false";
			}

			break;

		case MAYOR:

			if (tipoConcepto.equals(TiposConceptos.NUMERO)) {
				operadorReal = "";
			} else {
				operadorReal = ")> 0 ? true : false";
			}

			break;

		case ESTANEN:
			operadorReal = ")";
			break;

		default:
			break;
		}

		return operadorReal;

	}

}
