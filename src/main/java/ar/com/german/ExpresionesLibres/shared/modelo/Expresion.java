package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Es una agrupamiento de un {@link Concepto} + un {@link Concatenador} + un
 * valor + mas un {@link Concatenador}
 * 
 * @author germanmr
 * 
 */
public final class Expresion {

	// private Concepto concepto;
	private EsComparable concepto;
	private Comparador comparador;
	private EsComparable constante;
	private Concatenador concatenador;

	public Expresion() {
	}

	public Expresion(EsComparable concepto, Comparador comparador, EsComparable constante, Concatenador concatenador) {
		this.concepto = concepto;
		this.comparador = comparador;
		this.constante = constante;
		this.concatenador = concatenador;
	}

	/**
	 * Obtenemos un {@link String} con la condicion parseada<br>
	 * Concepto + Prefijo comparador + Prefijo Concepto + Sufijo()
	 * 
	 */
	public String obtenerCondicionReal() {
		String condicionReal = "";

		switch (constante.getTipoValor()) {
		case SIMPLE:

			condicionReal = concepto.getIdentificacion() + comparador.getPrefijo(concepto.getTiposConceptos()) + concepto.getPrefijo()
					+ constante.getValor() + concepto.getSufijo() + comparador.getSufijo(concepto.getTiposConceptos());
			break;

		case COLECCION:

			// Aca se arma:
			// colecccionConstante.contains(conceptoIngresado)

			condicionReal = constante.getIdentificacion() + comparador.getPrefijo(concepto.getTiposConceptos()) + constante.getValor()
					+ comparador.getSufijo(concepto.getTiposConceptos());

			break;

		default:
			break;
		}

		return condicionReal;

	}

	/**
	 * Obtenemos un {@link String} con la condicion parseada<br>
	 * Concepto Comparador valor
	 * 
	 */
	public String obtenerCondicionEscrita() {
		String condicionEscrita;

		condicionEscrita = "Si " + concepto.getDescripcion() + " " + comparador.getDescripcion() + " " + constante.getValor();

		return condicionEscrita;

	}

	public String obtenerExpresionReal() {

		return obtenerCondicionReal() + getConcatenador().getConcatenadorReal();

	}

	public Concatenador getConcatenador() {
		return concatenador;
	}

	public void setConcatenador(Concatenador concatenador) {
		this.concatenador = concatenador;
	}

	@Override
	public String toString() {
		return "Expresion [concepto=" + concepto + ", comparador=" + comparador + ", constante=" + constante + ", concatenador="
				+ concatenador + ", toString()=" + super.toString() + "]";
	}

}
