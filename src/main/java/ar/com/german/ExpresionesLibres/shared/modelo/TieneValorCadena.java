package ar.com.german.ExpresionesLibres.shared.modelo;


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
