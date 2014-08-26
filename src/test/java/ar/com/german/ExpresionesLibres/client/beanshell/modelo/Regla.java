package ar.com.german.ExpresionesLibres.client.beanshell.modelo;

/**
 * Indica una condicion, un conjunto de expresiones simples concatenadas, con un
 * resultado T asociado
 * 
 * @author germanmr
 * 
 * @param <T>
 */
public final class Regla<T> {

	// Es la descripcion de lo necesario para que se cumpla la regla
	final String condicion;
	final T resultado;

	public Regla(String condicion, T resultado) {
		this.condicion = condicion;
		this.resultado = resultado;
	}

	public String getCondicion() {
		return condicion;
	}

	public T getResultado() {
		return resultado;
	}

}
