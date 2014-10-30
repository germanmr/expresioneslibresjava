package ar.com.german.ExpresionesLibres.shared.modelo.dispatch;


import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class ObtenerEntidadDeCsvAction extends UnsecuredActionImpl<ObtenerEntidadDeCsvResult> {

	private String datos;

	public ObtenerEntidadDeCsvAction() {
	}

	public ObtenerEntidadDeCsvAction(String datos) {
		super();
		this.datos = datos;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	@Override
	public String toString() {
		return "ObtenerEntidadDeCsvAction [datos=" + datos + ", toString()=" + super.toString() + "]";
	}

}
