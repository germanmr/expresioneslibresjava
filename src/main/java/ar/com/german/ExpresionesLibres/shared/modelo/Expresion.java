package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.Arrays;

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

	/**
	 * Ingresamos un concepto, un comparador, una entidad de valor/es constantes
	 * y un concatenador
	 * 
	 * @param concepto
	 * @param comparador
	 * @param constante
	 * @param concatenador
	 */
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
			// TODO representar a coleccionConstante como
			// Arrays.asList(valorConstante)
			// "Arrays.asList(" prefijo) + valorConstante + ")" sufijo

			String constantegetPrefijo = constante.getPrefijo();
			String constantegetValor = constante.getValor();
			String constantegetSufijo = constante.getSufijo();
			String conceptogetValor = concepto.getIdentificacion();

			condicionReal = constantegetPrefijo + constantegetValor + constantegetSufijo
					+ comparador.getPrefijo(concepto.getTiposConceptos()) + concepto.getIdentificacion()
					+ comparador.getSufijo(concepto.getTiposConceptos());

			// condicionReal = constante.getValor() + constante.getPrefijo() +
			// concepto.getValor() + constante.getSufijo();

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
