package ar.com.german.ExpresionesLibres.client;

import ar.com.german.ExpresionesLibres.shared.modelo.Tienevalor;

public class TieneValorBooleano implements Tienevalor {

	private Boolean constante;

	public TieneValorBooleano(boolean constante) {
		this.constante = constante;
	}

	@Override
	public Boolean getValor() {
		return constante;
	}
}
