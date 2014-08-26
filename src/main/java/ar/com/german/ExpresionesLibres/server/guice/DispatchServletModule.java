package ar.com.german.ExpresionesLibres.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.server.guice.HttpSessionSecurityCookieFilter;
import com.gwtplatform.dispatch.shared.SecurityCookie;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {

		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);

		bindConstant().annotatedWith(SecurityCookie.class).to("JSESSIONID");
		filter("*").through(HttpSessionSecurityCookieFilter.class);
		// serve("/" + Action.DEFAULT_SERVICE_NAME +
		// "*").with(DispatchServiceImpl.class);

	}
}