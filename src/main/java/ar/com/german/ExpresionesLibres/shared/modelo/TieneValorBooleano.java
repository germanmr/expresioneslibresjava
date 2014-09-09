package ar.com.german.ExpresionesLibres.shared.modelo;


public final class TieneValorBooleano implements Tienevalor {

	private Boolean constante;

	public TieneValorBooleano(Boolean constante) {
		this.constante = constante;
	}

	@Override
	public Boolean getValor() {
		return constante;
	}
}
