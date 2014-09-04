package ar.com.german.ExpresionesLibres.shared.modelo.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class ObtenerDesicionResult implements Result {

	private static final long serialVersionUID = 1L;

	private String resultado;

	public ObtenerDesicionResult() {
	}

	public ObtenerDesicionResult(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
