package ar.com.german.ExpresionesLibres.client;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class BootstrapperImpl implements Bootstrapper {

	private final PlaceManager placeManager;

	@Inject
	public BootstrapperImpl(PlaceManager placeManager) {
		this.placeManager = placeManager;
	}

	@Override
	public void onBootstrap() {
		doSomeCustomLogic();
		placeManager.revealCurrentPlace();
	}

	private void doSomeCustomLogic() {
		// Window.alert("yo soy el boostraper");
		System.out.println("yo soy el boostraper");
	}
}