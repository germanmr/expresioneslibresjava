package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Es un valor ingresado para un {@link Concepto} dado
 * 
 * @author germanmr
 * 
 * @param <T>
 */
public final class ConceptoIngresado<T> implements TieneConceptoConValor {

	Concepto concepto;
	T valorIngresado;

	public ConceptoIngresado() {
	}

	public ConceptoIngresado(Concepto concepto, T valorIngresado) {
		this.concepto = concepto;
		this.valorIngresado = valorIngresado;
	}

	@Override
	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	@Override
	public <T> T getValor() {
		return (T) valorIngresado;
	}

	public void setValorIngresado(T valorIngresado) {
		this.valorIngresado = valorIngresado;
	}

}
