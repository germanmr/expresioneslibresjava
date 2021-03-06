package ar.com.german.ExpresionesLibres.shared.modelo;

/**
 * Relaciona dos expresiones Expresiones simples
 * 
 * @author germanmr
 * 
 */
public final class Concatenador {

	private String nombre;
	private ConcatenadoresJava concatenador;

	public Concatenador() {
	}

	public Concatenador(String nombre, ConcatenadoresJava concatenador) {
		this.nombre = nombre;
		this.concatenador = concatenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ConcatenadoresJava getConcatenador() {
		return concatenador;
	}

	public void setConcatenador(ConcatenadoresJava concatenador) {
		this.concatenador = concatenador;
	}

	public String getConcatenadorReal() {

		String concatenadorReal = "";

		switch (concatenador) {
		case ADEMAS:
			concatenadorReal = " && ";
			break;

		case O:
			concatenadorReal = " || ";
			break;

		default:
			break;
		}

		return concatenadorReal;
	}

}
