package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Es un valor de rangos
 * 
 * @author germanmr
 * 
 */
public class TieneValorRangoNumeros implements TieneValor {

	private Integer minimo;
	private Integer maximo;

	private TipoValor tipoValor = TipoValor.COLECCION;

	public TieneValorRangoNumeros(Integer minimo, Integer maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	@Override
	public String getValor() {
		return minimo + ", " + maximo;
	}

	@Override
	public TipoValor getTipoValor() {
		return tipoValor;
	}

}
