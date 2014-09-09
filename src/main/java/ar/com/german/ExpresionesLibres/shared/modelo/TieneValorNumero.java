package ar.com.german.ExpresionesLibres.shared.modelo;


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
