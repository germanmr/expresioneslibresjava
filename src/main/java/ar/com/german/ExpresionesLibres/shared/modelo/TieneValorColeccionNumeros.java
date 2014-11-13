package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.SortedSet;

public class TieneValorColeccionNumeros implements EsComparable {

	private SortedSet<Integer> numeros;

	/**
	 * Pasar esto a una interfaz para marcar el tipo!!!!!
	 */
	private TipoValor tipoValor = TipoValor.COLECCION;

	public TieneValorColeccionNumeros(SortedSet<Integer> numeros) {
		this.numeros = numeros;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefijo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSufijo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiposConceptos getTiposConceptos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concepto getConcepto() {
		// TODO Auto-generated method stub
		return null;
	}

}
