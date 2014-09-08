package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Es una agrupamiento de un {@link Concepto} + un {@link Concatenador} + un
 * valor + mas un {@link Concatenador}
 * 
 * @author germanmr
 * 
 */
public final class Expresion implements Tienevalor {

	private Concepto concepto;

	private Comparador comparador;
	// TODO Hacer de Constante una clase T???
	private Tienevalor constante;
	// private Tienevalor constante;
	private Concatenador concatenador;

	public Expresion() {
	}

	public Expresion(Concepto concepto, Comparador comparador, Tienevalor constante, Concatenador concatenador) {
		this.concepto = concepto;
		this.comparador = comparador;
		this.constante = constante;
		this.concatenador = concatenador;
	}

	/**
	 * Obtenemos un {@link String} con la condicion parseada<br>
	 * Concepto Comparador valor
	 * 
	 */
	public String obtenerCondicionReal() {
		String condicionReal;

		condicionReal = concepto.getIdentificacion() + comparador.getPrefijo() + concepto.getPrefijo() + getValor() + concepto.getSufijo()
				+ comparador.getSufijo();

		return condicionReal;

	}

	@Override
	public <T> T getValor() {
		return constante.getValor();
	}

	/**
	 * Obtenemos un {@link String} con la condicion parseada<br>
	 * Concepto Comparador valor
	 * 
	 */
	public String obtenerCondicionEscrita() {
		String condicionEscrita;

		condicionEscrita = "Si " + concepto.getDescripcion() + " " + comparador.getDescripcion() + " " + constante;

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
