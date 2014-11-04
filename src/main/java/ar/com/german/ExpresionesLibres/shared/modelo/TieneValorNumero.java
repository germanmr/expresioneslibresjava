package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Esto lo usamos para representar un valor constante numerico
 * 
 * @author germanmr
 * 
 */
public class TieneValorNumero implements Tienevalor {

	private Integer constante;

	public TieneValorNumero(Integer constante) {
		this.constante = constante;
	}

	@Override
	public Integer getValor() {
		return constante;
	}

}
