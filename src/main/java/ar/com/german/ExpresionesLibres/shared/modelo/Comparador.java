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
		// TODO REFACTORIZARRRRRRRRR!!!!!!!!!!

		/**
		 * Los comparadores dependen del Tipo de comparador y el Tipo de dato
		 * del concepto
		 */

		String prefijoReal = "";

		switch (operadorSimbolico) {

		case IGUAL:
			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = "==";

				break;
			case BOOLEANO:
				prefijoReal = "==";

				break;
			case CADENA:
				prefijoReal = ".equals(";

				break;
			default:
				break;
			}

			break;

		case DISTINTO:

			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = "!=";

				break;
			case BOOLEANO:
				prefijoReal = "!=";

				break;
			case CADENA:
				prefijoReal = ".equals(";

				break;
			default:
				break;
			}

			break;

		case MENOR:

			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = ">";

				break;
			case BOOLEANO:
				prefijoReal = null;

				break;
			case CADENA:
				prefijoReal = ".compareTo(";

				break;
			default:
				break;
			}

			break;

		case MENORIGUAL:

			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = "<=";

				break;
			case BOOLEANO:
				prefijoReal = null;

				break;
			case CADENA:
				prefijoReal = ".compareTo(";

				break;
			default:
				break;
			}

			break;

		case MAYOR:

			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = ">";

				break;
			case BOOLEANO:
				prefijoReal = null;

				break;
			case CADENA:
				prefijoReal = ".equals(";

				break;
			default:
				break;
			}

			break;

		case MAYORIGUAL:

			switch (tipoConcepto) {
			case NUMERO:
				prefijoReal = ">=";

				break;
			case BOOLEANO:
				prefijoReal = null;

				break;
			case CADENA:
				prefijoReal = ".compareTo(";

				break;
			default:
				break;
			}

			// "a".compareTo("b"); // esto da (-1) menor a es menor que b
			// boolean menorque = "a".compareTo("b") == -1 ? true : false;
			// concepto comparador
			// transformo a true
			// "b".compareTo("a"); // esto da (-1) menor
			// "a".compareTo("b"); // esto da (-1) menor

			break;

		case ESTANEN:
			prefijoReal = ".contains(";
			break;

		default:
			break;
		}

		return prefijoReal;

	}

	/**
	 * Es lo que va despues del valor en algunas expresiones
	 * 
	 * @return
	 */
	// TODO REFACTORIZAR, a una colecccion ????????
	public String getSufijo(TiposConceptos tipoConcepto) {
		String sufijoReal = "";

		switch (operadorSimbolico) {

		case IGUAL:
			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")";
				break;

			default:
				break;
			}

			break;

		case DISTINTO:

			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")";
				break;

			default:
				break;
			}

			break;

		case MENORIGUAL:

			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")< 1 ? true : false";
				break;

			default:
				break;
			}

			break;

		case MENOR:

			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")< 0 ? true : false";
				break;

			default:
				break;
			}

			break;

		case MAYORIGUAL:

			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")> -1 ? true : false";
				break;

			default:
				break;
			}

			break;

		case MAYOR:
			switch (tipoConcepto) {
			case NUMERO:
				sufijoReal = "";
				break;

			case BOOLEANO:
				sufijoReal = "";
				break;

			case CADENA:
				sufijoReal = ")> 0 ? true : false";
				break;

			default:
				break;
			}

			break;

		case ESTANEN:
			sufijoReal = ")";
			break;

		default:
			break;
		}

		return sufijoReal;

	}

}
