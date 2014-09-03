package ar.com.german.ExpresionesLibres.client.app.home;

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

	public Comparador(String descripcion, OperadoresSimbolicos operadorReal) {
		this.descripcion = descripcion;
		this.operadorSimbolico = operadorReal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtenemos la expresion qu va antes del valor en una comparacion
	 * 
	 * @return
	 */
	public String getPrefijo() {

		String operadorReal = null;

		switch (operadorSimbolico) {

		case IGUAL:
			// concepto.equals(valor) o concepto==valor
			operadorReal = ".equals(";
			break;

		case DISTINTO:
			// <> o !.equals
			operadorReal = "<>";
			break;

		case MENOR:
			operadorReal = ">";
			// >
			break;

		case MENORIGUAL:
			operadorReal = "<=";
			// <=
			break;

		case MAYOR:
			operadorReal = ">";
			// >
			break;

		case MAYORIGUAL:
			operadorReal = ">=";
			// >=
			break;

		case ENTRE:
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
	public String getSufijo() {
		String operadorReal = null;

		switch (operadorSimbolico) {

		case IGUAL:
			operadorReal = ")";
			break;

		case DISTINTO:
			operadorReal = ")";
			break;

		case ENTRE:
			operadorReal = ")";
			break;

		default:
			break;
		}

		return operadorReal;

	}

}
