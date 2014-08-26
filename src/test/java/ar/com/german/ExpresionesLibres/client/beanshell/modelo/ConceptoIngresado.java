package ar.com.german.ExpresionesLibres.client.beanshell.modelo;

import ar.com.german.ExpresionesLibres.client.Tienevalor;

/**
 * Es un valor ingresado para un {@link Concepto} dado
 * 
 * @author germanmr
 * 
 * @param <T>
 */
public final class ConceptoIngresado<T> implements TieneConceptoConValor {

	final Concepto concepto;
	final T valorIngresado;

	public ConceptoIngresado(Concepto concepto, T valorIngresado) {
		this.concepto = concepto;
		this.valorIngresado = valorIngresado;
	}

	@Override
	public Concepto getConcepto() {
		return concepto;
	}

	@Override
	public <T> T getValor() {
		return (T) valorIngresado;
	}

}
