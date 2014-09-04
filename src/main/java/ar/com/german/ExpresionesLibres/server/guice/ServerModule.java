package ar.com.german.ExpresionesLibres.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import ar.com.german.ExpresionesLibres.server.dispatch.ObtenerDesicionHandler;
import ar.com.german.ExpresionesLibres.shared.modelo.dispatch.ObtenerDesicionAction;

//import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;

public class ServerModule extends HandlerModule {
	@Override
	protected void configureHandlers() {

		bindHandler(ObtenerDesicionAction.class, ObtenerDesicionHandler.class);

	}
}