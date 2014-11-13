package ar.com.german.ExpresionesLibres.shared.modelo;

public abstract class AbstractValor {

	private TipoValor tipoValor;

	public AbstractValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	protected TipoValor getTipoValor() {
		return tipoValor;
	}

}
