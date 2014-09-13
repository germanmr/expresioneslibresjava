package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.SortedSet;

public class TieneValorColeccionNumeros implements Tienevalor {

	private SortedSet<Integer> numeros;

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
}
