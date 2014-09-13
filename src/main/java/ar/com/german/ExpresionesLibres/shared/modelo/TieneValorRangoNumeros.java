package ar.com.german.ExpresionesLibres.shared.modelo;


/**
 * Es un valor de rangos
 * 
 * @author germanmr
 * 
 */
public class TieneValorRangoNumeros implements Tienevalor {

	private Integer minimo;
	private Integer maximo;

	public TieneValorRangoNumeros(Integer minimo, Integer maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	@Override
	public String getValor() {
		return minimo + ", " + maximo;
	}

}
