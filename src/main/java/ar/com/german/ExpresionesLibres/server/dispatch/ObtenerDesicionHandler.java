package ar.com.german.ExpresionesLibres.server.dispatch;

import java.util.ArrayList;
import java.util.List;

import ar.com.german.ExpresionesLibres.server.beanshell.Resolutor;
import ar.com.german.ExpresionesLibres.shared.modelo.Comparador;
import ar.com.german.ExpresionesLibres.shared.modelo.Concatenador;
import ar.com.german.ExpresionesLibres.shared.modelo.ConcatenadoresJava;
import ar.com.german.ExpresionesLibres.shared.modelo.Concepto;
import ar.com.german.ExpresionesLibres.shared.modelo.EsComparable;
import ar.com.german.ExpresionesLibres.shared.modelo.Expresion;
import ar.com.german.ExpresionesLibres.shared.modelo.OperadoresSimbolicos;
import ar.com.german.ExpresionesLibres.shared.modelo.Regla;
import ar.com.german.ExpresionesLibres.shared.modelo.TieneValorCadena;
import ar.com.german.ExpresionesLibres.shared.modelo.TiposConceptos;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionAction;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionResult;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class ObtenerDesicionHandler implements ActionHandler<ObtenerDesicionAction, ObtenerDesicionResult> {

	private Resolutor resolutor;

	@Inject
	public ObtenerDesicionHandler(Resolutor resolutor) {
		this.resolutor = resolutor;
	}

	@Override
	public ObtenerDesicionResult execute(ObtenerDesicionAction action, ExecutionContext context) throws ActionException {
		// Los conceptos para que el
		List<EsComparable> conceptos = new ArrayList<>();
		Concepto conceptoPrestacion = new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA);
		conceptos.add(conceptoPrestacion);
		Concepto conceptoObraSocial = new Concepto("obraSocial", "Obra Social", TiposConceptos.CADENA);
		conceptos.add(conceptoObraSocial);

		List<Regla<Integer>> reglas = new ArrayList<Regla<Integer>>();
		List<Expresion> expresiones = new ArrayList<>();
		expresiones.add(new Expresion(new Concepto("prestacion", "Prestacion", TiposConceptos.CADENA), new Comparador("ES IGUAL A ",
				OperadoresSimbolicos.IGUAL), new TieneValorCadena("420101"), new Concatenador(" Ademas ", ConcatenadoresJava.ADEMAS)));
		expresiones.add(new Expresion(new Concepto("obraSocial", "Obra Social", TiposConceptos.CADENA), new Comparador("ES IGUAL A ",
				OperadoresSimbolicos.IGUAL), new TieneValorCadena("220"), new Concatenador(" ninguno ", ConcatenadoresJava.NINGUNO)));
		reglas.add(new Regla<Integer>(expresiones, 220));

		Integer resultado = resolutor.obtenerResultado(conceptos, reglas, action.getConceptosIngresados());

		System.out.println(resultado);

		return new ObtenerDesicionResult(resultado);
	}

	@Override
	public Class<ObtenerDesicionAction> getActionType() {
		return ObtenerDesicionAction.class;
	}

	@Override
	public void undo(ObtenerDesicionAction action, ObtenerDesicionResult result, ExecutionContext context) throws ActionException {
		// TODO Auto-generated method stub

	}

}
