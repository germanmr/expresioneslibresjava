package ar.com.german.ExpresionesLibres.server.dispatch;

import java.util.Scanner;

import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerEntidadDeCsvAction;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerEntidadDeCsvResult;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class ObtenerEntidadDeCsvHandler implements ActionHandler<ObtenerEntidadDeCsvAction, ObtenerEntidadDeCsvResult> {

	@Inject
	public ObtenerEntidadDeCsvHandler() {
	}

	@Override
	public ObtenerEntidadDeCsvResult execute(ObtenerEntidadDeCsvAction action, ExecutionContext context) throws ActionException {

		Scanner scanner = new Scanner(action.getDatos());

		scanner.useDelimiter(",");

		while (scanner.hasNext()) {
			System.out.print(scanner.next() + "|");
		}

		// Do not forget to close the scanner
		scanner.close();

		return new ObtenerEntidadDeCsvResult();
	}

	@Override
	public Class<ObtenerEntidadDeCsvAction> getActionType() {
		return ObtenerEntidadDeCsvAction.class;
	}

	@Override
	public void undo(ObtenerEntidadDeCsvAction action, ObtenerEntidadDeCsvResult result, ExecutionContext context) throws ActionException {

	}

}
