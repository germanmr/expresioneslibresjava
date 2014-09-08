package ar.com.german.ExpresionesLibres.client;

import ar.com.german.ExpresionesLibres.shared.modelo.Tienevalor;

/**
 * 
 * @author germanmr
 * 
 */
public class TieneValorCadena implements Tienevalor {

	private String constante;

	public TieneValorCadena(String constante) {
		this.constante = constante;
	}

	@Override
	public String getValor() {
		return constante;
	}

}
