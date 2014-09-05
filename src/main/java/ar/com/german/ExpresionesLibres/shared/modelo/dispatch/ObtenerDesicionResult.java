package ar.com.german.ExpresionesLibres.shared.modelo.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class ObtenerDesicionResult implements Result {

	private static final long serialVersionUID = 1L;

	private Integer resultado;

	public ObtenerDesicionResult() {
	}

	public ObtenerDesicionResult(Integer resultado) {
		this.resultado = resultado;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

}
