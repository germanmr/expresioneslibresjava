package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.SortedSet;

public class TieneValorColeccionCadena implements Tienevalor {

	private SortedSet<String> cadenas;

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

}
