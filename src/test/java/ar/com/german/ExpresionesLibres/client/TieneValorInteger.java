package ar.com.german.ExpresionesLibres.client;

import ar.com.german.ExpresionesLibres.shared.modelo.Tienevalor;

public class TieneValorInteger implements Tienevalor {

	private Integer constante;

	public TieneValorInteger(Integer constante) {
		this.constante = constante;
	}

	@Override
	public Integer getValor() {
		return constante;
	}

}
