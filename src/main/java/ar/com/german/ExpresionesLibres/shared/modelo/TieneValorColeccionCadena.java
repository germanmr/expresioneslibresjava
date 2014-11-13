package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.SortedSet;

public class TieneValorColeccionCadena implements TieneValor, TieneTipoValor {

	private SortedSet<String> cadenas;

	/**
	 * Pasar esto a una interfaz para marcar el tipo!!!!!
	 */
	private TipoValor tipoValor = TipoValor.COLECCION;

	public TieneValorColeccionCadena(SortedSet<String> cadenas) {

		this.cadenas = cadenas;
	}

	@Override
	public String getValor() {

		StringBuilder valores = new StringBuilder();
		for (String numero : cadenas) {
			valores.append(numero.toString());
			if (valores.capacity() != valores.indexOf(numero.toString())) {
				valores.append(", ");
			}
		}
		return valores.toString();

	}

	@Override
	public TipoValor getTipoValor() {
		return tipoValor;
	}

}
