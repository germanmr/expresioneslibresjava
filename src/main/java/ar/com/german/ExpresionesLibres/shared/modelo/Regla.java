package ar.com.german.ExpresionesLibres.shared.modelo;

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
	String condicion;
	T resultado;

	public Regla() {
	}

	public Regla(String condicion, T resultado) {
		this.condicion = condicion;
		this.resultado = resultado;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public T getResultado() {
		return resultado;
	}

	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Regla [condicion=" + condicion + ", resultado=" + resultado + ", toString()=" + super.toString() + "]";
	}

}
