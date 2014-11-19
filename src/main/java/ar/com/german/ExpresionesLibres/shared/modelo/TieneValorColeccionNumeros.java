package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.SortedSet;

public class TieneValorColeccionNumeros implements EsComparable {

	private SortedSet<Integer> numeros;

	private Concepto concepto;

	/**
	 * Pasar esto a una interfaz para marcar el tipo!!!!!
	 */
	private TipoValor tipoValor = TipoValor.COLECCION;

	private TiposConceptos tiposConceptos = TiposConceptos.NUMERO;

	public TieneValorColeccionNumeros(SortedSet<Integer> numeros, Concepto concepto) {
		this.numeros = numeros;
		this.concepto = concepto;
	}

	@Override
	public String getValor() {

		StringBuilder valores = new StringBuilder();
		for (Integer numero : numeros) {
			valores.append(numero.toString());

			if (numero != numeros.last()) {
				valores.append(", ");
			}
		}
		return valores.toString();

	}

	@Override
	public TipoValor getTipoValor() {
		return tipoValor;
	}

	@Override
	public String getIdentificacion() {
		return concepto.getIdentificacion();
	}

	@Override
	public String getPrefijo() {
		return "java.util.Arrays.asList(";

	}

	@Override
	public String getSufijo() {
		return ")";
	}

	@Override
	public TiposConceptos getTiposConceptos() {
		return tiposConceptos;
	}

	@Override
	public String getDescripcion() {
		return null;
	}

	@Override
	public Concepto getConcepto() {
		return concepto;
	}

}
