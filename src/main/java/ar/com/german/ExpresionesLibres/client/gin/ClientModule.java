package ar.com.german.ExpresionesLibres.client.gin;

import ar.com.german.ExpresionesLibres.client.app.ApplicationModule;
import ar.com.german.ExpresionesLibres.client.place.NameTokens;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule());
		install(new RpcDispatchAsyncModule());
		install(new ApplicationModule());

		// bindConstant().annotatedWith(GaAccount.class).to(ANALYTICS_ACCOUNT);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.home);
		bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.home);

	}

}