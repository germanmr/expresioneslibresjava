package ar.com.german.ExpresionesLibres.server.dispatch;

/**
 * 
 * @author germanmr
 * 
 */
public class Persona {

	private Integer codigo;
	private String nombre;
	private String descripcion;

	public Persona() {
	}

	public Persona(Integer codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", toString()=" + super.toString()
				+ "]";
	}

}
