package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * 
 * @author germanmr
 * 
 */
public class TieneValorCadena implements EsComparable {

	private String constante;
	private TipoValor tipoValor = TipoValor.SIMPLE;

	public TieneValorCadena(String constante) {
		this.constante = constante;
	}

	@Override
	public String getValor() {
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
