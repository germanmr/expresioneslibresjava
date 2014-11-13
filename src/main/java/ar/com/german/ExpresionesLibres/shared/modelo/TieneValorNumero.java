package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Esto lo usamos para representar un valor constante numerico
 * 
 * @author germanmr
 * 
 */
public class TieneValorNumero implements EsComparable {

	private Integer constante;
	private TipoValor tipoValor = TipoValor.SIMPLE;

	public TieneValorNumero(Integer constante) {

		this.constante = constante;
	}

	@Override
	public Integer getValor() {
		return constante;
	}

	@Override
	public TipoValor getTipoValor() {
		return tipoValor;
	}

	@Override
	public String getIdentificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrefijo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSufijo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiposConceptos getTiposConceptos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concepto getConcepto() {
		// TODO Auto-generated method stub
		return null;
	}
}
