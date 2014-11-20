package ar.com.german.ExpresionesLibres.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Prefix;
import com.google.gwt.user.client.Window;
import com.gwtplatform.mvp.client.PreBootstrapper;

public class PreBootstrapperImpl implements PreBootstrapper {

	@Override
	public void onPreBootstrap() {

		// GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
		// @Override
		// public void onUncaughtException(final Throwable e) {
		// Window.alert("There was a problem loading your application");
		// }
		// });

		System.out.println("yo soy el pre boostraper");

	}
}