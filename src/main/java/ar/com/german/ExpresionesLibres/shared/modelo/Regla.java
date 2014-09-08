package ar.com.german.ExpresionesLibres.shared.modelo;

import java.util.List;

/**
 * Indica una condicion, un conjunto de expresiones simples concatenadas, con un
 * resultado T asociado
 * 
 * @author germanmr
 * 
 * @param <R>
 */
public final class Regla<R> {

	// Es la descripcion de lo necesario para que se cumpla la regla
	List<Expresion> expresiones;
	R resultado;

	public Regla() {
	}

	public Regla(List<Expresion> expresiones, R resultado) {
		this.expresiones = expresiones;
		this.resultado = resultado;
	}

	public List<Expresion> getExpresiones() {
		return expresiones;
	}

	public void setExpresiones(List<Expresion> expresiones) {
		this.expresiones = expresiones;
	}

	public R getResultado() {
		return resultado;
	}

	public void setResultado(R resultado) {
		this.resultado = resultado;
	}

	public String getReglaReal() {
		StringBuilder builder = new StringBuilder();
		for (Expresion expresion : expresiones) {
			builder.append(expresion.obtenerExpresionReal());
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		return "Regla [expresiones=" + expresiones + ", resultado=" + resultado + ", toString()=" + super.toString() + "]";
	}

}