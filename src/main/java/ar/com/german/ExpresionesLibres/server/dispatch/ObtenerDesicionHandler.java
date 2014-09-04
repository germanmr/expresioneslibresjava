package ar.com.german.ExpresionesLibres.server.dispatch;

import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionAction;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionResult;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class ObtenerDesicionHandler implements ActionHandler<ObtenerDesicionAction, ObtenerDesicionResult> {

	@Override
	public ObtenerDesicionResult execute(ObtenerDesicionAction action, ExecutionContext context) throws ActionException {
		return new ObtenerDesicionResult("resultado");
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
