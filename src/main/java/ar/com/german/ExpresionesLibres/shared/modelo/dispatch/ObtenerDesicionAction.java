package ar.com.german.ExpresionesLibres.shared.modelo.dispatch;

import java.util.List;

import ar.com.german.ExpresionesLibres.shared.modelo.TieneConceptoConValor;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValor;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class ObtenerDesicionAction extends UnsecuredActionImpl<ObtenerDesicionResult> {

	private List<TieneConceptoConValor> conceptosIngresados;

	public ObtenerDesicionAction() {
	}

	public ObtenerDesicionAction(List<TieneConceptoConValor> conceptosIngresados) {
		this.conceptosIngresados = conceptosIngresados;
	}

	public List<TieneConceptoConValor> getConceptosIngresados() {
		return conceptosIngresados;
	}

	public void setConceptosIngresados(List<TieneConceptoConValor> conceptosIngresados) {
		this.conceptosIngresados = conceptosIngresados;
	}

	@Override
	public String toString() {
		return "ObtenerDesicionAction [conceptosIngresados=" + conceptosIngresados + ", toString()=" + super.toString() + "]";
	}

}
